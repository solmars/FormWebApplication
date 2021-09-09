// Generated from FormScriptGrammar.g4 by ANTLR 4.9.2
package project.FormWebApp.antlr.formscript.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormScriptGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, DATE=6, FILE=7, INTEGER=8, STRING=9, 
		BOOLEAN=10, IF=11, THEN=12, VARIABLE=13, ATTRIBUTION=14, COMPARISON_OPERATORS=15, 
		OBLIGATORY=16, ENDLINE=17, WS=18;
	public static final int
		RULE_start = 0, RULE_expr = 1, RULE_formPhrase = 2, RULE_value = 3, RULE_variableComparison = 4, 
		RULE_variableAttribution = 5, RULE_variableCompCalculation = 6, RULE_declaration = 7, 
		RULE_obligatoriness = 8, RULE_formCalculation = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "expr", "formPhrase", "value", "variableComparison", "variableAttribution", 
			"variableCompCalculation", "declaration", "obligatoriness", "formCalculation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'IS'", "'*'", "'/'", "'+'", "'-'", null, null, null, null, null, 
			null, null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "DATE", "FILE", "INTEGER", "STRING", 
			"BOOLEAN", "IF", "THEN", "VARIABLE", "ATTRIBUTION", "COMPARISON_OPERATORS", 
			"OBLIGATORY", "ENDLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FormScriptGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormScriptGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<FormPhraseContext> formPhrase() {
			return getRuleContexts(FormPhraseContext.class);
		}
		public FormPhraseContext formPhrase(int i) {
			return getRuleContext(FormPhraseContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				formPhrase();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IF || _la==VARIABLE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormPhraseContext extends ParserRuleContext {
		public FormPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formPhrase; }
	 
		public FormPhraseContext() { }
		public void copyFrom(FormPhraseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TwoVariableAttributionConditionalContext extends FormPhraseContext {
		public TerminalNode IF() { return getToken(FormScriptGrammarParser.IF, 0); }
		public List<VariableAttributionContext> variableAttribution() {
			return getRuleContexts(VariableAttributionContext.class);
		}
		public VariableAttributionContext variableAttribution(int i) {
			return getRuleContext(VariableAttributionContext.class,i);
		}
		public TerminalNode THEN() { return getToken(FormScriptGrammarParser.THEN, 0); }
		public TerminalNode ENDLINE() { return getToken(FormScriptGrammarParser.ENDLINE, 0); }
		public TwoVariableAttributionConditionalContext(FormPhraseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitTwoVariableAttributionConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableAttributionObligatorinessConditionalContext extends FormPhraseContext {
		public TerminalNode IF() { return getToken(FormScriptGrammarParser.IF, 0); }
		public VariableAttributionContext variableAttribution() {
			return getRuleContext(VariableAttributionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(FormScriptGrammarParser.THEN, 0); }
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(FormScriptGrammarParser.ENDLINE, 0); }
		public VariableAttributionObligatorinessConditionalContext(FormPhraseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitVariableAttributionObligatorinessConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObligatorinessPhraseContext extends FormPhraseContext {
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(FormScriptGrammarParser.ENDLINE, 0); }
		public ObligatorinessPhraseContext(FormPhraseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitObligatorinessPhrase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableComparisonCalculationContext extends FormPhraseContext {
		public VariableCompCalculationContext variableCompCalculation() {
			return getRuleContext(VariableCompCalculationContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(FormScriptGrammarParser.ENDLINE, 0); }
		public VariableComparisonCalculationContext(FormPhraseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitVariableComparisonCalculation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarationPhraseContext extends FormPhraseContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(FormScriptGrammarParser.ENDLINE, 0); }
		public DeclarationPhraseContext(FormPhraseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitDeclarationPhrase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableComparisonPhraseContext extends FormPhraseContext {
		public VariableComparisonContext variableComparison() {
			return getRuleContext(VariableComparisonContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(FormScriptGrammarParser.ENDLINE, 0); }
		public VariableComparisonPhraseContext(FormPhraseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitVariableComparisonPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormPhraseContext formPhrase() throws RecognitionException {
		FormPhraseContext _localctx = new FormPhraseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_formPhrase);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new TwoVariableAttributionConditionalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(IF);
				setState(28);
				variableAttribution();
				setState(29);
				match(THEN);
				setState(30);
				variableAttribution();
				setState(31);
				match(ENDLINE);
				}
				break;
			case 2:
				_localctx = new VariableAttributionObligatorinessConditionalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				match(IF);
				setState(34);
				variableAttribution();
				setState(35);
				match(THEN);
				setState(36);
				obligatoriness();
				setState(37);
				match(ENDLINE);
				}
				break;
			case 3:
				_localctx = new VariableComparisonPhraseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				variableComparison();
				setState(40);
				match(ENDLINE);
				}
				break;
			case 4:
				_localctx = new ObligatorinessPhraseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				obligatoriness();
				setState(43);
				match(ENDLINE);
				}
				break;
			case 5:
				_localctx = new DeclarationPhraseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				declaration();
				setState(46);
				match(ENDLINE);
				}
				break;
			case 6:
				_localctx = new VariableComparisonCalculationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(48);
				variableCompCalculation();
				setState(49);
				match(ENDLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(FormScriptGrammarParser.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(FormScriptGrammarParser.BOOLEAN, 0); }
		public TerminalNode FILE() { return getToken(FormScriptGrammarParser.FILE, 0); }
		public TerminalNode STRING() { return getToken(FormScriptGrammarParser.STRING, 0); }
		public TerminalNode DATE() { return getToken(FormScriptGrammarParser.DATE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATE) | (1L << FILE) | (1L << INTEGER) | (1L << STRING) | (1L << BOOLEAN))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableComparisonContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE() { return getTokens(FormScriptGrammarParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(FormScriptGrammarParser.VARIABLE, i);
		}
		public TerminalNode COMPARISON_OPERATORS() { return getToken(FormScriptGrammarParser.COMPARISON_OPERATORS, 0); }
		public VariableComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableComparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitVariableComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableComparisonContext variableComparison() throws RecognitionException {
		VariableComparisonContext _localctx = new VariableComparisonContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableComparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(VARIABLE);
			setState(56);
			match(COMPARISON_OPERATORS);
			setState(57);
			match(VARIABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableAttributionContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(FormScriptGrammarParser.VARIABLE, 0); }
		public TerminalNode COMPARISON_OPERATORS() { return getToken(FormScriptGrammarParser.COMPARISON_OPERATORS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VariableAttributionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAttribution; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitVariableAttribution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAttributionContext variableAttribution() throws RecognitionException {
		VariableAttributionContext _localctx = new VariableAttributionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableAttribution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(VARIABLE);
			setState(60);
			match(COMPARISON_OPERATORS);
			setState(61);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableCompCalculationContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(FormScriptGrammarParser.VARIABLE, 0); }
		public TerminalNode COMPARISON_OPERATORS() { return getToken(FormScriptGrammarParser.COMPARISON_OPERATORS, 0); }
		public FormCalculationContext formCalculation() {
			return getRuleContext(FormCalculationContext.class,0);
		}
		public VariableCompCalculationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableCompCalculation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitVariableCompCalculation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableCompCalculationContext variableCompCalculation() throws RecognitionException {
		VariableCompCalculationContext _localctx = new VariableCompCalculationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableCompCalculation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(VARIABLE);
			setState(64);
			match(COMPARISON_OPERATORS);
			setState(65);
			formCalculation(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public Token name;
		public Token type;
		public TerminalNode VARIABLE() { return getToken(FormScriptGrammarParser.VARIABLE, 0); }
		public TerminalNode ATTRIBUTION() { return getToken(FormScriptGrammarParser.ATTRIBUTION, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			((DeclarationContext)_localctx).name = match(VARIABLE);
			setState(68);
			match(T__0);
			setState(69);
			((DeclarationContext)_localctx).type = match(ATTRIBUTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObligatorinessContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(FormScriptGrammarParser.VARIABLE, 0); }
		public TerminalNode OBLIGATORY() { return getToken(FormScriptGrammarParser.OBLIGATORY, 0); }
		public ObligatorinessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obligatoriness; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitObligatoriness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObligatorinessContext obligatoriness() throws RecognitionException {
		ObligatorinessContext _localctx = new ObligatorinessContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_obligatoriness);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(VARIABLE);
			setState(72);
			match(OBLIGATORY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormCalculationContext extends ParserRuleContext {
		public FormCalculationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formCalculation; }
	 
		public FormCalculationContext() { }
		public void copyFrom(FormCalculationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CalculationAtomContext extends FormCalculationContext {
		public Token atom;
		public TerminalNode VARIABLE() { return getToken(FormScriptGrammarParser.VARIABLE, 0); }
		public CalculationAtomContext(FormCalculationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitCalculationAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumDifContext extends FormCalculationContext {
		public FormCalculationContext left;
		public Token op;
		public FormCalculationContext right;
		public List<FormCalculationContext> formCalculation() {
			return getRuleContexts(FormCalculationContext.class);
		}
		public FormCalculationContext formCalculation(int i) {
			return getRuleContext(FormCalculationContext.class,i);
		}
		public SumDifContext(FormCalculationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitSumDif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends FormCalculationContext {
		public FormCalculationContext left;
		public Token op;
		public FormCalculationContext right;
		public List<FormCalculationContext> formCalculation() {
			return getRuleContexts(FormCalculationContext.class);
		}
		public FormCalculationContext formCalculation(int i) {
			return getRuleContext(FormCalculationContext.class,i);
		}
		public MulDivContext(FormCalculationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormScriptGrammarVisitor ) return ((FormScriptGrammarVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormCalculationContext formCalculation() throws RecognitionException {
		return formCalculation(0);
	}

	private FormCalculationContext formCalculation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormCalculationContext _localctx = new FormCalculationContext(_ctx, _parentState);
		FormCalculationContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_formCalculation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new CalculationAtomContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(75);
			((CalculationAtomContext)_localctx).atom = match(VARIABLE);
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new FormCalculationContext(_parentctx, _parentState));
						((MulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formCalculation);
						setState(77);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(78);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__2) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						((MulDivContext)_localctx).right = formCalculation(4);
						}
						break;
					case 2:
						{
						_localctx = new SumDifContext(new FormCalculationContext(_parentctx, _parentState));
						((SumDifContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formCalculation);
						setState(80);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(81);
						((SumDifContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((SumDifContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(82);
						((SumDifContext)_localctx).right = formCalculation(3);
						}
						break;
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return formCalculation_sempred((FormCalculationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formCalculation_sempred(FormCalculationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24[\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\3\6\3\32\n\3\r\3\16\3\33\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\66\n"+
		"\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13V\n"+
		"\13\f\13\16\13Y\13\13\3\13\2\3\24\f\2\4\6\b\n\f\16\20\22\24\2\5\3\2\b"+
		"\f\3\2\4\5\3\2\6\7\2X\2\26\3\2\2\2\4\31\3\2\2\2\6\65\3\2\2\2\b\67\3\2"+
		"\2\2\n9\3\2\2\2\f=\3\2\2\2\16A\3\2\2\2\20E\3\2\2\2\22I\3\2\2\2\24L\3\2"+
		"\2\2\26\27\5\4\3\2\27\3\3\2\2\2\30\32\5\6\4\2\31\30\3\2\2\2\32\33\3\2"+
		"\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\5\3\2\2\2\35\36\7\r\2\2\36\37\5\f"+
		"\7\2\37 \7\16\2\2 !\5\f\7\2!\"\7\23\2\2\"\66\3\2\2\2#$\7\r\2\2$%\5\f\7"+
		"\2%&\7\16\2\2&\'\5\22\n\2\'(\7\23\2\2(\66\3\2\2\2)*\5\n\6\2*+\7\23\2\2"+
		"+\66\3\2\2\2,-\5\22\n\2-.\7\23\2\2.\66\3\2\2\2/\60\5\20\t\2\60\61\7\23"+
		"\2\2\61\66\3\2\2\2\62\63\5\16\b\2\63\64\7\23\2\2\64\66\3\2\2\2\65\35\3"+
		"\2\2\2\65#\3\2\2\2\65)\3\2\2\2\65,\3\2\2\2\65/\3\2\2\2\65\62\3\2\2\2\66"+
		"\7\3\2\2\2\678\t\2\2\28\t\3\2\2\29:\7\17\2\2:;\7\21\2\2;<\7\17\2\2<\13"+
		"\3\2\2\2=>\7\17\2\2>?\7\21\2\2?@\5\b\5\2@\r\3\2\2\2AB\7\17\2\2BC\7\21"+
		"\2\2CD\5\24\13\2D\17\3\2\2\2EF\7\17\2\2FG\7\3\2\2GH\7\20\2\2H\21\3\2\2"+
		"\2IJ\7\17\2\2JK\7\22\2\2K\23\3\2\2\2LM\b\13\1\2MN\7\17\2\2NW\3\2\2\2O"+
		"P\f\5\2\2PQ\t\3\2\2QV\5\24\13\6RS\f\4\2\2ST\t\4\2\2TV\5\24\13\5UO\3\2"+
		"\2\2UR\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\25\3\2\2\2YW\3\2\2\2\6\33"+
		"\65UW";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}