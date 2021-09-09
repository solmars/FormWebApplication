/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.antlr.formscript.visitors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import project.FormWebApp.antlr.formscript.DataType;
import project.FormWebApp.antlr.formscript.Regex;
import project.FormWebApp.antlr.formscript.generated.*;
import project.FormWebApp.antlr.formscript.generated.FormScriptGrammarParser.*;
import project.FormWebApp.app.domain.form.Answer;
import project.FormWebApp.app.domain.general.Pair;

/**
 *
 * @author Daniel Carvalho
 */
public class FormAnswerScriptVisitor extends FormScriptGrammarBaseVisitor<Boolean> {

    private final Set<String> errorsFound = new HashSet<>();
    /*
    Note: when using this visitor, you must ensure the input contains the previously defined rules.
    
     */
    //variable, with a Pair that will contain the answer, and another pair, with the getRegularExp and the associated getDataType
    private final Map<String, Pair<Pair<Regex, DataType>, String>> answerInfoMap = new HashMap<>();

    private final Map<String, List<ParserRuleContext>> variableWithListOfRuleContextMap = new HashMap<>();

    //stack for calculations since this is boolean return type we can't return the result.
    private final Stack<Integer> stack = new Stack<>();

    /**
     * Constructor to be used when calling from actual context of the
     * application
     *
     * @param answers the answer object ( contains a string with the answer and
     * the formAttribute it corresponds to) list
     */
    public FormAnswerScriptVisitor(List<Answer> answers) {
        answers.forEach(answer -> {
            answerInfoMap.put(
                    answer.formAttribute().getVariableName(),
                    new Pair(
                            new Pair(new Regex(answer.formAttribute().getRegularExp()), answer.formAttribute().getDataType()), answer.answer())
            );
            variableWithListOfRuleContextMap.put(answer.formAttribute().getVariableName(), new ArrayList<>());
        }
        );

    }

    /*
    Allows non-declared variable creation, but user needs to ensure the input 
    contains the declarations, or an exception will be thrown in runtime (due to validation).
     */
    public FormAnswerScriptVisitor() {
        super();
    }

    @Override
    public Boolean visitStart(FormScriptGrammarParser.StartContext ctx) {
        visitChildren(ctx);//visit the children
        //after visiting the children, we have collected all the contexts associated to each variable
        //loop the answers with the respective context information collected
        answerInfoMap.entrySet().forEach((Map.Entry<String, Pair<Pair<Regex, DataType>, String>> entry) -> {
            //initialize variables
            String variable = entry.getKey();
            String regex = entry.getValue().getKey().getKey().regex;
            DataType dataType = entry.getValue().getKey().getValue();
            String answer = entry.getValue().getValue();
            List<ParserRuleContext> specificVariableRules = variableWithListOfRuleContextMap.get(variable);

            if (answer.isEmpty()) { // obligatoriness checks
                this.validateObligatoriness(variable, specificVariableRules);
                //implicit else, meaning no error found because it wasn't necessary to fill the attribute
            } else { // if answer not empty
                if (regex.isEmpty()) {
                    // if no getRegularExp was specified on creation, we will assume it has to match the specific type defined in the lexer
                    validateCorrectDataTypeAnswer(variable, dataType, answer);
                } else { // if the user specified a  getRegularExp on the attribute, we assume the getRegularExp that was specified is a subset of the datatype.
                    Pattern p = Pattern.compile(regex);
                    if (!p.matcher(answer).matches()) {
                        errorsFound.add("Attribute " + variable + " did not have a valid answer! (regular expression not obeyed!)");
                    }
                }
                //check for the (IF variable1=1 THEN variable2 = 3;) type of phrases
                this.validateTwoVariableAttributionConditionalContextAnswers(specificVariableRules, variable, answer);
                //check for (v_1 > v_4) (variableComparison) type of phrases
                this.validateVariableComparisonAnswers(dataType, specificVariableRules);
                //finally, check for (v1 > v1*v2*v3) type of phrases.
                this.validateVariableComparisonCalculationAnswers(answer, specificVariableRules);
            }
        });
        return this.errorsFound.isEmpty(); // if is empty, answers were valid.
    }

    @Override
    public Boolean visitExpr(FormScriptGrammarParser.ExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Boolean visitDeclaration(FormScriptGrammarParser.DeclarationContext ctx) {
        return true;
    }

    @Override
    public Boolean visitVariableAttribution(FormScriptGrammarParser.VariableAttributionContext ctx) {
        return true;
    }

    @Override
    public Boolean visitObligatoriness(FormScriptGrammarParser.ObligatorinessContext ctx) {
        variableWithListOfRuleContextMap.get(ctx.VARIABLE().getText()).add(ctx);
        return true; // don't want to visit children
    }

    @Override
    public Boolean visitDeclarationPhrase(FormScriptGrammarParser.DeclarationPhraseContext ctx) {
        return true; // 
    }

    @Override
    public Boolean visitObligatorinessPhrase(FormScriptGrammarParser.ObligatorinessPhraseContext ctx) {
        return visit(ctx.obligatoriness()); // explicit visit
    }

    @Override
    public Boolean visitVariableAttributionObligatorinessConditional(FormScriptGrammarParser.VariableAttributionObligatorinessConditionalContext ctx) {
        variableWithListOfRuleContextMap.get(ctx.variableAttribution().VARIABLE().getText()).add(ctx);
        variableWithListOfRuleContextMap.get(ctx.obligatoriness().VARIABLE().getText()).add(ctx);
        //add to both variable context lists so that we don't have to check the map multiple times

        return true;
    }

    @Override
    public Boolean visitVariableComparisonPhrase(VariableComparisonPhraseContext ctx) {
        variableWithListOfRuleContextMap.get(ctx.variableComparison().VARIABLE(0).getText()).add(ctx);
        variableWithListOfRuleContextMap.get(ctx.variableComparison().VARIABLE(1).getText()).add(ctx);

        return true;
    }

    @Override
    public Boolean visitTwoVariableAttributionConditional(FormScriptGrammarParser.TwoVariableAttributionConditionalContext ctx) {
        variableWithListOfRuleContextMap.get(ctx.variableAttribution().get(0).VARIABLE().getText()).add(ctx);
        variableWithListOfRuleContextMap.get(ctx.variableAttribution().get(1).VARIABLE().getText()).add(ctx);
        //add to both variable context lists so that we don't have to check the map multiple times
        return true;
    }

    @Override
    public Boolean visitMulDiv(FormScriptGrammarParser.MulDivContext ctx) {
        visit(ctx.left);
        visit(ctx.right);
        Integer rightSide = stack.pop();
        if (rightSide == 0) { // if division by zero, substitute to 1
            rightSide = 1;
        }
        Integer leftSide = stack.pop();
        Integer res = 0;
        if (ctx.op.getText().equals("*")) {
            res = leftSide * rightSide;
        } else {
            res = leftSide / rightSide;

        }
        stack.push(res);
        return true;
    }

    @Override
    public Boolean visitSumDif(FormScriptGrammarParser.SumDifContext ctx) {
        visit(ctx.left);
        visit(ctx.right);
        Integer rightSide = stack.pop();
        Integer leftSide = stack.pop();
        Integer res;
        if (ctx.op.getText().equals("+")) {
            res = leftSide + rightSide;
        } else {
            res = leftSide - rightSide;
        }
        stack.push(res);
        return true;
    }

    @Override
    public Boolean visitCalculationAtom(FormScriptGrammarParser.CalculationAtomContext ctx) {

        // will always be int because it is validated before this will be called.
        try {
            stack.push(Integer.valueOf(this.answerInfoMap.get(ctx.VARIABLE().getText()).getValue()));
        } catch (NumberFormatException e) { // if an exception ocurred, for instance, the answer wasn't an integer, then push 1
            // we can do this because it means an error was already previously found so we don't have to add an error here.
            stack.push(1);
        }

        return true;
    }

    @Override
    public Boolean visitVariableCompCalculation(FormScriptGrammarParser.VariableCompCalculationContext ctx) {
        return visit(ctx.formCalculation());
    }

    @Override
    public Boolean visitVariableComparisonCalculation(FormScriptGrammarParser.VariableComparisonCalculationContext ctx) {
        this.variableWithListOfRuleContextMap.get(ctx.variableCompCalculation().VARIABLE().getText()).add(ctx);
        //DON'T visit children because we will call visitVariableCompCalculation directly.
        return true;
    }

    @Override
    public Boolean visitValue(FormScriptGrammarParser.ValueContext ctx) {
        return true;
    }

    public List<String> listOfErrors() {
        return new ArrayList<>(errorsFound);
    }

    private void validateObligatoriness(String variable, List<ParserRuleContext> specificVariableRules) {
        // if answer is empty, we will check if it is obligatory for it not to be empty
        // check if has ObligatorinessContext (something like "v_2 OBLIGATORY")
        boolean hasObligatoryContext = this.hasInstanceOf(specificVariableRules, ObligatorinessContext.class);

        //check if has ObligatorinessPhraseContext (something like "v_2 OBLIGATORY;"
        boolean hasObligatoryPhraseContext = this.hasInstanceOf(specificVariableRules, ObligatorinessPhraseContext.class);

        //check if has ConditionalObligatorinessContext (something like "IF v_1 = 2 THEN v_2 OBLIGATORY;"
        boolean hasConditionalObligatorinessContext
                = this.hasInstanceOf(specificVariableRules, VariableAttributionObligatorinessConditionalContext.class);

        if (hasObligatoryContext || hasObligatoryPhraseContext) { // if it had obligatory context or ObligatoryPhraseContext
            errorsFound.add("Attribute " + variable + " had an empty answer when not allowed!");
        } else if (hasConditionalObligatorinessContext) {
            /* if it didn't have obligatory context but had
                    obligatoryPhraseContext we will check if there
                    is anything that makes it obligatory*/
            // get all obligatoriness phrase context
            List<VariableAttributionObligatorinessConditionalContext> conditionalList = obtainConditionalObligatorinessPhraseContextList(specificVariableRules);
            conditionalList.forEach(context -> {
                // the conditional variable CAN NOT be the same as the variable we are checking
                String conditionalVariable = context.variableAttribution().VARIABLE().getText();
                if (!(conditionalVariable.equals(variable))) {
                    String associatedValue = context.variableAttribution().value().getText();
                    String associatedOperator = context.variableAttribution().COMPARISON_OPERATORS().getText();
                    // now, we must check if the variable that would trigger the obligatoriness has an answer that obeys the defined logic
                    boolean isObligatory = isConditionallyObligatory(conditionalVariable, associatedValue, associatedOperator);
                    if (isObligatory) {
                        errorsFound.add("Attribute " + variable
                                + " had an empty answer when not allowed, due to variable " + conditionalVariable + " having a conditional setting effect!");
                    }
                }
            });

        }
    }

    private void validateCorrectDataTypeAnswer(String variable, DataType dataType, String answer) {
        FormScriptGrammarLexer lexer = new FormScriptGrammarLexer(CharStreams.fromString(answer));
        lexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        if (tokens.getNumberOfOnChannelTokens() == 2) { // has to be 2, one due to token, other due to <EOF>
            Token token = tokens.get(0); // this will always be the correct one because <EOF> is the last
            if (!dataType.lexerValue().equals(token.getType())) { // if datatype is different then
                errorsFound.add("Attribute " + variable + " did not have a valid answer!");
            }
        } else { // has more or less tokens than it should.
            errorsFound.add("Attribute " + variable + " did not have a valid answer!");
        }

    }

    private void validateTwoVariableAttributionConditionalContextAnswers(List<ParserRuleContext> specificVariableRules, String variable, String answer) {
        List<TwoVariableAttributionConditionalContext> contextList = this.obtainTwoAttributionConditionalList(specificVariableRules);
        contextList.forEach(context -> {
            // if left side is the same variable we are validating, then skip
            String leftSideVariable = context.variableAttribution(0).VARIABLE().getText();
            if (!(leftSideVariable.equals(variable))) {
                String leftSideOperator = context.variableAttribution(0).COMPARISON_OPERATORS().getText();
                String leftSideValue = context.variableAttribution(0).value().getText();
                String leftSideAnswer = this.answerInfoMap.get(leftSideVariable).getValue();
                String rightSideOperator = context.variableAttribution(1).COMPARISON_OPERATORS().getText();
                String rightSideValue = context.variableAttribution(1).value().getText();
                boolean compliesWithRules = compliesWithTwoAttributionRules(leftSideOperator, leftSideValue, leftSideAnswer, rightSideOperator, rightSideValue, answer);
                if (!compliesWithRules) {
                    errorsFound.add("Attribute " + variable
                            + " had non allowed answer, due to variable " + leftSideVariable + " having a conditional setting effect!");
                }
            }
        });

    }

    private void validateVariableComparisonAnswers(DataType dataType, List<ParserRuleContext> specificVariableRules) {
        List<VariableComparisonPhraseContext> compList = this.obtainVariableComparisonPhraseList(specificVariableRules);
        compList.forEach(context -> {
            // if left side is the same variable we are validating, then skip
            String leftSideVariable = context.variableComparison().VARIABLE(0).getText();
            String rightSideVariable = context.variableComparison().VARIABLE(1).getText();
            String leftSideValue = this.answerInfoMap.get(leftSideVariable).getValue();
            String rightSideValue = this.answerInfoMap.get(rightSideVariable).getValue();
            String operator = context.variableComparison().COMPARISON_OPERATORS().getText();
            if (dataType.equals(DataType.DATE)) {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date leftDate = df.parse(leftSideValue);
                    Date rightDate = df.parse(rightSideValue);
                    if (!datesComplyWithRules(leftDate, rightDate, operator)) {
                        errorsFound.add("The date relationship: " + context.variableComparison().getText() + " wasn't obeyed!");
                    }
                } catch (ParseException ex) {
                    // should never happen
                    errorsFound.add("\nUnparseable date!");
                }
            } else {
                //integer and string (others aren't allowed to pass the FormValidationScriptVisitor)
                int compare = 0;
                if (dataType.equals(DataType.INTEGER)) {
                    try {
                        compare = Integer.compare(Integer.valueOf(leftSideValue), Integer.valueOf(rightSideValue));
                    } catch (NumberFormatException e) {
                        //do nothing, it means an error had already been found
                    }
                } else {
                    compare = leftSideValue.compareTo(rightSideValue);
                }
                if (!this.compareVariableValues(operator, compare)) {
                    errorsFound.add(leftSideVariable + " must be '" + operator + "' to/than " + rightSideVariable + "!");
                }
            }
        });
    }

    private void validateVariableComparisonCalculationAnswers(String answer, List<ParserRuleContext> specificVariableRules) {
        List<VariableComparisonCalculationContext> calcContext = this.obtainVariableComparisonCalculationPhraseList(specificVariableRules);
        for (VariableComparisonCalculationContext c : calcContext) {
            visit(c.variableCompCalculation()); // after visiting, value is in stack.
            Integer rightSideResult = stack.pop();
            String operator = c.variableCompCalculation().COMPARISON_OPERATORS().getText();
            stack.clear(); // clear stack just in case
            try {
                int compare = Integer.valueOf(answer).compareTo(rightSideResult);
                if (!this.compareVariableValues(operator, compare)) {
                    errorsFound.add(c.variableCompCalculation().getText() + " was not obeyed!");
                }
            } catch (NumberFormatException e) {
                //do nothing (it means answer wasn't of correct type, which means this error had already been found.
            }
        }

    }

    private boolean hasInstanceOf(List<ParserRuleContext> lst, Class instance) {
        return lst.stream().anyMatch(instance::isInstance); // checks if the list contains the target instacne class
    }

    private List<VariableAttributionObligatorinessConditionalContext> obtainConditionalObligatorinessPhraseContextList(List<ParserRuleContext> rules) {
        List<VariableAttributionObligatorinessConditionalContext> lst = new ArrayList<>();
        rules.stream().filter(context -> (context instanceof VariableAttributionObligatorinessConditionalContext)).forEach(context -> {
            lst.add((VariableAttributionObligatorinessConditionalContext) context); // valid cast
        });
        return lst;
    }

    private List<TwoVariableAttributionConditionalContext> obtainTwoAttributionConditionalList(List<ParserRuleContext> rules) {
        List<TwoVariableAttributionConditionalContext> lst = new ArrayList<>();
        rules.stream().filter(context -> (context instanceof TwoVariableAttributionConditionalContext)).forEach(context -> {
            lst.add((TwoVariableAttributionConditionalContext) context); // valid cast
        });
        return lst;
    }

    private List<VariableComparisonPhraseContext> obtainVariableComparisonPhraseList(List<ParserRuleContext> rules) {
        List<VariableComparisonPhraseContext> lst = new ArrayList<>();
        rules.stream().filter(context -> (context instanceof VariableComparisonPhraseContext)).forEach(context -> {
            lst.add((VariableComparisonPhraseContext) context); // valid cast
        });
        return lst;
    }

    private List<VariableComparisonCalculationContext> obtainVariableComparisonCalculationPhraseList(List<ParserRuleContext> rules) {
        List<VariableComparisonCalculationContext> lst = new ArrayList<>();
        rules.stream().filter(context -> (context instanceof VariableComparisonCalculationContext)).forEach(context -> {
            lst.add((VariableComparisonCalculationContext) context); // valid cast
        });
        return lst;
    }

    private boolean isConditionallyObligatory(String conditionalVariable, String associatedValue, String associatedOperator) {
        String conditionalVariableAnswer = this.answerInfoMap.get(conditionalVariable).getValue();
        int compare = -1;
        try { // if it works, it means the getDataType was an integer
            compare = Integer.compare(Integer.valueOf(conditionalVariableAnswer), Integer.valueOf(associatedValue));
        } catch (NumberFormatException e) {
            //it means an error had already been found, or that datatype isn't an integer
            compare = conditionalVariableAnswer.compareTo(associatedValue); // string comparator

        }

        return this.compareVariableValues(associatedOperator, compare);
    }

    //validates answers that have contexts like (IF v_1 >= 2 THEN v_2 = 5;)
    /*
    Will return true if the variable either obeyed the rule, or it didn't have to obey the rule.
     */
    private boolean compliesWithTwoAttributionRules(String leftSideOperator, String leftSideValue, String leftSideAnswer, String rightSideOperator, String rightSideValue, String rightSideAnswer) {
        /*we use string comparator, as it works for both Integer and String,
        and other dataTypes aren't allowed to have operators '<' and '>'*/
        int compareLeft = leftSideAnswer.toUpperCase().compareTo(leftSideValue.toUpperCase());
        boolean leftValid = this.compareAttribution(leftSideOperator, compareLeft);
        if (leftValid == false) { // leftSide doesn't even check, that means it complies with the rules
            return true;
        }
        int compareRight = rightSideAnswer.toUpperCase().compareTo(rightSideValue.toUpperCase());
        boolean rightValid = this.compareAttribution(rightSideOperator, compareRight);
        return rightValid; // both have to be true, and leftValid is true if it gets here
    }

    private boolean compareAttribution(String operator, int compare) {
        switch (operator) {
            case ">":
                if (compare < 1) {
                    return false; // return false because this side doesn't match
                }
                break;
            case "=":
                if (compare != 0) {
                    return false; // return false because this side doesn't match
                }

                break;
            case "<":
                if (compare > -1) {
                    return false; // return false because this side doesn't match
                }
                break;

        }
        return true;

    }

    private boolean compareVariableValues(String operator, int compare) {
        switch (operator) {
            case ">":
                if (compare >= 1) {
                    return true; // return false because this side doesn't match
                }
                break;
            case "=":
                if (compare == 0) {
                    return true; // return false because this side doesn't match
                }

                break;
            case "<":
                if (compare <= -1) {
                    return true; // return false because this side doesn't match
                }
                break;

        }
        return false;

    }

    private boolean datesComplyWithRules(Date leftDate, Date rightDate, String operator) {
        switch (operator) {
            case "<": {
                return leftDate.before(rightDate);
            }

            case "=": {
                return leftDate.equals(rightDate);
            }

            case ">": {
                return leftDate.after(rightDate);
            }
        }
        return false;
    }

}
