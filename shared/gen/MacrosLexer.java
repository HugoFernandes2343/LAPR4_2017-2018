// Generated from C:/Users/njgls/Desktop/Isep/LAPR4/lapr4_cod/shared/src/main/antlr4/pt/isep/nsheets/shared/core/formula/compiler\Macros.g4 by ANTLR 4.7

//    package pt.isep.nsheets.shared.core.formula.compiler;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MacrosLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CELL_REF=1, INT=2, DOUBLE=3, LETTER=4, PI=5, E=6, POW=7, NL=8, WS=9, ID=10, 
		PLUS=11, EQUAL=12, MINUS=13, MULT=14, DIV=15, LPAR=16, RPAR=17, CCOMMENT=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CELL_REF", "INT", "DOUBLE", "LETTER", "PI", "E", "POW", "NL", "WS", "ID", 
		"ABS", "PLUS", "EQUAL", "MINUS", "MULT", "DIV", "LPAR", "RPAR", "CCOMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'pi'", "'e'", "'^'", "'\n'", null, null, 
		"'+'", "'='", "'-'", "'*'", "'/'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CELL_REF", "INT", "DOUBLE", "LETTER", "PI", "E", "POW", "NL", "WS", 
		"ID", "PLUS", "EQUAL", "MINUS", "MULT", "DIV", "LPAR", "RPAR", "CCOMMENT"
	};
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


	public MacrosLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Macros.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\5\2+\n\2\3\2\3\2\5\2/\n\2\3\2\5\2\62\n\2\3\2"+
		"\6\2\65\n\2\r\2\16\2\66\3\3\6\3:\n\3\r\3\16\3;\3\4\6\4?\n\4\r\4\16\4@"+
		"\3\4\3\4\6\4E\n\4\r\4\16\4F\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\6\nU\n\n\r\n\16\nV\3\n\3\n\3\13\3\13\7\13]\n\13\f\13\16\13`\13"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\7\24t\n\24\f\24\16\24w\13\24\3\24\3\24\3u\2\25\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\r\33\16\35\17\37"+
		"\20!\21#\22%\23\'\24\3\2\7\3\2\62;\3\2C\\\5\2\13\13\17\17\"\"\5\2C\\a"+
		"ac|\6\2\62;C\\aac|\2\u0082\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3*\3\2\2\2\59\3\2\2\2\7>\3\2\2"+
		"\2\tH\3\2\2\2\13J\3\2\2\2\rM\3\2\2\2\17O\3\2\2\2\21Q\3\2\2\2\23T\3\2\2"+
		"\2\25Z\3\2\2\2\27a\3\2\2\2\31c\3\2\2\2\33e\3\2\2\2\35g\3\2\2\2\37i\3\2"+
		"\2\2!k\3\2\2\2#m\3\2\2\2%o\3\2\2\2\'q\3\2\2\2)+\5\27\f\2*)\3\2\2\2*+\3"+
		"\2\2\2+,\3\2\2\2,.\5\t\5\2-/\5\t\5\2.-\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60"+
		"\62\5\27\f\2\61\60\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\65\5\5\3\2\64"+
		"\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\4\3\2\2\28:\t"+
		"\2\2\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\6\3\2\2\2=?\t\2\2\2>="+
		"\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BD\7\60\2\2CE\t\2\2\2"+
		"DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\b\3\2\2\2HI\t\3\2\2I\n\3\2\2"+
		"\2JK\7r\2\2KL\7k\2\2L\f\3\2\2\2MN\7g\2\2N\16\3\2\2\2OP\7`\2\2P\20\3\2"+
		"\2\2QR\7\f\2\2R\22\3\2\2\2SU\t\4\2\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3"+
		"\2\2\2WX\3\2\2\2XY\b\n\2\2Y\24\3\2\2\2Z^\t\5\2\2[]\t\6\2\2\\[\3\2\2\2"+
		"]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\26\3\2\2\2`^\3\2\2\2ab\7&\2\2b\30\3\2"+
		"\2\2cd\7-\2\2d\32\3\2\2\2ef\7?\2\2f\34\3\2\2\2gh\7/\2\2h\36\3\2\2\2ij"+
		"\7,\2\2j \3\2\2\2kl\7\61\2\2l\"\3\2\2\2mn\7*\2\2n$\3\2\2\2op\7+\2\2p&"+
		"\3\2\2\2qu\7=\2\2rt\13\2\2\2sr\3\2\2\2tw\3\2\2\2uv\3\2\2\2us\3\2\2\2v"+
		"x\3\2\2\2wu\3\2\2\2xy\7\f\2\2y(\3\2\2\2\r\2*.\61\66;@FV^u\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}