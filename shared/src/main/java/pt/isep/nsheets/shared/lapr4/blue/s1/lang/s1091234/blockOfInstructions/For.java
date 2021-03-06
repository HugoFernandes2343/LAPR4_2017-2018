/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1091234.blockOfInstructions;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

/**
 *
 * @author Pedro Tedim
 */
public class For implements Function {

    public boolean initialized = false;
    Value value = null;
    Value boundary = new Value(true);
    private int nextBlock = 1;

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "ForExpression", false,
        "The for expressions")
    };
    /**
     * Creates a new instance of the FOR function.
     */
    public For(){
    }

    @Override
    public String getIdentifier() {
        return "FOR";
    }

    @Override
    public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {
        if (!initialized) {
            initialized = true;
            arguments[0].evaluate(); //execute initialization expression

            //boundary expression
            boundary = arguments[1].evaluate();

            //while boundary condition is true
            while (boundary.toBoolean()) {

                //evaluate other blocks
                while (nextBlock < arguments.length - 1) {
                    nextBlock++;
                    value = arguments[nextBlock].evaluate();
                }
                nextBlock = 1;

                //retest boundary condition
                boundary = arguments[1].evaluate();
            }

            initialized = false;
            return value;
        }

        return boundary;
    }

    @Override
    public boolean isVarArg() {
        return value.isOfType(Value.Type.UNDEFINED);
    }

    @Override
    public String funcDescription() {
        return "FOR cycle for multiple iterations over the same code." +
                " Requires the syntax FOR{Assignment;Comparison;Assignment;Assignment}" +
                " where the first Assignment is the value given to the incremental variable." +
                " The comparison is the condition to stop the iteration." +
                " The second and third Assignment are the operation and incrementation of the first Assignment respectively.";
    }

    @Override
    public String funcName() {
        return "FOR cycle";
    }

    @Override
    public String funcSyntax() {
        return "=FOR{A1:=1;A1<10;A2:=A2+A1;A1:=A1+1}";
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

}
