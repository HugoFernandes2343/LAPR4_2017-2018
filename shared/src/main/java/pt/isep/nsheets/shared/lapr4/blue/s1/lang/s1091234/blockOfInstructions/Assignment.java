/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1091234.blockOfInstructions;

import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.formula.lang.CellReference;
import pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables.Variable;
import pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables.VariableReference;

/**
 *
 * @author Pedro Tedim
 */
public class Assignment implements BinaryOperator {
    @Override
    public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
     if (leftOperand instanceof CellReference) {
            // do the assignment
            Value value = rightOperand.evaluate(); 
            CellReference left=(CellReference) leftOperand;
            String content="";
            try { 
                // Need to handle all possible types because the set of a cell only accepts "text" or "formula"!!!
                switch (value.getType()) {
                    case NUMERIC: 
                        content=value.toNumber().toString();
                        break;
                    case TEXT:
                        content=value.toText();
                        break;
                    case BOOLEAN:
                        content=value.toBoolean().toString();
                        break;
                    case DATE:
                        content=value.toDate().toString();
                        break;
                    default:
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } 
                left.getCell().setContent(content);
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(Assignment.class.getName()).log(Level.SEVERE, null, ex);
            }
            return value;
            
        //Rodrigo 1140420 was here for this "else if"
        } else if (leftOperand instanceof VariableReference) {
            Variable temp = new Variable(((VariableReference) leftOperand).getName(), rightOperand.evaluate());
            switch (temp.getValue().getType()) {
                case NUMERIC:                    
                    ((VariableReference) leftOperand).setVariableValue(new Value(temp.getValue().toDouble()));
                    return new Value(temp.getValue().toDouble());

                case BOOLEAN:
                    ((VariableReference) leftOperand).setVariableValue(new Value(temp.getValue().toBoolean()));
                    return new Value(temp.getValue().toBoolean());
                case DATE:
                    ((VariableReference) leftOperand).setVariableValue(new Value(temp.getValue().toDate()));
                    return new Value(temp.getValue().toDate());
                case TEXT:
                    ((VariableReference) leftOperand).setVariableValue(new Value(temp.getValue().toText()));
                    return new Value(temp.getValue().toText());
                default:
                    throw new IllegalValueTypeException(temp.getValue(), Value.Type.NUMERIC);
            }
        }
     
        else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public String getIdentifier() {
        return ":=";
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.UNDEFINED;
    }

    @Override
    public String toString() {
        return getIdentifier();
    }

}
