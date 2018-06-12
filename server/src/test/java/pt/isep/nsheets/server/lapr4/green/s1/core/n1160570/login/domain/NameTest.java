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
import pt.isep.nsheets.shared.services.NameDTO;

/**
 *
 * @author Paulo Jorge
 */
public class NameTest {

    public NameTest() {
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
     * Test of equals method, of class Name.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Name instance = new Name("Paulo", "Magalhaes");
        Object obj = instance;
        boolean result = instance.equals(obj);
        assertTrue(result);

    }

    /**
     * Test of hashCode method, of class Name.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Name instance = new Name("Paulo","Magalhaes");
        int expResult = 2000905438;
        int result = instance.hashCode();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of toString method, of class Name.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Name instance = new Name("Paulo", "Magalhaes");
        String expResult = "Paulo Magalhaes";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toDTO method, of class Name.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        Name instance = new Name("Paulo", "Magalhaes");
        NameDTO expResult = new NameDTO("Paulo", "Magalhaes");
        NameDTO result = instance.toDTO();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of fromDTO method, of class Name.
     */
    @Test
    public void testFromDTO() {
        System.out.println("fromDTO");
        NameDTO dto = new NameDTO("Paulo", "Magalhaes");
        Name expResult = new Name("Paulo", "Magalhaes");
        Name result = Name.fromDTO(dto);
        assertEquals(expResult, result);
    }

}
