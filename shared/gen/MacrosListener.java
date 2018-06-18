// Generated from C:/Users/njgls/Desktop/Isep/LAPR4/lapr4_cod/shared/src/main/antlr4/pt/isep/nsheets/shared/core/formula/compiler\Macros.g4 by ANTLR 4.7

//    package pt.isep.nsheets.shared.core.formula.compiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MacrosParser}.
 */
public interface MacrosListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MacrosParser#macro}.
	 * @param ctx the parse tree
	 */
	void enterMacro(MacrosParser.MacroContext ctx);
	/**
	 * Exit a parse tree produced by {@link MacrosParser#macro}.
	 * @param ctx the parse tree
	 */
	void exitMacro(MacrosParser.MacroContext ctx);
	/**
	 * Enter a parse tree produced by {@link MacrosParser#setVar}.
	 * @param ctx the parse tree
	 */
	void enterSetVar(MacrosParser.SetVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MacrosParser#setVar}.
	 * @param ctx the parse tree
	 */
	void exitSetVar(MacrosParser.SetVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToMultOrDiv}
	 * labeled alternative in {@link MacrosParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterToMultOrDiv(MacrosParser.ToMultOrDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToMultOrDiv}
	 * labeled alternative in {@link MacrosParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitToMultOrDiv(MacrosParser.ToMultOrDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link MacrosParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterPlus(MacrosParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link MacrosParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitPlus(MacrosParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link MacrosParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterMinus(MacrosParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link MacrosParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitMinus(MacrosParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link MacrosParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(MacrosParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link MacrosParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(MacrosParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link MacrosParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterDivision(MacrosParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link MacrosParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitDivision(MacrosParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link MacrosParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterToPow(MacrosParser.ToPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link MacrosParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitToPow(MacrosParser.ToPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link MacrosParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPower(MacrosParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link MacrosParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPower(MacrosParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link MacrosParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterChangeSign(MacrosParser.ChangeSignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link MacrosParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitChangeSign(MacrosParser.ChangeSignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link MacrosParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterToAtom(MacrosParser.ToAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link MacrosParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitToAtom(MacrosParser.ToAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantPI}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantPI(MacrosParser.ConstantPIContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantPI}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantPI(MacrosParser.ConstantPIContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantE}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantE(MacrosParser.ConstantEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantE}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantE(MacrosParser.ConstantEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Double}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDouble(MacrosParser.DoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDouble(MacrosParser.DoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterInt(MacrosParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitInt(MacrosParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Cell}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterCell(MacrosParser.CellContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Cell}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitCell(MacrosParser.CellContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mac}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterMac(MacrosParser.MacContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mac}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitMac(MacrosParser.MacContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBraces(MacrosParser.BracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link MacrosParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBraces(MacrosParser.BracesContext ctx);
}