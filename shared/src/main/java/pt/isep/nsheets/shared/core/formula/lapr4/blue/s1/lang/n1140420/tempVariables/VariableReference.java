/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables;

import java.util.SortedSet;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Formula;
import pt.isep.nsheets.shared.core.formula.Reference;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;

/**
 *
 * @author Rodrigo
 */
public class VariableReference implements Reference{
    /**
     * Variable name
     */
    private final String name;
    
    /**
     * The Formula this "VariableReference" is from
     */
    private final Formula formula;
    
    /**
     * The actual Variable referenced by this
     */
    private Variable v;
    
    public VariableReference(Formula formula, String name) {
        this.name = name;
        this.formula = formula;
        this.v = new Variable(name, new Value(0)); //Start with "0" by default
        formula.addTempVariable(v);
    }

    public void setVariableValue (Value value){
        v.setValue(value);
    }    

    @Override
    public Value evaluate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SortedSet<Cell> getCells() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Reference reference) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitVariableReference(this);
    }
}
