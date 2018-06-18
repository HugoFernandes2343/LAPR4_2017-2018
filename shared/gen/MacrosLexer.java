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
		CELL_REF=1, MACRO_REF=2, INT=3, DOUBLE=4, LETTER=5, PI=6, E=7, POW=8, 
		NL=9, WS=10, ID=11, PLUS=12, EQUAL=13, MINUS=14, MULT=15, DIV=16, LPAR=17, 
		RPAR=18, CCOMMENT=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CELL_REF", "MACRO_REF", "INT", "DOUBLE", "LETTER", "PI", "E", "POW", 
		"NL", "WS", "ID", "ABS", "AT", "PLUS", "EQUAL", "MINUS", "MULT", "DIV", 
		"LPAR", "RPAR", "CCOMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'pi'", "'e'", "'^'", "'\n'", null, 
		null, "'+'", "'='", "'-'", "'*'", "'/'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CELL_REF", "MACRO_REF", "INT", "DOUBLE", "LETTER", "PI", "E", "POW", 
		"NL", "WS", "ID", "PLUS", "EQUAL", "MINUS", "MULT", "DIV", "LPAR", "RPAR", 
		"CCOMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\5\2/\n\2\3\2\3\2\5\2"+
		"\63\n\2\3\2\5\2\66\n\2\3\2\6\29\n\2\r\2\16\2:\3\3\3\3\3\3\3\4\6\4A\n\4"+
		"\r\4\16\4B\3\5\6\5F\n\5\r\5\16\5G\3\5\3\5\6\5L\n\5\r\5\16\5M\3\6\3\6\3"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\6\13\\\n\13\r\13\16\13]\3\13\3"+
		"\13\3\f\3\f\7\fd\n\f\f\f\16\fg\13\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\7\26}"+
		"\n\26\f\26\16\26\u0080\13\26\3\26\3\26\3~\2\27\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\2\33\2\35\16\37\17!\20#\21%\22\'\23)\24"+
		"+\25\3\2\7\3\2\62;\3\2C\\\5\2\13\13\17\17\"\"\5\2C\\aac|\6\2\62;C\\aa"+
		"c|\2\u008a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3.\3\2\2\2\5<\3\2\2\2\7@\3\2\2\2\tE\3"+
		"\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17T\3\2\2\2\21V\3\2\2\2\23X\3\2\2\2\25["+
		"\3\2\2\2\27a\3\2\2\2\31h\3\2\2\2\33j\3\2\2\2\35l\3\2\2\2\37n\3\2\2\2!"+
		"p\3\2\2\2#r\3\2\2\2%t\3\2\2\2\'v\3\2\2\2)x\3\2\2\2+z\3\2\2\2-/\5\31\r"+
		"\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\62\5\13\6\2\61\63\5\13\6\2\62\61"+
		"\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\66\5\31\r\2\65\64\3\2\2\2\65\66"+
		"\3\2\2\2\668\3\2\2\2\679\5\7\4\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2"+
		"\2\2;\4\3\2\2\2<=\5\33\16\2=>\5\27\f\2>\6\3\2\2\2?A\t\2\2\2@?\3\2\2\2"+
		"AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\b\3\2\2\2DF\t\2\2\2ED\3\2\2\2FG\3\2\2"+
		"\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IK\7\60\2\2JL\t\2\2\2KJ\3\2\2\2LM\3\2"+
		"\2\2MK\3\2\2\2MN\3\2\2\2N\n\3\2\2\2OP\t\3\2\2P\f\3\2\2\2QR\7r\2\2RS\7"+
		"k\2\2S\16\3\2\2\2TU\7g\2\2U\20\3\2\2\2VW\7`\2\2W\22\3\2\2\2XY\7\f\2\2"+
		"Y\24\3\2\2\2Z\\\t\4\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2"+
		"\2\2_`\b\13\2\2`\26\3\2\2\2ae\t\5\2\2bd\t\6\2\2cb\3\2\2\2dg\3\2\2\2ec"+
		"\3\2\2\2ef\3\2\2\2f\30\3\2\2\2ge\3\2\2\2hi\7&\2\2i\32\3\2\2\2jk\7B\2\2"+
		"k\34\3\2\2\2lm\7-\2\2m\36\3\2\2\2no\7?\2\2o \3\2\2\2pq\7/\2\2q\"\3\2\2"+
		"\2rs\7,\2\2s$\3\2\2\2tu\7\61\2\2u&\3\2\2\2vw\7*\2\2w(\3\2\2\2xy\7+\2\2"+
		"y*\3\2\2\2z~\7=\2\2{}\13\2\2\2|{\3\2\2\2}\u0080\3\2\2\2~\177\3\2\2\2~"+
		"|\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\f\2\2\u0082,"+
		"\3\2\2\2\r\2.\62\65:BGM]e~\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}