/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lapr4.green.s2.lang.n1150575.tempVariables;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables.Variable;
import pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables.VariableList;

/**
 *
 * @author João Vieira
 */
public class VariableListTest {

    private VariableList instance;

    @Before
    public void setUp() {
        Map<String, Variable> variableList = new HashMap<>();
        Variable v = new Variable("Name", new Value(0));
        variableList.put(v.getName(), v);
        this.instance = new VariableList(variableList);
        
    }

    @Test
    public void ensureContainsReturnsCorrectVariable(){
        String variableName = "Name";
        
        boolean expResult = true;
        boolean result = instance.contains(variableName);
        
        assertEquals(expResult, result);
    }

    @Test
    public void ensureAddVariableAddsVariable(){
        String variableName = "Name";
        instance.addVariable(new Variable(variableName, new Value(0)));
        
        boolean expResult = true;
        boolean result = instance.contains(variableName);
        
        assertEquals(expResult, result);
    }

    @Test
    public void ensureGetReturnsVariable(){
        String variableName = "Name";
        instance.addVariable(new Variable(variableName, new Value(0)));
        
        Variable expResult = new Variable(variableName, new Value(0));
        Variable result = instance.get(variableName);
        
        assertEquals(expResult, result);
    }
    
}
