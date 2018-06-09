/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1160696.condFunction;

import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
public class BinaryOperationExt extends BinaryOperation{
    
    public BinaryOperationExt(Value leftOperand, String condOperator, Value rightOperand) throws UnknownElementException {
       
        super(new Literal(leftOperand), new Language("oi").getBinaryOperator(condOperator), new Literal(rightOperand));
    }
    
}
