/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lapr4.green.s2.lang.n1150575.tempVariables;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables.VariableReference;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;

/**
 *
 * @author João Vieira
 */
public class VariableReferenceTest {

    private VariableReference instance;
    
    @Before
    public void setUp() {
        this.instance = new VariableReference(new CellImpl() {}, "Name");
    }
    
    @Test
    public void ensureGetNameReturnsCorrectName(){
        String name = "Name";
        
        String expResult = name;
        String result = instance.getName();
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void ensureEvaluateReturnsTheCorrectValue(){
        Value value = new Value(10);
        instance.setVariableValue(value);
        
        Value expResult = instance.evaluate();
        Value result = value;
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void ensureSetVariableValueSetsTheCorrectValue(){
        Value value = new Value(10);
        instance.setVariableValue(value);
        
        Value expResult = instance.evaluate();
        Value result = value;
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void ensureToStringReturnsTheCorrectString(){
        
        String expResult = "Name";
        String result = instance.toString();
        
        assertEquals(expResult, result);
    }
}
