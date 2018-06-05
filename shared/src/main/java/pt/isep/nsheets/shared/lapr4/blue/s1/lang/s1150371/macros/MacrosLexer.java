// Generated from Macros.g4 by ANTLR 4.7.1

    package pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1150371.macros;

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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, DOUBLE=2, PI=3, E=4, POW=5, NL=6, WS=7, ID=8, PLUS=9, EQUAL=10, 
		MINUS=11, MULT=12, DIV=13, LPAR=14, RPAR=15, COMMENT=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INT", "DOUBLE", "PI", "E", "POW", "NL", "WS", "ID", "PLUS", "EQUAL", 
		"MINUS", "MULT", "DIV", "LPAR", "RPAR", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'pi'", "'e'", "'^'", "'\n'", null, null, "'+'", "'='", 
		"'-'", "'*'", "'/'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INT", "DOUBLE", "PI", "E", "POW", "NL", "WS", "ID", "PLUS", "EQUAL", 
		"MINUS", "MULT", "DIV", "LPAR", "RPAR", "COMMENT"
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

	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22c\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\6\2%\n"+
		"\2\r\2\16\2&\3\3\6\3*\n\3\r\3\16\3+\3\3\3\3\6\3\60\n\3\r\3\16\3\61\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\6\b>\n\b\r\b\16\b?\3\b\3\b\3\t\3"+
		"\t\7\tF\n\t\f\t\16\tI\13\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\7\21[\n\21\f\21\16\21^\13\21\3\21\3\21"+
		"\3\21\3\21\3\\\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22\3\2\6\3\2\62;\5\2\13\13\17\17\"\"\5\2C\\"+
		"aac|\6\2\62;C\\aac|\2h\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\3$\3\2\2\2\5)\3\2\2\2\7\63\3\2\2\2\t\66\3\2\2\2\138\3"+
		"\2\2\2\r:\3\2\2\2\17=\3\2\2\2\21C\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27N"+
		"\3\2\2\2\31P\3\2\2\2\33R\3\2\2\2\35T\3\2\2\2\37V\3\2\2\2!X\3\2\2\2#%\t"+
		"\2\2\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\4\3\2\2\2(*\t\2\2\2"+
		")(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-/\7\60\2\2.\60\t\2"+
		"\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\6\3\2\2\2\63"+
		"\64\7r\2\2\64\65\7k\2\2\65\b\3\2\2\2\66\67\7g\2\2\67\n\3\2\2\289\7`\2"+
		"\29\f\3\2\2\2:;\7\f\2\2;\16\3\2\2\2<>\t\3\2\2=<\3\2\2\2>?\3\2\2\2?=\3"+
		"\2\2\2?@\3\2\2\2@A\3\2\2\2AB\b\b\2\2B\20\3\2\2\2CG\t\4\2\2DF\t\5\2\2E"+
		"D\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\22\3\2\2\2IG\3\2\2\2JK\7-\2\2"+
		"K\24\3\2\2\2LM\7?\2\2M\26\3\2\2\2NO\7/\2\2O\30\3\2\2\2PQ\7,\2\2Q\32\3"+
		"\2\2\2RS\7\61\2\2S\34\3\2\2\2TU\7*\2\2U\36\3\2\2\2VW\7+\2\2W \3\2\2\2"+
		"X\\\7=\2\2Y[\13\2\2\2ZY\3\2\2\2[^\3\2\2\2\\]\3\2\2\2\\Z\3\2\2\2]_\3\2"+
		"\2\2^\\\3\2\2\2_`\7\f\2\2`a\3\2\2\2ab\b\21\2\2b\"\3\2\2\2\t\2&+\61?G\\"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}