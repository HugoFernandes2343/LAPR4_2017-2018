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
    public FunctionParameter[] getParameters() {
        return parameters;
    }

}
