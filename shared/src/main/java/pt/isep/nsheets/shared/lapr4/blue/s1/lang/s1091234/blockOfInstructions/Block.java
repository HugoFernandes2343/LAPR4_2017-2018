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
public class Block implements Function {
    
    Value value = null;

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "BlockExpressions", false,
        "The block expressions")
    };
    
    @Override
    public String getIdentifier() {
        return "{";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {

        // performs all expressions in args and returns the evaluation of the last one
        for (Expression expression : args) {
            this.value = expression.evaluate();
        }

        return this.value;
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public boolean isVarArg() {
        return value.isOfType(Value.Type.UNDEFINED);
    }

    @Override
    public String funcDescription() {
        return null;
    }

    @Override
    public String funcName() {
        return null;
    }

    @Override
    public String funcSyntax() {
        return null;
    }

}
