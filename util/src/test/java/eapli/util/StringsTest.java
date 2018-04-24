/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.util;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class StringsTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isNullOrEmpty method, of class Validations.
     */
    @Test
    public void testStringWithContentIsNotNullNorEmpty() {
        final String text = "abcdef";
        final boolean expResult = false;
        final boolean result = Strings.isNullOrEmpty(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNullOrEmpty method, of class Validations.
     */
    @Test
    public void testNullIsNullOrEmpty() {
        final String text = null;
        final boolean expResult = true;
        final boolean result = Strings.isNullOrEmpty(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNullOrEmpty method, of class Validations.
     */
    @Test
    public void testEmptyStringIsNullOrEmpty() {
        final String text = "";
        final boolean expResult = true;
        final boolean result = Strings.isNullOrEmpty(text);
        assertEquals(expResult, result);
    }
}
