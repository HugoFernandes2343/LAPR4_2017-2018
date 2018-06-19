package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;
import pt.isep.nsheets.shared.core.formula.Operation;
import pt.isep.nsheets.shared.core.formula.compiler.ExcelExpressionCompiler;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables.Variable;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Eval implements Function {

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
            new FunctionParameter(Value.Type.TEXT, "String", false, "The string to be compiled")};

    private Cell activeCell;
    private final ExcelExpressionCompiler compiler;

    public Eval() {
        this.compiler = new ExcelExpressionCompiler();
    }


    @Override
    public String getIdentifier() {
        return null;
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        Expression ret = null;
        String eval = args[0].evaluate().toText();
        String newEval;

        newEval = modifyToConcatenateOutsideQuotationMarks(eval);

        newEval = modifyForVariableUsage(newEval,"_");

        newEval = modifyForVariableUsage(newEval,"@");

        newEval = createFormula(newEval);

        try {
            ret = compiler.compile(activeCell, newEval);
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(Eval.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret.evaluate();
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public boolean isVarArg() {
        return true;
    }

    @Override
    public String funcDescription() {
        return "Evaluates the string inside";
    }

    @Override
    public String funcName() {
        return "Eval";
    }

    @Override
    public String funcSyntax() {
        return "\"= eval (\" 2 + 3 \")\" ";
    }

    public void defineCell(Cell cell) {
        this.activeCell = cell;
    }

    private String modifyToConcatenateOutsideQuotationMarks(String eval) {
        String newEval = "";

        if (eval.contains("&")) {
            String[] aux = eval.split("&");
            for (String aux1 : aux) {
                newEval += aux1;
            }
        } else {
            newEval = eval;
        }
        return newEval;
    }

    private String modifyForVariableUsage(String eval, String atOrUnderscore) {

        String ret = "";
        if (eval.contains(atOrUnderscore)) {
            String splitEval[] = eval.split(atOrUnderscore);
            try {
                Expression ex = compiler.compile(activeCell, "=" + atOrUnderscore + splitEval[1]);

                if (ex instanceof Variable) {

                    Value t = ex.evaluate();
                    ret = splitEval[0] + t.toString();
                } else if (ex instanceof Operation) {
                    String operator = ((Operation) ex).getOperator().getIdentifier();
                    String[] splitOperator = eval.split("\\" + operator);
                    for (int i = 0; i < splitOperator.length; i++) {
                        if (i == splitOperator.length - 1) {
                            ret += tempVariableFinder(splitOperator[i],atOrUnderscore);
                        } else {
                            ret += tempVariableFinder(splitOperator[i],atOrUnderscore) + operator;
                        }
                    }

                }

            } catch (FormulaCompilationException | IllegalValueTypeException ex) {
                Logger.getLogger(Eval.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            return eval;
        }
        return ret;
    }
    private String createFormula(String eval) {

        if (!eval.startsWith("=")) {
            eval = "=" + eval;
        }

        return eval;
    }
    private String tempVariableFinder(String operationSegment, String atOrUnderscore) {
        String ret;
        if (operationSegment.contains(atOrUnderscore)) {
            ret = modifyForVariableUsage(operationSegment, atOrUnderscore);
        } else {
            ret = operationSegment;
        }
        return ret;
    }
}
