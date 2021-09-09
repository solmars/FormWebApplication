/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.antlr.formscript.visitors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import project.FormWebApp.antlr.formscript.DataType;
import project.FormWebApp.antlr.formscript.generated.FormScriptGrammarBaseVisitor;
import project.FormWebApp.antlr.formscript.generated.FormScriptGrammarParser;
import project.FormWebApp.antlr.formscript.generated.FormScriptGrammarParser.FormPhraseContext;
import project.FormWebApp.app.domain.form.FormAttribute;

/**
 * This class validates the grammar rules to be stored in the database on the
 * creation of the form. A different visitor will validate the answers to the
 * form
 *
 * @author Daniel Carvalho
 */
public class FormValidationScriptVisitor extends FormScriptGrammarBaseVisitor<Boolean> {

    /*
    Note: The result of using this visitor to parse can only be true
    If the input isn't lexically or semantically valid an IllegalArgumentException will be thrown
    Please check the other comments in the code to explain how we would return false instead if we wanted to.
     */
    // The variable and the corresponding  datatype 
    private final Map<String, DataType> declaredVariables = new HashMap<>();

    /**
     * Constructor to be used when calling from actual context of the
     * application
     *
     * @param declaredAttributes the already declared attribute list
     */
    public FormValidationScriptVisitor(List<FormAttribute> declaredAttributes) {
        declaredAttributes.forEach(attribute -> declaredVariables.put(attribute.getVariableName(), attribute.getDataType()));
    }

    /*
    Allows non-declared variable creation, but user needs to ensure the input 
    contains the declarations, or an exception will be thrown in runtime (due to validation).
     */
    public FormValidationScriptVisitor() {
        super();
    }

    /**
     * The start of the definition of rules
     *
     * @param ctx StartContext
     * @return true or throws exception if not valid. Note: please check the
     * comments in the methods to see the implementation that would return false
     * if not valid, which would imply using an error list to store the errors.
     */
    @Override
    public Boolean visitStart(FormScriptGrammarParser.StartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Boolean visitExpr(FormScriptGrammarParser.ExprContext ctx) {
        boolean isValid = true;
        for (FormPhraseContext phrase : ctx.formPhrase()) {
            isValid = isValid && visit(phrase);
        }
        return isValid;
        // explicit visit instead of visit children, as we would also want 
        //to cascade the final result in case there was any non-valid and 
        //we wanted to return false instead of throwing an exception
    }

    /**
     *
     * NOTE: there must be consistency between the DataType domain object names
     * and the actual token names This is only so that the grammar also allows
     * to declare the variables, in the context of the project, the User will
     * never have to declare the variables because they were already defined in
     * the attributes before defining the rules.
     *
     * @param ctx DeclarationContext
     * @return true if valid, throws exception if invalid
     */
    @Override
    public Boolean visitDeclaration(FormScriptGrammarParser.DeclarationContext ctx) {
        DataType dataType = DataType.valueOf(ctx.type.getText());
        if (declaredVariables.get(ctx.name.getText()) != null) { // if variable already declared
            throw new IllegalArgumentException("Error at line: " + ctx.name.getLine() + ":" + ctx.name.getCharPositionInLine()
                    + " variable " + ctx.name.getText() + " was already previously declared!");
//            return false; //if we wanted to return the NOTOK/false result recursively, this would be here instead of the throw
        }
        declaredVariables.put(ctx.name.getText(), dataType);
        return true;
    }

    /*Throws IllegalArgumentException if not semantically valid or variable wasn't declared
    Note: we throw an exception instead of storing the errors in a list due to it making more
    sense in the context of the application, as the users are also allowed to write the script line by line.
    We leave the return false as a comment so the reader can see
    what an implementation that recursively returns the result would look like.
     */
    @Override
    public Boolean visitVariableAttribution(FormScriptGrammarParser.VariableAttributionContext ctx) {
        if (!declaredVariables.containsKey(ctx.VARIABLE().getText())) {
            // this is validated in UI/controlled by flow in the UI so should never happen, but it remains here just in case
            throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ": variable " + ctx.VARIABLE().getText() + " wasn't declared!");
//            return false; //if we wanted to return the NOTOK/false result recursively, this would be here instead of the throw
        }
        DataType dataType = declaredVariables.get(ctx.VARIABLE().getText());
        boolean correctType = dataType.lexerValue().equals(ctx.value().start.getType());
        /*will verify if the attribution is actually semantically valid, e.g if
        the variable was defined as an INTEGER, it can't be assigned a DATE*/
        if (!correctType) {
            throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine()
                    + ": Invalid attribution type!" + " variable " + ctx.VARIABLE().getText() + " can't be assigned the value " + ctx.value().getText());
//            return false; //if we wanted to return the NOTOK/false result recursively, this would be here instead of the throw
        }
        //verify if operators are valid in the context of the datatype
        String operator = ctx.COMPARISON_OPERATORS().getText();
        if (operator.equals("<") || operator.equals(">")) {
            if (dataType.equals(DataType.BOOLEAN) || dataType.equals(DataType.DATE) || dataType.equals(DataType.FILE)) {
                throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine()
                        + ": Invalid comparison type!" + " variable " + ctx.VARIABLE().getText() + " can't be compared with operator '" + operator + "'");
            }
        }
        return true;
    }

    @Override
    public Boolean visitObligatoriness(FormScriptGrammarParser.ObligatorinessContext ctx) {
        if (!declaredVariables.containsKey(ctx.VARIABLE().getText())) {
            throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ": variable " + ctx.VARIABLE().getText() + " wasn't declared!");
//            return false; //if we wanted to return the NOTOK/false result recursively, this would be here instead of the throw
        }
        return true;
    }

    @Override
    public Boolean visitVariableComparison(FormScriptGrammarParser.VariableComparisonContext ctx) {
        if (!declaredVariables.containsKey(ctx.VARIABLE(0).getText())) {
            throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ": variable " + ctx.VARIABLE(0).getText() + " wasn't declared!");
//            return false; //if we wanted to return the NOTOK/false result recursively, this would be here instead of the throw
        }
        if (!declaredVariables.containsKey(ctx.VARIABLE(1).getText())) {
            throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ": variable " + ctx.VARIABLE(1).getText() + " wasn't declared!");
//            return false; //if we wanted to return the NOTOK/false result recursively, this would be here instead of the throw
        }

        DataType dataType_1 = declaredVariables.get(ctx.VARIABLE(0).getText());
        DataType dataType_2 = declaredVariables.get(ctx.VARIABLE(1).getText());

        if (!dataType_1.equals(dataType_2)) {
            throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ": variable "
                    + ctx.VARIABLE(0).getText() + " can't be compared with variable " + ctx.VARIABLE(1).getText() + "!");
        }
        //verify if operators are valid in the context of the datatype
        String operator = ctx.COMPARISON_OPERATORS().getText();
        if (operator.equals("<") || operator.equals(">")) {
            //non allowed comparisons.
            if (dataType_1.equals(DataType.BOOLEAN) || dataType_1.equals(DataType.FILE)) {
                throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine()
                        + ": Invalid comparison type!" + " the vairables can't be compared with operator '" + operator + "'");
            }
        }
        return true;
    }

    @Override
    public Boolean visitMulDiv(FormScriptGrammarParser.MulDivContext ctx) {
        return visit(ctx.left) && visit(ctx.right);

    }

    @Override
    public Boolean visitSumDif(FormScriptGrammarParser.SumDifContext ctx) {
        return visit(ctx.left) && visit(ctx.right);
    }

    @Override
    public Boolean visitCalculationAtom(FormScriptGrammarParser.CalculationAtomContext ctx) {
        if (!declaredVariables.containsKey(ctx.VARIABLE().getText())) {
            throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ": variable " + ctx.VARIABLE().getText() + " wasn't declared!");
        }
        DataType dataType = declaredVariables.get(ctx.VARIABLE().getText());
        if (!dataType.equals(DataType.INTEGER)) {
            //only calculation of integer type is allowed.
            throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ": variable " + ctx.VARIABLE().getText() + " is not an integer!");

        }

        return true;
    }

    @Override
    public Boolean visitVariableCompCalculation(FormScriptGrammarParser.VariableCompCalculationContext ctx) {
        if (!declaredVariables.containsKey(ctx.VARIABLE().getText())) {
            throw new IllegalArgumentException("Semantic error at line: " + ctx.getStart().getLine() + ": variable " + ctx.VARIABLE().getText() + " wasn't declared!");
        }
        return visit(ctx.formCalculation());
    }

    @Override
    public Boolean visitVariableComparisonCalculation(FormScriptGrammarParser.VariableComparisonCalculationContext ctx) {
        return visit(ctx.variableCompCalculation());
    }

    @Override
    public Boolean visitVariableComparisonPhrase(FormScriptGrammarParser.VariableComparisonPhraseContext ctx) {
        return visit(ctx.variableComparison());
    }

    @Override
    public Boolean visitDeclarationPhrase(FormScriptGrammarParser.DeclarationPhraseContext ctx) {
        return visit(ctx.declaration());// explicit visit instead of visit children
    }

    @Override
    public Boolean visitObligatorinessPhrase(FormScriptGrammarParser.ObligatorinessPhraseContext ctx) {
        return visit(ctx.obligatoriness());// explicit visit instead of visit children
    }

    @Override
    public Boolean visitVariableAttributionObligatorinessConditional(FormScriptGrammarParser.VariableAttributionObligatorinessConditionalContext ctx) {
        return visit(ctx.variableAttribution()) && visit(ctx.obligatoriness());// explicit visit instead of visit children
    }

    @Override
    public Boolean visitTwoVariableAttributionConditional(FormScriptGrammarParser.TwoVariableAttributionConditionalContext ctx) {
        return visit(ctx.variableAttribution(0)) && visit(ctx.variableAttribution(1)); // explicit visit instead of visit children
    }

    @Override
    public Boolean visitValue(FormScriptGrammarParser.ValueContext ctx) {
        return true; // don't care about visiting the children.
    }

}
