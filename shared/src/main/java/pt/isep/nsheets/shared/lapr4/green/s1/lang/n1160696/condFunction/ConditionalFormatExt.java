/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.s1.lang.n1160696.condFunction;

import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.MaterialDataTable;
import java.util.Collection;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.CellExtension;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.Extension;
import pt.isep.nsheets.shared.services.CellImplDTO;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
public class ConditionalFormatExt extends Extension {

    
    
    
    
    public ConditionalFormatExt(String name) {
        super(name);
    }

    @Override
    public ConditionalFormatCellExtension extend(Cell cell) {

        return new ConditionalFormatCellExtension(cell, getName());

    }

    
    
    
    
    
    class ConditionalFormatCellExtension extends CellExtension {

        private Value conditionalValue;
        private String conditionalOperator;

        public ConditionalFormatCellExtension(Cell delegate, String name) {
            super(delegate, name);
        }

//        @Override
//        public CellImplDTO toDTO() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
        public void setConditionalValue(Value newValue) {
            this.conditionalValue = newValue;
        }

        public void setConditionalOperator(String newOperator) {
            this.conditionalOperator = newOperator;
        }

        @Override
        public void valueChanged(Cell cell) {

            try {

                BinaryOperationExt binaryOperation = new BinaryOperationExt(cell.getValue(), conditionalOperator, conditionalValue);
                if (binaryOperation.evaluate().toBoolean()) {
                    // aplicar estilos case true
                } else {
                    // aplicar estilos case false
                }
            } catch (UnknownElementException | IllegalValueTypeException e) {
                e.printStackTrace();
            }

        }

//        @Override
//        public void setSpreadsheet(Spreadsheet sh) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public Long getId() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
        public boolean applyConditions(Cell cell) {
            try {
                BinaryOperationExt binaryOperation = new BinaryOperationExt(cell.getValue(), conditionalOperator, conditionalValue);
                return binaryOperation.evaluate().toBoolean();
            } catch (UnknownElementException | IllegalValueTypeException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public CellImplDTO toDTO() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addColorExtension(String name, String c1, String c2, MaterialDataTable<?> table) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Collection<CellExtension> getListExtension() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
