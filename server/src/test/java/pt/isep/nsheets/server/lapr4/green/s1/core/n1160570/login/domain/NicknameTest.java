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
import pt.isep.nsheets.shared.services.NicknameDTO;

/**
 *
 * @author Paulo Jorge
 */
public class NicknameTest {
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        Nickname instance = new Nickname("Paulo");
        Object o = instance;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertTrue(result);
    }

    /**
     * Test of toString method, of class Nickname.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Nickname instance = new Nickname("Paulo");
        String expResult = "Paulo";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Nickname.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Nickname instance = new Nickname("Paulo");
        int expResult = 76887303;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toDTO method, of class Nickname.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        Nickname instance = new Nickname("Paulo");
        NicknameDTO expResult = new NicknameDTO("Paulo");
        NicknameDTO result = instance.toDTO();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of fromDTO method, of class Nickname.
     */
    @Test
    public void testFromDTO() {
        System.out.println("fromDTO");
        NicknameDTO dto = new NicknameDTO("Paulo");
        Nickname expResult = new Nickname("Paulo");
        Nickname result = Nickname.fromDTO(dto);
        assertEquals(expResult, result);
    }

    public NicknameTest() {
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
     * Test of equals method, of class Nickname.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testName3() {
        Nickname e= new Nickname("");
    }

}
