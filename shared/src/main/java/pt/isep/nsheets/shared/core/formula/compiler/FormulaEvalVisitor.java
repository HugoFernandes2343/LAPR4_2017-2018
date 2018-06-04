/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionCall;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.UnaryOperation;
import pt.isep.nsheets.shared.core.formula.lang.CellReference;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.RangeReference;
import pt.isep.nsheets.shared.core.formula.lang.ReferenceOperation;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.Token;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables.VariableReference;
import pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1091234.blockOfInstructions.For;
import pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1091234.blockOfInstructions.Block;

/**
 *
 * @author jrt
 */
public class FormulaEvalVisitor extends FormulaBaseVisitor<Expression> {

    private Cell cell = null;
    int numberOfErros;
    private final StringBuilder errorBuffer;

    final private Language language;

    public FormulaEvalVisitor(Cell cell, Language lang) {
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
    public Expression visitExpression(FormulaParser.ExpressionContext ctx) {
        return visit(ctx.comparison());
    }

    @Override
    public Expression visitComparison(FormulaParser.ComparisonContext ctx) {
        if (ctx.getChildCount() == 3) {
            try {
                //BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());

                return new BinaryOperation(
                        visit(ctx.getChild(0)),
                        operator,
                        visit(ctx.getChild(2))
                );
            } catch (UnknownElementException ex) {
                addVisitError(ex.getMessage());
            }
        }

        return visit(ctx.concatenation(0));
    }

    @Override
    public Expression visitConcatenation(FormulaParser.ConcatenationContext ctx) {
        try {
            if (ctx.getChildCount() == 2) { // Convert unary operation
                int operatorid = 0, operand = 1;  // Assume operator on the left

//                if (ctx.getChild(1).getChildCount() == 0) { // Conclude that operator is on the right
                if (ctx.PERCENT() != null) { // Conclude that operator is on the right
                    operatorid = 1;
                    operand = 0;
                }

                return new UnaryOperation(
                        // Language.getInstance().getUnaryOperator(ctx.getChild(operatorid).getText()),
                        this.language.getUnaryOperator(ctx.getChild(operatorid).getText()),
                        visit(ctx.getChild(operand))
                );

            } else if (ctx.getChildCount() == 3) {
                // Convert binary operation
                // BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());
                return new BinaryOperation(
                        visit(ctx.getChild(0)),
                        operator,
                        visit(ctx.getChild(2))
                );
            }

        } catch (FormulaCompilationException ex) {
            addVisitError(ex.getMessage());
        }

        return visitChildren(ctx);
    }

    @Override
    public Expression visitAtom(FormulaParser.AtomContext ctx) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.getChild(1));
        }

        return visitChildren(ctx);
    }

    @Override
    public Expression visitFunction_call(FormulaParser.Function_callContext ctx) {
        // Convert function call
        Function function = null;
        try {
            // function = Language.getInstance().getFunction(ctx.getChild(0).getText());
            function = this.language.getFunction(ctx.getChild(0).getText());
        } catch (UnknownElementException ex) {
            addVisitError(ex.getMessage());
        }

        if (function != null) {
            try {
                List<Expression> args = new ArrayList<>();
                if (ctx.getChildCount() > 3) {
                    for (int nChild = 2; nChild < ctx.getChildCount() - 1; nChild += 2) {
                        args.add(visit(ctx.getChild(nChild)));
                    }
                }
                Expression[] argArray = args.toArray(new Expression[args.size()]);
                return new FunctionCall(function, argArray);
            } catch (IllegalFunctionCallException ex) {
                addVisitError(ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public Expression visitReference(FormulaParser.ReferenceContext ctx) {
        Token t = (Token) ctx.getChild(0).getPayload();
        try {
            if (t.getType() == FormulaParser.VARIABLE){
                return new VariableReference(cell.getFormula(), t.getText());
            }
            else if (ctx.getChildCount() == 3) {
                //BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
                BinaryOperator operator = this.language.getBinaryOperator(ctx.getChild(1).getText());

                return new ReferenceOperation(
                        new CellReference(cell.getSpreadsheet(), ctx.getChild(0).getText()),
                        (RangeReference) operator,
                        new CellReference(cell.getSpreadsheet(), ctx.getChild(2).getText())
                );
            } else {
                return new CellReference(cell.getSpreadsheet(), ctx.getText());
            }
            // return visitChildren(ctx); 
        } catch (ParseException | UnknownElementException ex) {
            addVisitError(ex.getMessage());
        }
        return null;
    }

    @Override
    public Expression visitLiteral(FormulaParser.LiteralContext ctx) {
        Token t = (Token) ctx.getChild(0).getPayload();

        if (t.getType() == FormulaParser.NUMBER) {
            return new Literal(Value.parseValue(ctx.getText()));
        } else {
            if (t.getType() == FormulaParser.STRING) {
                String value = ctx.getText().substring(1, ctx.getText().length() - 1);
                return new Literal(Value.parseValue(value, Value.Type.BOOLEAN, Value.Type.DATE));
            }
        }

        return null;
    }

    @Override
    public Expression visitLoopfor(FormulaParser.LoopforContext ctx) {
        // Convert function call
        Function forFunction = null;
        Value value = null;
        try {
            // function = Language.getInstance().getFunction(ctx.getChild(0).getText());
            forFunction = this.language.getFunction(ctx.getChild(0).getText());
        } catch (UnknownElementException ex) {
            addVisitError(ex.getMessage());
        }

        if (forFunction != null) {
            List<Expression> args = new ArrayList<>();
            if (ctx.getChildCount() > 3) {
                for (int nChild = 2; nChild < ctx.getChildCount() - 1; nChild += 2) {
                    args.add(visit(ctx.getChild(nChild)));
                }
            }
            Expression[] argArray = args.toArray(new Expression[args.size()]);
            Function loopfor = new For();
            try {
                value = loopfor.applyTo(argArray);
            } catch (IllegalValueTypeException ex) {
                Logger.getLogger(FormulaEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new Literal(value);
        }
        return null;
    }

    @Override
    public Expression visitAssignment(FormulaParser.AssignmentContext ctx) {
        if (ctx.getChildCount() == 3) {
            //BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
            BinaryOperator operator;
            try {
                operator = this.language.getBinaryOperator(ctx.getChild(1).getText());
                
                return new BinaryOperation(
                        visit(ctx.getChild(0)),
                        operator,
                        visit(ctx.getChild(2))
                );
            } catch (UnknownElementException ex) {
                Logger.getLogger(FormulaEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return visit(ctx.comparison());
    }
    
    @Override
    public Expression visitBlock(FormulaParser.BlockContext ctx){
        // Convert function call
        Function blockFunction = null;
        Value value = null;
        try {
            // function = Language.getInstance().getFunction(ctx.getChild(0).getText());
            blockFunction = this.language.getFunction(ctx.getChild(0).getText());
        } catch (UnknownElementException ex) {
            addVisitError(ex.getMessage());
        }

        if (blockFunction != null) {
            List<Expression> args = new ArrayList<>();
            if (1 < ctx.getChildCount()) {
                for (int nChild = 1; nChild < ctx.getChildCount() - 1; nChild += 2) {
                    args.add(visit(ctx.getChild(nChild)));
                }
            }
            Expression[] argArray = args.toArray(new Expression[args.size()]);
            Function block = new Block();
            try {
                value = block.applyTo(argArray);
            } catch (IllegalValueTypeException ex) {
                Logger.getLogger(FormulaEvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new Literal(value);
        }
        return null;
    }

    private void addVisitError(String msg) {
        errorBuffer.append(msg).append("\n");
        numberOfErros++;
    }
}
