package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

public class DoWhile implements Function {
    public static final FunctionParameter[] parameters = new FunctionParameter[]{
            new FunctionParameter(Value.Type.NUMERIC, "Number", false, "Executes while conditon is true")};

    @Override
    public String getIdentifier() {
        return "DoWhile";
    }

        @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {

        while(args[1].evaluate().toBoolean()==true){


            args[0].evaluate();


        }

        return new Value();
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
         return "Executes while conditon is true";
    }

    @Override
    public String funcName() {
        return "Do While";
    }

    @Override
    public String funcSyntax() {
        return "Do()While()";
    }

}
