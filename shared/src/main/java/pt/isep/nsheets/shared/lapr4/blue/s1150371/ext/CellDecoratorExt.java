/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1150371.ext;

import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.MaterialDataTable;
import java.util.Collection;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.CellExtension;
import pt.isep.nsheets.shared.services.CellImplDTO;

/**
 *
 * @author josea
 */
public class CellDecoratorExt extends CellExtension {

    private String negativeColor;
    private String positiveColor;
    private final MaterialDataTable<?> table;

    public CellDecoratorExt(Cell delegate, String name, String negativeColor, String positiveColor, MaterialDataTable<?> table) {
        super(delegate, name);
        this.negativeColor = negativeColor;
        this.positiveColor = positiveColor;
        this.table = table;
    }

    @Override
      public void valueChanged(Cell cell) {
        try {
            Value v = cell.getValue();
            if (v.isOfType(Value.Type.NUMERIC)) {
                double d = v.toDouble();
                int row = cell.getAddress().getRow();
                int column = cell.getAddress().getColumn() + 1;

                if (d < 0) {
                    table.getRows().get(row).getWidget().getColumn(column).getElement().getStyle().setBackgroundColor(getNegativeColor());
                } else if (d >= 0) {
                    table.getRows().get(row).getWidget().getColumn(column).getElement().getStyle().setBackgroundColor(getPositiveColor());
                } else {
                    MaterialToast.fireToast("ERROR: cellDecoratorExt");
                }
            }
        } catch (IllegalValueTypeException ex) {
            MaterialToast.fireToast("ERROR: cellDecoratorExt");
        }
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

    /**
     * @return the negativeColor
     */
    public String getNegativeColor() {
        return negativeColor;
    }

    /**
     * @param negativeColor the negativeColor to set
     */
    public void setNegativeColor(String negativeColor) {
        this.negativeColor = negativeColor;
    }

    /**
     * @return the positiveColor
     */
    public String getPositiveColor() {
        return positiveColor;
    }

    /**
     * @param positiveColor the positiveColor to set
     */
    public void setPositiveColor(String positiveColor) {
        this.positiveColor = positiveColor;
    }

}
