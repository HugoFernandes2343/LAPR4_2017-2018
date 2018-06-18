package pt.isep.nsheets.shared.core.formula.lapr4.red.s3.s1161110.globalVariables;

import org.junit.Test;
import pt.isep.nsheets.shared.core.Value;

import static org.junit.Assert.*;

public class GlobalVariableListTest {

    private GlobalVariableList instance = new GlobalVariableList();

    /**
     *  **Test1:** I should ensure that the contains() method returns the correct value.
     */
    @Test
    public void ensureContainsReturnsCorrectVariable(){
        instance.addVariable(new GlobalVariable("Name", new Value(0)));
        String variableName = "Name";

        boolean expResult = true;
        boolean result = instance.contains(variableName);

        assertEquals(expResult, result);
    }

    /**
     *  **Test2:** I should ensure that the addVariable() method adds the correct variable.
     */
    @Test
    public void ensureAddVariableAddsVariable(){
        String variableName = "Name";
        instance.addVariable(new GlobalVariable(variableName, new Value(0)));

        boolean expResult = true;
        boolean result = instance.contains(variableName);

        assertEquals(expResult, result);
    }

    /**
     *  **Test3:** I should ensure that are the the get() method returns the correct variable.
     */
    @Test
    public void ensureGetReturnsVariable(){
        String variableName = "Name";
        instance.addVariable(new GlobalVariable(variableName, new Value(0)));

        GlobalVariable expResult = new GlobalVariable(variableName, new Value(0));
        GlobalVariable result = instance.get(variableName);

        assertEquals(expResult, result);
    }


}