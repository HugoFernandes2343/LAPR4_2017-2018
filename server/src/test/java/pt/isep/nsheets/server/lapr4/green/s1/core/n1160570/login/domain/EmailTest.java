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
     * Test of equals method, of class Email.
     */
   @Test(expected = IllegalArgumentException.class) 
    public void testEmail() {
        Email e = new Email("dasdsadsa");
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void testEmail2() {
        Email e = new Email("dasdsadsa@dsadsaasd");
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void testEmail3() {
        Email e = new Email("dasdsadsa@dasdas.sadsadsasaddsa");
    }
    
    public void testEmail4() {
        Email e = new Email("david@david.com");
        assertEquals("david@david.com",e.toDTO().getEmail());
    }
}
