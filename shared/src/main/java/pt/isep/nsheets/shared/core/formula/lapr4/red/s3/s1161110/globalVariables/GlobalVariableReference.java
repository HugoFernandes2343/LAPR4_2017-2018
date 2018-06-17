/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lapr4.red.s3.s1161110.globalVariables;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;

/**
 *
 * @author David Maia
 */
public class GlobalVariableReference implements Expression{
    /**
     * Variable name
     */
    private final String name;

    /**
     * The Cell this "VariableReference" is from
     */
    private final Cell cell;

    /**
     * The actual Variable referenced by this
     */
    private GlobalVariable v;

    public GlobalVariableReference(Workbook wb, Cell cell, String name) {
        this.name = name;
        this.cell = cell;
        this.v = wb.addVariable(name);
    }


    public String getName (){
        return name;
    }    

    public void setVariableValue (Value value){
        v.setValue(value);
    }    

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Value evaluate() {
        return v.getValue();
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitGlobalVariableReference(this);
    }
}
