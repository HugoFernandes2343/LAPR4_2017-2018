/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lapr4.green.s2.lang.n1150575.tempVariables;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables.Variable;

/**
 *
 * @author João Vieira
 */
public class VariableTest {

    private Variable instance;

    @Before
    public void setUp() {
        this.instance = new Variable("Name",new Value(0));
    }

    @Test
    public void ensureGetNameReturnsRightName() {
        String expResult = "Name";
        String result = this.instance.getName();
        
        assertEquals(expResult, result);
    }

    @Test
    public void ensureGetValueReturnsRightValue() {
        Value expResult = new Value(0);
        Value result = this.instance.getValue();
        
        assertEquals(expResult, result);
    }

    @Test
    public void ensureSetValueReturnsRightValue() {
        Value expResult = new Value(10);
        this.instance.setValue(new Value(10));
        
        Value result = this.instance.getValue();
        
        assertEquals(expResult, result);
    }

    @Test
    public void ensureEqualsReturnsTrueWithEqualObjects() {
        Variable newVariable = new Variable("Name",new Value(0));
        
        boolean expResult = true;
        boolean result = this.instance.equals(newVariable);
        
        assertEquals(expResult, result);
    }

    @Test
    public void ensureEqualsReturnsFalseWithNullObjects() {
        Variable newVariable = null;
        
        boolean expResult = false;
        boolean result = this.instance.equals(newVariable);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void ensureEqualsReturnsFalseWithDifferentClassObjects() {
        Value newVariable = new Value(0);
        
        boolean expResult = false;
        boolean result = this.instance.equals(newVariable);
        
        assertEquals(expResult, result);
    }
    
}
