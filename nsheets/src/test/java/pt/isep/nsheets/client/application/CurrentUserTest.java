/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.shared.services.EmailDTO;
import pt.isep.nsheets.shared.services.NameDTO;
import pt.isep.nsheets.shared.services.NicknameDTO;
import pt.isep.nsheets.shared.services.PasswordDTO;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
public class CurrentUserTest {

    public CurrentUserTest() {
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
     * Test of isIsLoggedIn method, of class CurrentUser.
     */
    @Test
    public void testIsIsLoggedIn() {
        System.out.println("isIsLoggedIn");
        boolean expResult = true;
        boolean result = CurrentUser.isIsLoggedIn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsLoggedIn method, of class CurrentUser.
     */
    @Test
    public void testSetIsLoggedIn() {
        System.out.println("setIsLoggedIn");
        boolean isLoggedIn = true;
        CurrentUser.setIsLoggedIn(isLoggedIn);
        assertEquals(isLoggedIn, CurrentUser.isIsLoggedIn());
    }

    /**
     * Test of getCurrentUser method, of class CurrentUser.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("getCurrentUser");
        UserDTO currentUser = new UserDTO(new EmailDTO("email@email.com"), 
        new PasswordDTO("pass"), new NameDTO("Paulo", "Magalhaes"), new NicknameDTO("paulo"));
        
        CurrentUser.setCurrentUser(currentUser);
        UserDTO result = CurrentUser.getCurrentUser();
        assertEquals(currentUser, result);
    }

    /**
     * Test of setCurrentUser method, of class CurrentUser.
     */
    @Test
    public void testSetCurrentUser() {
        System.out.println("setCurrentUser");
        UserDTO currentUser = new UserDTO(new EmailDTO("email@email.com"), 
        new PasswordDTO("pass"), new NameDTO("Paulo", "Magalhaes"), new NicknameDTO("paulo"));
        CurrentUser.setCurrentUser(currentUser);
        assertEquals(currentUser, CurrentUser.getCurrentUser());
    }

    /**
     * Test of isShowAll method, of class CurrentUser.
     */
    @Test
    public void testIsShowAll() {
        System.out.println("isShowAll");
        boolean result = CurrentUser.isShowAll();
        assertTrue( result);
    }

    /**
     * Test of setShowAll method, of class CurrentUser.
     */
    @Test
    public void testSetShowAll() {
        System.out.println("setShowAll");
        boolean showAll = false;
        CurrentUser.setShowAll(showAll);
    }

    /**
     * Test of logout method, of class CurrentUser.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        CurrentUser.logout();
        assertFalse(CurrentUser.isIsLoggedIn());
    }

}
