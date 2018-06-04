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
        } else {
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
