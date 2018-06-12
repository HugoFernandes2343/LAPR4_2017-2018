/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paulo Jorge
 */
public class UserTypeTest {

    public UserTypeTest() {
    }

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
     * Test of values method, of class UserType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        UserType[] expResult = new UserType[2];
        assertEquals(expResult.length, 2);
    }

    /**
     * Test of valueOf method, of class UserType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "USER";
        UserType expResult = UserType.USER;
        UserType result = UserType.valueOf(name);
        assertEquals(expResult, result);
    }

}
