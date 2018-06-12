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
import pt.isep.nsheets.shared.services.NameDTO;
import pt.isep.nsheets.shared.services.NicknameDTO;
import pt.isep.nsheets.shared.services.PasswordDTO;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UserTypeDTO;

/**
 *
 * @author Paulo Jorge
 */
public class UserTest {

    private User u;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        u = new User(new Email("email@email.com"), new Password("pass"), new Nickname("paulo"), new Name("Paulo", "Magalhaes"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setUserType method, of class User.
     */
    @Test
    public void testSetUserType() {
        System.out.println("setUserType");
        UserType userType = UserType.ADMIN;
        u.setUserType(userType);
        assertEquals(userType, u.getUserType());
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        System.out.println(u.toString());
        String expResult = "Email: email@email.com Password{password=pass} paulo Paulo Magalhaes";
        String result = u.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of sameAs method, of class User.
     */
    @Test
    public void testSameAs() {
        System.out.println("sameAs");
        Object obj = u;
        boolean result = u.sameAs(obj);
        assertTrue(result);
    }

    /**
     * Test of is method, of class User.
     */
    @Test
    public void testIs() {
        System.out.println("is");
        Email email = new Email("email@email.com");
        boolean result = u.is(email);
        assertTrue(result);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Email email = new Email("email@email.com");
        Email result = u.getEmail();
        assertEquals(email, result);
    }

    /**
     * Test of id method, of class User.
     */
    @Test
    public void testId() {
        System.out.println("id");
        Email expResult = new Email("email@email.com");
        Email result = u.id();
        assertEquals(expResult, result);
    }

    /**
     * Test of toDTO method, of class User.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        UserDTO expResult = new UserDTO(new EmailDTO("email@email.com"), new PasswordDTO("pass"), new NameDTO("Paulo", "Magalhaes"), new NicknameDTO("paulo"));
        UserDTO result = u.toDTO();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getNickname method, of class User.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        Nickname expResult = new Nickname("paulo");
        Nickname result = u.getNickname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Name expResult = new Name("Paulo", "Magalhaes");
        Name result = u.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of fromDTO method, of class User.
     */
    @Test
    public void testFromDTO() {
        System.out.println("fromDTO");
        UserDTO expResult = new UserDTO(new EmailDTO("email@email.com"), new PasswordDTO("pass"), new NameDTO("Paulo", "Magalhaes"), new NicknameDTO("paulo"));
        User result = User.fromDTO(expResult);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getUserType method, of class User.
     */
    @Test
    public void testGetUserType() {
        System.out.println("getUserType");
        UserType expResult = UserType.USER;
        UserType result = u.getUserType();
        assertEquals(expResult, result);
    }

}
