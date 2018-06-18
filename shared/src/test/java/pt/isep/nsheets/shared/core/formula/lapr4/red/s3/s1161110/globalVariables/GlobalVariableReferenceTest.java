package pt.isep.nsheets.shared.core.formula.lapr4.red.s3.s1161110.globalVariables;

import org.junit.Test;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.Workbook;

import static org.junit.Assert.*;

public class GlobalVariableReferenceTest {

    private GlobalVariableReference instance = new GlobalVariableReference(new Workbook(), new CellImpl(), "Name");

    /**
     *  **Test1:** I should ensure that the getName() method returns the correct name.
     */
    @Test
    public void ensureGetNameReturnsCorrectName(){
        String name = "Name";

        String expResult = name;
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    /**
     *  **Test2:** I should ensure that the evaluate() method returns the correct value.
     */

    @Test
    public void ensureEvaluateReturnsTheCorrectValue(){
        Value value = new Value(10);
        instance.setVariableValue(value);

        Value expResult = instance.evaluate();
        Value result = value;

        assertEquals(expResult, result);
    }

    /**
     *  **Test3:** I should ensure that are the the setValue() method sets the correct value.
     */
    @Test
    public void ensureSetVariableValueSetsTheCorrectValue(){
        Value value = new Value(10);
        instance.setVariableValue(value);

        Value expResult = instance.evaluate();
        Value result = value;

        assertEquals(expResult, result);
    }

    /**
     *  **Test4:** I should ensure that the toString() method returns the correct answer.
     */
    @Test
    public void ensureToStringReturnsTheCorrectString(){

        String expResult = "Name";
        String result = instance.toString();

        assertEquals(expResult, result);
    }

}