/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.framework.domain;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ClosedRangeTest extends AbstractRangeTest {


    @BeforeClass
    public static void setUpClass() {
        System.out.println("closedRange");
        instance = Range.closedRange(START, END);
    }

    @AfterClass
    public static void tearDownClass() {
    }
    public ClosedRangeTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ensureStartIsInRange() {
        System.out.println("ensureStartIsInRange");
        Long target = new Long(START_VALUE);
        boolean result = instance.includes(target);
        assertTrue("start must be part of a closed range", result);
    }

    @Test
    public void ensureEndIsInRange() {
        System.out.println("ensureEndIsInRange");
        Long target = new Long(END_VALUE);
        boolean result = instance.includes(target);
        assertTrue("end must be part of a closed range", result);
    }
}
