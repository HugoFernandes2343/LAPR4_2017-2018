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
 

    public void testName() {
        Name e = new Name("David","Santiago");
        assertEquals("David",e.toDTO().getFirstName());
    }
    
    public void testName2() {
        Name e = new Name("David","Santiago");
        assertEquals("Santiago",e.toDTO().getLastName());
    }
    
    
    @Test(expected = IllegalArgumentException.class) 
    public void testName3() {
        Name e = new Name("David","");

    }
    
    
    @Test(expected = IllegalArgumentException.class) 
    public void testName4() {
        Name e = new Name("","Santiago");

    }

}
