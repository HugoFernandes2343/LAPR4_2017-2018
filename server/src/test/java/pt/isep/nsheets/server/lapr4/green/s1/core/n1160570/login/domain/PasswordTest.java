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
import pt.isep.nsheets.shared.services.PasswordDTO;

/**
 *
 * @author Paulo Jorge
 */
public class PasswordTest {
    
    public PasswordTest() {
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
     * Test of hashCode method, of class Password.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Password instance = new Password("pass");
        int expResult = 3433884;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Password.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        Password instance = new Password();
        Object obj = instance;
        boolean result = instance.equals(obj);
        assertTrue(result);
    }

    /**
     * Test of toString method, of class Password.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Password instance = new Password("pass");
        String expResult = "Password{password=pass}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toDTO method, of class Password.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        Password instance = new Password("pass");
        PasswordDTO expResult = new PasswordDTO("pass");
        PasswordDTO result = instance.toDTO();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of fromDTO method, of class Password.
     */
    @Test
    public void testFromDTO() {
        System.out.println("fromDTO");
        PasswordDTO dto = new PasswordDTO("pass");
        Password expResult = new Password("pass");
        Password result = Password.fromDTO(dto);
        assertEquals(expResult, result);
    }
    
}
