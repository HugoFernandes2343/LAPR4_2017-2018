// Generated from C:/Users/njgls/Desktop/Isep/LAPR4/lapr4_cod/shared/src/main/antlr4/pt/isep/nsheets/shared/core/formula/compiler\Macros.g4 by ANTLR 4.7

//    package pt.isep.nsheets.shared.core.formula.compiler;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MacrosParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CELL_REF=1, INT=2, DOUBLE=3, LETTER=4, PI=5, E=6, POW=7, NL=8, WS=9, ID=10, 
		PLUS=11, EQUAL=12, MINUS=13, MULT=14, DIV=15, LPAR=16, RPAR=17, CCOMMENT=18;
	public static final int
		RULE_macro = 0, RULE_setVar = 1, RULE_plusOrMinus = 2, RULE_multOrDiv = 3, 
		RULE_pow = 4, RULE_unaryMinus = 5, RULE_atom = 6;
	public static final String[] ruleNames = {
		"macro", "setVar", "plusOrMinus", "multOrDiv", "pow", "unaryMinus", "atom"
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

	@Override
	public String getGrammarFileName() { return "Macros.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MacrosParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MacroContext extends ParserRuleContext {
		public List<TerminalNode> CCOMMENT() { return getTokens(MacrosParser.CCOMMENT); }
		public TerminalNode CCOMMENT(int i) {
			return getToken(MacrosParser.CCOMMENT, i);
		}
		public List<SetVarContext> setVar() {
			return getRuleContexts(SetVarContext.class);
		}
		public SetVarContext setVar(int i) {
			return getRuleContext(SetVarContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(MacrosParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(MacrosParser.NL, i);
		}
		public MacroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitMacro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitMacro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroContext macro() throws RecognitionException {
		MacroContext _localctx = new MacroContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_macro);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(23);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(18); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(14);
							setVar();
							setState(16);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==NL) {
								{
								setState(15);
								match(NL);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(20); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				case CCOMMENT:
					{
					setState(22);
					match(CCOMMENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==CCOMMENT );
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

	public static class SetVarContext extends ParserRuleContext {
		public SetVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setVar; }
	 
		public SetVarContext() { }
		public void copyFrom(SetVarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SetVariableContext extends SetVarContext {
		public TerminalNode ID() { return getToken(MacrosParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(MacrosParser.EQUAL, 0); }
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public SetVariableContext(SetVarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterSetVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitSetVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitSetVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetVarContext setVar() throws RecognitionException {
		SetVarContext _localctx = new SetVarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_setVar);
		try {
			_localctx = new SetVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(ID);
			setState(28);
			match(EQUAL);
			setState(29);
			plusOrMinus(0);
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

	public static class PlusOrMinusContext extends ParserRuleContext {
		public PlusOrMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusOrMinus; }
	 
		public PlusOrMinusContext() { }
		public void copyFrom(PlusOrMinusContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToMultOrDivContext extends PlusOrMinusContext {
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public ToMultOrDivContext(PlusOrMinusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterToMultOrDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitToMultOrDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitToMultOrDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusContext extends PlusOrMinusContext {
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(MacrosParser.PLUS, 0); }
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public PlusContext(PlusOrMinusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusContext extends PlusOrMinusContext {
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(MacrosParser.MINUS, 0); }
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public MinusContext(PlusOrMinusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusOrMinusContext plusOrMinus() throws RecognitionException {
		return plusOrMinus(0);
	}

	private PlusOrMinusContext plusOrMinus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PlusOrMinusContext _localctx = new PlusOrMinusContext(_ctx, _parentState);
		PlusOrMinusContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_plusOrMinus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToMultOrDivContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(32);
			multOrDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(40);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new PlusOrMinusContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(34);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(35);
						match(PLUS);
						setState(36);
						multOrDiv(0);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new PlusOrMinusContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(37);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(38);
						match(MINUS);
						setState(39);
						multOrDiv(0);
						}
						break;
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class MultOrDivContext extends ParserRuleContext {
		public MultOrDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOrDiv; }
	 
		public MultOrDivContext() { }
		public void copyFrom(MultOrDivContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicationContext extends MultOrDivContext {
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public TerminalNode MULT() { return getToken(MacrosParser.MULT, 0); }
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public MultiplicationContext(MultOrDivContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends MultOrDivContext {
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public TerminalNode DIV() { return getToken(MacrosParser.DIV, 0); }
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public DivisionContext(MultOrDivContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToPowContext extends MultOrDivContext {
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public ToPowContext(MultOrDivContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterToPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitToPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitToPow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultOrDivContext multOrDiv() throws RecognitionException {
		return multOrDiv(0);
	}

	private MultOrDivContext multOrDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultOrDivContext _localctx = new MultOrDivContext(_ctx, _parentState);
		MultOrDivContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_multOrDiv, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToPowContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(46);
			pow();
			}
			_ctx.stop = _input.LT(-1);
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(54);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new MultOrDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(48);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(49);
						match(MULT);
						setState(50);
						pow();
						}
						break;
					case 2:
						{
						_localctx = new DivisionContext(new MultOrDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(51);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(52);
						match(DIV);
						setState(53);
						pow();
						}
						break;
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class PowContext extends ParserRuleContext {
		public PowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow; }
	 
		public PowContext() { }
		public void copyFrom(PowContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PowerContext extends PowContext {
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public TerminalNode POW() { return getToken(MacrosParser.POW, 0); }
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public PowerContext(PowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowContext pow() throws RecognitionException {
		PowContext _localctx = new PowContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pow);
		try {
			_localctx = new PowerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			unaryMinus();
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(60);
				match(POW);
				setState(61);
				pow();
				}
				break;
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

	public static class UnaryMinusContext extends ParserRuleContext {
		public UnaryMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMinus; }
	 
		public UnaryMinusContext() { }
		public void copyFrom(UnaryMinusContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChangeSignContext extends UnaryMinusContext {
		public TerminalNode MINUS() { return getToken(MacrosParser.MINUS, 0); }
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public ChangeSignContext(UnaryMinusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterChangeSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitChangeSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitChangeSign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToAtomContext extends UnaryMinusContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ToAtomContext(UnaryMinusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterToAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitToAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitToAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryMinusContext unaryMinus() throws RecognitionException {
		UnaryMinusContext _localctx = new UnaryMinusContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unaryMinus);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				_localctx = new ChangeSignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(MINUS);
				setState(65);
				unaryMinus();
				}
				break;
			case CELL_REF:
			case INT:
			case DOUBLE:
			case PI:
			case E:
			case ID:
			case LPAR:
				_localctx = new ToAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstantPIContext extends AtomContext {
		public TerminalNode PI() { return getToken(MacrosParser.PI, 0); }
		public ConstantPIContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterConstantPI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitConstantPI(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitConstantPI(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefContext extends AtomContext {
		public TerminalNode CELL_REF() { return getToken(MacrosParser.CELL_REF, 0); }
		public RefContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends AtomContext {
		public TerminalNode ID() { return getToken(MacrosParser.ID, 0); }
		public VariableContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracesContext extends AtomContext {
		public TerminalNode LPAR() { return getToken(MacrosParser.LPAR, 0); }
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MacrosParser.RPAR, 0); }
		public BracesContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitBraces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitBraces(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantEContext extends AtomContext {
		public TerminalNode E() { return getToken(MacrosParser.E, 0); }
		public ConstantEContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterConstantE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitConstantE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitConstantE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleContext extends AtomContext {
		public TerminalNode DOUBLE() { return getToken(MacrosParser.DOUBLE, 0); }
		public DoubleContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends AtomContext {
		public TerminalNode INT() { return getToken(MacrosParser.INT, 0); }
		public IntContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MacrosListener ) ((MacrosListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MacrosVisitor ) return ((MacrosVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atom);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PI:
				_localctx = new ConstantPIContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(PI);
				}
				break;
			case E:
				_localctx = new ConstantEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(E);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(DOUBLE);
				}
				break;
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				match(INT);
				}
				break;
			case ID:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				match(ID);
				}
				break;
			case CELL_REF:
				_localctx = new RefContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				match(CELL_REF);
				}
				break;
			case LPAR:
				_localctx = new BracesContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(75);
				match(LPAR);
				setState(76);
				plusOrMinus(0);
				setState(77);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return plusOrMinus_sempred((PlusOrMinusContext)_localctx, predIndex);
		case 3:
			return multOrDiv_sempred((MultOrDivContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean plusOrMinus_sempred(PlusOrMinusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multOrDiv_sempred(MultOrDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\5\2\23\n\2\6\2\25\n"+
		"\2\r\2\16\2\26\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4+\n\4\f\4\16\4.\13\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\7\59\n\5\f\5\16\5<\13\5\3\6\3\6\3\6\5\6A\n\6\3\7\3\7\3"+
		"\7\5\7F\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bR\n\b\3\b\2\4\6"+
		"\b\t\2\4\6\b\n\f\16\2\2\2\\\2\31\3\2\2\2\4\35\3\2\2\2\6!\3\2\2\2\b/\3"+
		"\2\2\2\n=\3\2\2\2\fE\3\2\2\2\16Q\3\2\2\2\20\22\5\4\3\2\21\23\7\n\2\2\22"+
		"\21\3\2\2\2\22\23\3\2\2\2\23\25\3\2\2\2\24\20\3\2\2\2\25\26\3\2\2\2\26"+
		"\24\3\2\2\2\26\27\3\2\2\2\27\32\3\2\2\2\30\32\7\24\2\2\31\24\3\2\2\2\31"+
		"\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2\35"+
		"\36\7\f\2\2\36\37\7\16\2\2\37 \5\6\4\2 \5\3\2\2\2!\"\b\4\1\2\"#\5\b\5"+
		"\2#,\3\2\2\2$%\f\5\2\2%&\7\r\2\2&+\5\b\5\2\'(\f\4\2\2()\7\17\2\2)+\5\b"+
		"\5\2*$\3\2\2\2*\'\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\7\3\2\2\2.,\3"+
		"\2\2\2/\60\b\5\1\2\60\61\5\n\6\2\61:\3\2\2\2\62\63\f\5\2\2\63\64\7\20"+
		"\2\2\649\5\n\6\2\65\66\f\4\2\2\66\67\7\21\2\2\679\5\n\6\28\62\3\2\2\2"+
		"8\65\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\t\3\2\2\2<:\3\2\2\2=@\5\f"+
		"\7\2>?\7\t\2\2?A\5\n\6\2@>\3\2\2\2@A\3\2\2\2A\13\3\2\2\2BC\7\17\2\2CF"+
		"\5\f\7\2DF\5\16\b\2EB\3\2\2\2ED\3\2\2\2F\r\3\2\2\2GR\7\7\2\2HR\7\b\2\2"+
		"IR\7\5\2\2JR\7\4\2\2KR\7\f\2\2LR\7\3\2\2MN\7\22\2\2NO\5\6\4\2OP\7\23\2"+
		"\2PR\3\2\2\2QG\3\2\2\2QH\3\2\2\2QI\3\2\2\2QJ\3\2\2\2QK\3\2\2\2QL\3\2\2"+
		"\2QM\3\2\2\2R\17\3\2\2\2\r\22\26\31\33*,8:@EQ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}