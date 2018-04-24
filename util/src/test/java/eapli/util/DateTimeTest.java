/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.util;

import java.util.Calendar;
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
public class DateTimeTest {

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
     * Test of weekNumber method, of class DateTime.
     */
    @Test
    public void testJanuaryFirst2014IsWeekOne() {
        // TODO do not use own methods whcih have not been tested yet
        Calendar date = DateTime.newCalendar(2014, 01, 01);
        int expResult = 1;
        int result = DateTime.weekNumber(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of weekNumber method, of class DateTime.
     */
    @Test
    public void testMarch21st2014IsWeek12() {
        // TODO do not use own methods whcih have not been tested yet
        Calendar date = DateTime.newCalendar(2014, 03, 21);
        int expResult = 12;
        int result = DateTime.weekNumber(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of beginningOfWeek method, of class DateTime.
     */
    // @Test
    // public void testFirstDayOfWeek13Of2014Is16() {
    // System.out.println("beginningOfWeek");
    // int year = 2014;
    // int week = 13;
    // Calendar expResult = DateTime.newCalendar(2014, 03, 16);
    // Calendar result = DateTime.beginningOfWeek(year, week);
    // assertEquals(expResult, result);
    // }
    /**
     * Test of endOfWeek method, of class DateTime.
     */

    // @Test
    // public void testLastDayOfWeek13Of2014Is22() {
    // System.out.println("endOfWeek");
    // int year = 2014;
    // int week = 13;
    // Calendar expResult = DateTime.newCalendar(2014, 03, 22);
    // Calendar result = DateTime.endOfWeek(year, week);
    // assertEquals(expResult, result);
    // }
    /**
     * Test of endOfMonth method, of class DateTime.
     */
    @Test
    public void testLastDayOfMarch2014is31() {
        Calendar reference = DateTime.newCalendar(2014, 03, 21);
        Calendar expResult = DateTime.newCalendar(2014, 03, 31);
        Calendar result = DateTime.endOfMonth(reference);
        assertEquals(expResult, result);
    }

    /**
     * Test of endOfMonth method, of class DateTime.
     */
    @Test
    public void testLastDayOfFebruary2014is28() {
        Calendar reference = DateTime.newCalendar(2014, 02, 21);
        Calendar expResult = DateTime.newCalendar(2014, 02, 28);
        Calendar result = DateTime.endOfMonth(reference);
        assertEquals(expResult, result);
    }

    /**
     * Test of endOfMonth method, of class DateTime.
     */
    @Test
    public void testLastDayOfFebruary2012is29() {
        Calendar reference = DateTime.newCalendar(2012, 02, 21);
        Calendar expResult = DateTime.newCalendar(2012, 02, 29);
        Calendar result = DateTime.endOfMonth(reference);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseDate method, of class DateTime.
     */
    // @Test
    // public void testParseDate_String_String() {
    // System.out.println("parseDate");
    // String aDateString = "2014-03-21";
    // String format = "YYYY-MM-DD";
    // Calendar expResult = DateTime.newCalendar(2014, 03, 21);
    // Calendar result = DateTime.parseDate(aDateString, format);
    // assertEquals(expResult, result);
    // }
}
