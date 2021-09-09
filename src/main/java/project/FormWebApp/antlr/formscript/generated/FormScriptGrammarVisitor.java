// Generated from FormScriptGrammar.g4 by ANTLR 4.9.2
package project.FormWebApp.antlr.formscript.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormScriptGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormScriptGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormScriptGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FormScriptGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormScriptGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(FormScriptGrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code twoVariableAttributionConditional}
	 * labeled alternative in {@link FormScriptGrammarParser#formPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTwoVariableAttributionConditional(FormScriptGrammarParser.TwoVariableAttributionConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableAttributionObligatorinessConditional}
	 * labeled alternative in {@link FormScriptGrammarParser#formPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAttributionObligatorinessConditional(FormScriptGrammarParser.VariableAttributionObligatorinessConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableComparisonPhrase}
	 * labeled alternative in {@link FormScriptGrammarParser#formPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableComparisonPhrase(FormScriptGrammarParser.VariableComparisonPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code obligatorinessPhrase}
	 * labeled alternative in {@link FormScriptGrammarParser#formPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObligatorinessPhrase(FormScriptGrammarParser.ObligatorinessPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationPhrase}
	 * labeled alternative in {@link FormScriptGrammarParser#formPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationPhrase(FormScriptGrammarParser.DeclarationPhraseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableComparisonCalculation}
	 * labeled alternative in {@link FormScriptGrammarParser#formPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableComparisonCalculation(FormScriptGrammarParser.VariableComparisonCalculationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormScriptGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(FormScriptGrammarParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormScriptGrammarParser#variableComparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableComparison(FormScriptGrammarParser.VariableComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormScriptGrammarParser#variableAttribution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAttribution(FormScriptGrammarParser.VariableAttributionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormScriptGrammarParser#variableCompCalculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableCompCalculation(FormScriptGrammarParser.VariableCompCalculationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormScriptGrammarParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(FormScriptGrammarParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormScriptGrammarParser#obligatoriness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObligatoriness(FormScriptGrammarParser.ObligatorinessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calculationAtom}
	 * labeled alternative in {@link FormScriptGrammarParser#formCalculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculationAtom(FormScriptGrammarParser.CalculationAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumDif}
	 * labeled alternative in {@link FormScriptGrammarParser#formCalculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumDif(FormScriptGrammarParser.SumDifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link FormScriptGrammarParser#formCalculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(FormScriptGrammarParser.MulDivContext ctx);
}