package pt.isep.nsheets.shared.core.formula.lapr4.red.s3.s1161110.globalVariables;

import org.junit.Test;
import pt.isep.nsheets.shared.core.Value;

import static org.junit.Assert.*;

public class GlobalVariableTest {

    private GlobalVariable instance =  new GlobalVariable("Name",new Value(0));
    /**
     * Test1:** I should ensure that the getName() method returns the correct name.
     */

    @Test
    public void ensureGetNameReturnsRightName() {
        String expResult = "Name";
        String result = this.instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test2:** I should ensure that the getValue() method returns the correct value.
     */


    @Test
    public void ensureGetValueReturnsRightValue() {
        Value expResult = new Value(0);
        Value result = this.instance.getValue();

        assertEquals(expResult, result);
    }


    /**
     * Test3:** I should ensure that are the the setValue() method sets the correct value.
     */

    @Test
    public void ensureSetValueReturnsRightValue() {
        Value expResult = new Value(10);
        this.instance.setValue(new Value(10));

        Value result = this.instance.getValue();

        assertEquals(expResult, result);
    }

    /**
     * Test4:** I should ensure that the equals() method returns the correct answer.
     *
     */

    @Test
    public void ensureEqualsReturnsTrueWithEqualObjects() {
        GlobalVariable newVariable = new GlobalVariable("Name",new Value(0));

        boolean expResult = true;
        boolean result = this.instance.equals(newVariable);

        assertEquals(expResult, result);
    }

    /**
     * Test5:** I should ensure that the equals() method returns the correct answer.
     */

    @Test
    public void ensureEqualsReturnsFalseWithNullObjects() {
        GlobalVariable newVariable = null;

        boolean expResult = false;
        boolean result = this.instance.equals(newVariable);

        assertEquals(expResult, result);
    }

    /**
     * Test6:** I should ensure that the equals() method returns the correct answer.
     */

    @Test
    public void ensureEqualsReturnsFalseWithDifferentClassObjects() {
        Value newVariable = new Value(0);

        boolean expResult = false;
        boolean result = this.instance.equals(newVariable);

        assertEquals(expResult, result);
    }


}