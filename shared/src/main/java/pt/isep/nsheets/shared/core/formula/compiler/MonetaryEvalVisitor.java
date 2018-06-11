/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.Token;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.UnaryOperation;
import pt.isep.nsheets.shared.core.formula.UnaryOperator;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;

/**
 *
 * @author Paulo Jorge
 */
public class MonetaryEvalVisitor extends MonetaryLanguageBaseVisitor<Expression> {

    private static double exchangeEuro_Dollar = 1.178;
    private static double exchangePound_Euro = 1.133;
    private static double exchangePound_Dollar = 0.746;
    private Cell cell = null;
    int numberOfErros;
    private final StringBuilder errorBuffer;
    private Token currentCoin;

    final private Language language;

    public MonetaryEvalVisitor(Cell cell, Language lang) {
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
    public Expression visitExpression(MonetaryLanguageParser.ExpressionContext ctx) {

        try {
            currentCoin = (Token) ctx.getChild(0).getPayload();
            UnaryOperator formatToEuro = this.language.getUnaryOperator("e");
            UnaryOperator formatToDollar = this.language.getUnaryOperator("$");
            UnaryOperator formatToPound = this.language.getUnaryOperator("£");

            switch (currentCoin.getText()) {
                case "EURO":
                    return new UnaryOperation(formatToEuro, visit(ctx.concatenation()));

                case "DOLLAR":
                    return new UnaryOperation(formatToDollar, visit(ctx.concatenation()));

                case "POUND":
                    return new UnaryOperation(formatToPound, visit(ctx.concatenation()));
            }
            return visit(ctx.concatenation());
        } catch (UnknownElementException ex) {
            addVisitError(ex.getMessage());
        }
        return null;
    }

    @Override
    public Expression visitConcatenation(MonetaryLanguageParser.ConcatenationContext ctx) {
        try {
            if (ctx.getChildCount() == 3) {
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());
                return new BinaryOperation(visit(ctx.getChild(0)), operator, visit(ctx.getChild(2)));
            }

        } catch (FormulaCompilationException ex) {
            addVisitError(ex.getMessage());
        }
        return visitChildren(ctx);
    }

    @Override
    public Expression visitAtom(MonetaryLanguageParser.AtomContext ctx) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.expression());
        } else {
            return visit(ctx.literalMonetary());
        }

    }

    @Override
    public Expression visitLiteralMonetary(MonetaryLanguageParser.LiteralMonetaryContext ctx) {
        Token currentSIG = (Token) ctx.getChild(1).getPayload();

        switch (currentCoin.getText()) {
            case "EURO":

                switch (currentSIG.getText()) {
                    case "e":
                        return new Literal(Value.parseValue(ctx.getChild(0).getText()));

                    case "£":
                        try {
                            Double value = Value.parseValue(ctx.getChild(0).getText()).toDouble();
                            value = value * exchangePound_Euro;
                            return new Literal(Value.parseValue(Double.toString(value)));
                        } catch (IllegalValueTypeException ex) {
                            addVisitError(ex.getMessage());
                        }

                    case "$":
                        try {
                            Double value = Value.parseValue(ctx.getChild(0).getText()).toDouble();
                            value = value / exchangeEuro_Dollar;
                            return new Literal(Value.parseValue(Double.toString(value)));
                        } catch (IllegalValueTypeException ex) {
                            addVisitError(ex.getMessage());
                        }
                }
            case "DOLLAR":
                switch (currentSIG.getText()) {
                    case "e":
                        try {
                            Double value = Value.parseValue(ctx.getChild(0).getText()).toDouble();
                            value = value * exchangeEuro_Dollar;
                            return new Literal(Value.parseValue(Double.toString(value)));
                        } catch (IllegalValueTypeException ex) {
                            addVisitError(ex.getMessage());
                        }
                    case "£":
                        try {
                            Double value = Value.parseValue(ctx.getChild(0).getText()).toDouble();
                            value = value / exchangePound_Euro;
                            return new Literal(Value.parseValue(Double.toString(value)));
                        } catch (IllegalValueTypeException ex) {
                            addVisitError(ex.getMessage());
                        }

                    case "$":
                        return new Literal(Value.parseValue(ctx.getChild(0).getText()));

                }
            case "POUND":
                switch (currentSIG.getText()) {
                    case "e":
                        try {
                            Double value = Value.parseValue(ctx.getChild(0).getText()).toDouble();
                            value = value / exchangePound_Euro;
                            return new Literal(Value.parseValue(Double.toString(value)));
                        } catch (IllegalValueTypeException ex) {
                            addVisitError(ex.getMessage());
                        }
                    case "£":
                        return new Literal(Value.parseValue(ctx.getChild(0).getText()));

                    case "$":
                        try {
                            Double value = Value.parseValue(ctx.getChild(0).getText()).toDouble();
                            value = value / exchangePound_Dollar;
                            return new Literal(Value.parseValue(Double.toString(value)));
                        } catch (IllegalValueTypeException ex) {
                            addVisitError(ex.getMessage());
                        }

                }

        }
        return null;
    }

    private void addVisitError(String msg) {
        errorBuffer.append(msg).append("\n");
        numberOfErros++;
    }
}
