// Generated from FormScriptGrammar.g4 by ANTLR 4.9.2
package project.FormWebApp.antlr.formscript.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormScriptGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, DATE=6, FILE=7, INTEGER=8, STRING=9, 
		BOOLEAN=10, IF=11, THEN=12, VARIABLE=13, ATTRIBUTION=14, COMPARISON_OPERATORS=15, 
		OBLIGATORY=16, ENDLINE=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "A", "B", "C", "D", "E", "F", 
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
			"U", "V", "W", "X", "Y", "Z", "DAY", "MONTH", "YEAR", "FILE_FRAGMENT", 
			"DATE", "FILE", "INTEGER", "STRING", "BOOLEAN", "IF", "THEN", "VARIABLE", 
			"ATTRIBUTION", "COMPARISON_OPERATORS", "OBLIGATORY", "ENDLINE", "WS"
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


	public FormScriptGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormScriptGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0132\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!"+
		"\3!\5!\u00a9\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00b3\n\"\3#\3#\3"+
		"#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\7&\u00c9\n&\f&\16"+
		"&\u00cc\13&\3&\3&\3\'\6\'\u00d1\n\'\r\'\16\'\u00d2\3(\3(\7(\u00d7\n(\f"+
		"(\16(\u00da\13(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u00e9\n)\3*"+
		"\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\6,\u00f6\n,\r,\16,\u00f7\3-\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\5-\u011b\n-\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"\60\3\60\3\61\6\61\u012d\n\61\r\61\16\61\u012e\3\61\3\61\4\u00ca\u00d8"+
		"\2\62\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2"+
		"\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E"+
		"\2G\2I\bK\tM\nO\13Q\fS\rU\16W\17Y\20[\21]\22_\23a\24\3\2!\4\2CCcc\4\2"+
		"DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4"+
		"\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUu"+
		"u\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\3\2\62\64"+
		"\3\2\62;\3\2\62\62\3\2\63;\5\2\13\f\17\17\"\"\2\u0122\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5f\3\2\2"+
		"\2\7h\3\2\2\2\tj\3\2\2\2\13l\3\2\2\2\rn\3\2\2\2\17p\3\2\2\2\21r\3\2\2"+
		"\2\23t\3\2\2\2\25v\3\2\2\2\27x\3\2\2\2\31z\3\2\2\2\33|\3\2\2\2\35~\3\2"+
		"\2\2\37\u0080\3\2\2\2!\u0082\3\2\2\2#\u0084\3\2\2\2%\u0086\3\2\2\2\'\u0088"+
		"\3\2\2\2)\u008a\3\2\2\2+\u008c\3\2\2\2-\u008e\3\2\2\2/\u0090\3\2\2\2\61"+
		"\u0092\3\2\2\2\63\u0094\3\2\2\2\65\u0096\3\2\2\2\67\u0098\3\2\2\29\u009a"+
		"\3\2\2\2;\u009c\3\2\2\2=\u009e\3\2\2\2?\u00a0\3\2\2\2A\u00a8\3\2\2\2C"+
		"\u00b2\3\2\2\2E\u00b4\3\2\2\2G\u00b9\3\2\2\2I\u00bf\3\2\2\2K\u00c5\3\2"+
		"\2\2M\u00d0\3\2\2\2O\u00d4\3\2\2\2Q\u00e8\3\2\2\2S\u00ea\3\2\2\2U\u00ed"+
		"\3\2\2\2W\u00f2\3\2\2\2Y\u011a\3\2\2\2[\u011c\3\2\2\2]\u011e\3\2\2\2_"+
		"\u0129\3\2\2\2a\u012c\3\2\2\2cd\7K\2\2de\7U\2\2e\4\3\2\2\2fg\7,\2\2g\6"+
		"\3\2\2\2hi\7\61\2\2i\b\3\2\2\2jk\7-\2\2k\n\3\2\2\2lm\7/\2\2m\f\3\2\2\2"+
		"no\t\2\2\2o\16\3\2\2\2pq\t\3\2\2q\20\3\2\2\2rs\t\4\2\2s\22\3\2\2\2tu\t"+
		"\5\2\2u\24\3\2\2\2vw\t\6\2\2w\26\3\2\2\2xy\t\7\2\2y\30\3\2\2\2z{\t\b\2"+
		"\2{\32\3\2\2\2|}\t\t\2\2}\34\3\2\2\2~\177\t\n\2\2\177\36\3\2\2\2\u0080"+
		"\u0081\t\13\2\2\u0081 \3\2\2\2\u0082\u0083\t\f\2\2\u0083\"\3\2\2\2\u0084"+
		"\u0085\t\r\2\2\u0085$\3\2\2\2\u0086\u0087\t\16\2\2\u0087&\3\2\2\2\u0088"+
		"\u0089\t\17\2\2\u0089(\3\2\2\2\u008a\u008b\t\20\2\2\u008b*\3\2\2\2\u008c"+
		"\u008d\t\21\2\2\u008d,\3\2\2\2\u008e\u008f\t\22\2\2\u008f.\3\2\2\2\u0090"+
		"\u0091\t\23\2\2\u0091\60\3\2\2\2\u0092\u0093\t\24\2\2\u0093\62\3\2\2\2"+
		"\u0094\u0095\t\25\2\2\u0095\64\3\2\2\2\u0096\u0097\t\26\2\2\u0097\66\3"+
		"\2\2\2\u0098\u0099\t\27\2\2\u00998\3\2\2\2\u009a\u009b\t\30\2\2\u009b"+
		":\3\2\2\2\u009c\u009d\t\31\2\2\u009d<\3\2\2\2\u009e\u009f\t\32\2\2\u009f"+
		">\3\2\2\2\u00a0\u00a1\t\33\2\2\u00a1@\3\2\2\2\u00a2\u00a3\t\34\2\2\u00a3"+
		"\u00a9\t\35\2\2\u00a4\u00a5\7\65\2\2\u00a5\u00a9\7\62\2\2\u00a6\u00a7"+
		"\7\65\2\2\u00a7\u00a9\7\63\2\2\u00a8\u00a2\3\2\2\2\u00a8\u00a4\3\2\2\2"+
		"\u00a8\u00a6\3\2\2\2\u00a9B\3\2\2\2\u00aa\u00ab\t\36\2\2\u00ab\u00b3\t"+
		"\37\2\2\u00ac\u00ad\7\63\2\2\u00ad\u00b3\7\62\2\2\u00ae\u00af\7\63\2\2"+
		"\u00af\u00b3\7\63\2\2\u00b0\u00b1\7\63\2\2\u00b1\u00b3\7\64\2\2\u00b2"+
		"\u00aa\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b3D\3\2\2\2\u00b4\u00b5\t\35\2\2\u00b5\u00b6\t\35\2\2\u00b6\u00b7"+
		"\t\35\2\2\u00b7\u00b8\t\35\2\2\u00b8F\3\2\2\2\u00b9\u00ba\5\27\f\2\u00ba"+
		"\u00bb\5\35\17\2\u00bb\u00bc\5#\22\2\u00bc\u00bd\5\25\13\2\u00bd\u00be"+
		"\7<\2\2\u00beH\3\2\2\2\u00bf\u00c0\5A!\2\u00c0\u00c1\7/\2\2\u00c1\u00c2"+
		"\5C\"\2\u00c2\u00c3\7/\2\2\u00c3\u00c4\5E#\2\u00c4J\3\2\2\2\u00c5\u00c6"+
		"\5G$\2\u00c6\u00ca\7$\2\2\u00c7\u00c9\13\2\2\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\u00cc\3\2\2\2\u00ca\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cd\3\2"+
		"\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7$\2\2\u00ceL\3\2\2\2\u00cf\u00d1"+
		"\4\62;\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3N\3\2\2\2\u00d4\u00d8\7$\2\2\u00d5\u00d7\13\2\2\2"+
		"\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7$\2\2\u00dc"+
		"P\3\2\2\2\u00dd\u00de\5\63\32\2\u00de\u00df\5/\30\2\u00df\u00e0\5\65\33"+
		"\2\u00e0\u00e1\5\25\13\2\u00e1\u00e9\3\2\2\2\u00e2\u00e3\5\27\f\2\u00e3"+
		"\u00e4\5\r\7\2\u00e4\u00e5\5#\22\2\u00e5\u00e6\5\61\31\2\u00e6\u00e7\5"+
		"\25\13\2\u00e7\u00e9\3\2\2\2\u00e8\u00dd\3\2\2\2\u00e8\u00e2\3\2\2\2\u00e9"+
		"R\3\2\2\2\u00ea\u00eb\5\35\17\2\u00eb\u00ec\5\27\f\2\u00ecT\3\2\2\2\u00ed"+
		"\u00ee\5\63\32\2\u00ee\u00ef\5\33\16\2\u00ef\u00f0\5\25\13\2\u00f0\u00f1"+
		"\5\'\24\2\u00f1V\3\2\2\2\u00f2\u00f3\5\67\34\2\u00f3\u00f5\7a\2\2\u00f4"+
		"\u00f6\t\35\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3"+
		"\2\2\2\u00f7\u00f8\3\2\2\2\u00f8X\3\2\2\2\u00f9\u00fa\5\35\17\2\u00fa"+
		"\u00fb\5\'\24\2\u00fb\u00fc\5\63\32\2\u00fc\u00fd\5\25\13\2\u00fd\u00fe"+
		"\5\31\r\2\u00fe\u00ff\5\25\13\2\u00ff\u0100\5/\30\2\u0100\u011b\3\2\2"+
		"\2\u0101\u0102\5\17\b\2\u0102\u0103\5)\25\2\u0103\u0104\5)\25\2\u0104"+
		"\u0105\5#\22\2\u0105\u0106\5\25\13\2\u0106\u0107\5\r\7\2\u0107\u0108\5"+
		"\'\24\2\u0108\u011b\3\2\2\2\u0109\u010a\5\27\f\2\u010a\u010b\5\35\17\2"+
		"\u010b\u010c\5#\22\2\u010c\u010d\5\25\13\2\u010d\u011b\3\2\2\2\u010e\u010f"+
		"\5\61\31\2\u010f\u0110\5\63\32\2\u0110\u0111\5/\30\2\u0111\u0112\5\35"+
		"\17\2\u0112\u0113\5\'\24\2\u0113\u0114\5\31\r\2\u0114\u011b\3\2\2\2\u0115"+
		"\u0116\5\23\n\2\u0116\u0117\5\r\7\2\u0117\u0118\5\63\32\2\u0118\u0119"+
		"\5\25\13\2\u0119\u011b\3\2\2\2\u011a\u00f9\3\2\2\2\u011a\u0101\3\2\2\2"+
		"\u011a\u0109\3\2\2\2\u011a\u010e\3\2\2\2\u011a\u0115\3\2\2\2\u011bZ\3"+
		"\2\2\2\u011c\u011d\4>@\2\u011d\\\3\2\2\2\u011e\u011f\5)\25\2\u011f\u0120"+
		"\5\17\b\2\u0120\u0121\5#\22\2\u0121\u0122\5\35\17\2\u0122\u0123\5\31\r"+
		"\2\u0123\u0124\5\r\7\2\u0124\u0125\5\63\32\2\u0125\u0126\5)\25\2\u0126"+
		"\u0127\5/\30\2\u0127\u0128\5=\37\2\u0128^\3\2\2\2\u0129\u012a\7=\2\2\u012a"+
		"`\3\2\2\2\u012b\u012d\t \2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b\61"+
		"\2\2\u0131b\3\2\2\2\f\2\u00a8\u00b2\u00ca\u00d2\u00d8\u00e8\u00f7\u011a"+
		"\u012e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}