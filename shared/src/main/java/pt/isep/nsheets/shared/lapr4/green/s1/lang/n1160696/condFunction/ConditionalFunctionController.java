/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.s1.lang.n1160696.condFunction;

import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.green.s1.lang.n1160696.condFunction.ConditionalFormatExt.ConditionalFormatCellExtension;
import pt.isep.nsheets.shared.services.CellImplDTO;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
public class ConditionalFunctionController {
    
     public ConditionalFunctionController(){
        
    }
     
    public boolean activateExtension(CellImplDTO activeCell, String name, String operator, String value) throws FormulaCompilationException, IllegalValueTypeException{
        
        
        ConditionalFormatExt cfe = new ConditionalFormatExt(name);
        
        
        Cell c = CellImpl.fromDTO(activeCell);
        c.setContent(activeCell.content);
        
        
        ConditionalFormatCellExtension e = cfe.extend(c);
        e.setConditionalOperator(operator);
        
        Value v = new Value(value);

        e.setConditionalValue(v);
        
        
        
        e.valueChanged(c);

        return true;
    }
    
}
