/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.lang.Language;

/**
 *
 * @author Paulo Jorge
 */
public class MonetaryEvalCompiler extends MonetaryLanguageBaseVisitor<Expression> {

    private Cell cell = null;
    int numberOfErros;
    private final StringBuilder errorBuffer;

    final private Language language;

    public MonetaryEvalCompiler(Cell cell, Language lang) {
        this.cell = cell;
        numberOfErros = 0;
        errorBuffer = new StringBuilder();
        this.language = lang;
    }

    public int getNumberOfErrors() {
        return numberOfErros;
    }

    public String getErrorsMessage() {
        return errorBuffer.toString();
    }

    @Override
    public Expression visitExpressionMonetary(MonetaryLanguageParser.ExpressionMonetaryContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public Expression visitEuroExpression(MonetaryLanguageParser.EuroExpressionContext ctx) {
        return visit(ctx.getChild(2));
    }

    @Override
    public Expression visitPoundExpression(MonetaryLanguageParser.PoundExpressionContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public Expression visitDollarExpression(MonetaryLanguageParser.DollarExpressionContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public Expression visitLiteralMonetary(MonetaryLanguageParser.LiteralMonetaryContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public Expression visitAtom(MonetaryLanguageParser.AtomContext ctx) {
        return visit(ctx.getChild(1));
    }

    private void addVisitError(String msg) {
        errorBuffer.append(msg).append("\n");
        numberOfErros++;
    }
}
