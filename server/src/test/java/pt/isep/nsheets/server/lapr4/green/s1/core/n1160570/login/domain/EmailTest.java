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
import pt.isep.nsheets.shared.services.EmailDTO;

/**
 *
 * @author Paulo Jorge
 */
public class EmailTest {

    public EmailTest() {
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
     * Test of toString method, of class Email.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Email instance = new Email("email@email.com");
        String expResult = "Email: email@email.com";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Email.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Email instance = new Email();
        int expResult = 115;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Email.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Email instance = new Email("email@email.com");
        Object obj = (Object) instance;
        boolean result = instance.equals(obj);
        assertTrue(result);

    }

    /**
     * Test of toDTO method, of class Email.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        Email instance = new Email("email@email.com");
        EmailDTO expResult = new EmailDTO("email@email.com");
        EmailDTO result = instance.toDTO();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of fromDTO method, of class Email.
     */
    @Test
    public void testFromDTO() {
        System.out.println("fromDTO");
        EmailDTO dto = new EmailDTO("email@email.com");
        Email expResult = new Email("email@email.com");
        Email result = Email.fromDTO(dto);
        assertEquals(expResult, result);
    }

}
