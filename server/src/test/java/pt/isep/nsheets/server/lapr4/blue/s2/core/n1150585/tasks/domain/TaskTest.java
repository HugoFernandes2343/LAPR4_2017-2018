/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s2.core.n1150585.tasks.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.shared.services.TaskDTO;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public class TaskTest {

    /**
     * Test of sameAs method, of class Task.
     */
    @Test
    public void testSameAs() {
        System.out.println("sameAs");

        Task t1 = new Task("teste1", "descrição 1", 1, 1);
        Task t2 = new Task("teste2", "descrição 2", 1, 1);
        Task t3 = new Task("teste3", "descrição 3", 1, 1);
        Task t4 = new Task("teste4", "descrição 4", 1, 1);

        Task instance1 = new Task("teste1", "descrição 1", 1, 1);
        boolean expResult1 = true;
        boolean result1 = instance1.sameAs(t1);
        assertEquals(expResult1, result1);

        boolean expResult2 = false;
        boolean result2 = t2.sameAs(t3);
        assertEquals(expResult2, result2);

        Task instance3 = new Task("teste4", "descrição 4", 1, 1);
        boolean expResult3 = true;
        boolean result3 = instance3.sameAs(t4);
        assertEquals(expResult1, result1);

    }

    /**
     * Test of getTitle method, of class Task.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");

        Task instance = new Task("teste1", "descrição 1", 1, 1);
        String expResult = "teste1";
        String result = instance.getTitle();
        assertEquals(expResult, result);

        Task instance1 = new Task("teste2", "descrição 1", 1, 1);
        String expResult1 = "teste2";
        String result1 = instance1.getTitle();
        assertEquals(expResult1, result1);
    }

    /**
     * Test of getDescription method, of class Task.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");

        Task instance = new Task("teste1", "descrição 1", 1, 1);
        String expResult = "descrição 1";
        String result = instance.getDescription();
        assertEquals(expResult, result);

        Task instance1 = new Task("teste2", "descrição 2", 1, 1);
        String expResult1 = "descrição 2";
        String result1 = instance1.getDescription();
        assertEquals(expResult1, result1);

    }

    /**
     * Test of getPriority method, of class Task.
     */
    @Test
    public void testGetPriority() {
        System.out.println("getPriority");

        Task instance1 = new Task("teste1", "descrição 1", 1, 1);
        int expResult1 = 1;
        int result1 = instance1.getPriority();
        assertEquals(expResult1, result1);

        Task instance2 = new Task("teste2", "descrição 1", 2, 1);
        int expResult2 = 2;
        int result2 = instance2.getPriority();
        assertEquals(expResult2, result2);

        Task instance3 = new Task("teste3", "descrição 1", 3, 1);
        int expResult3 = 3;
        int result3 = instance3.getPriority();
        assertEquals(expResult3, result3);

        Task instance4 = new Task("teste4", "descrição 1", 4, 1);
        int expResult4 = 4;
        int result4 = instance4.getPriority();
        assertEquals(expResult4, result4);

        Task instance5 = new Task("teste5", "descrição 1", 5, 1);
        int expResult5 = 5;
        int result5 = instance5.getPriority();
        assertEquals(expResult5, result5);

        Task instance6 = new Task("teste6", "descrição 1", 1, 1);
        int expResult6 = 0;
        int result6 = instance6.getPriority();
        assertNotEquals(expResult6, result6);

    }

    /**
     * Test of getPercentage method, of class Task.
     */
    @Test
    public void testGetPercentage() {

        Task instance1 = new Task("teste1", "descrição 1", 1, 100);
        int expResult1 = 100;
        int result1 = instance1.getPercentage();
        assertEquals(expResult1, result1);

        Task instance2 = new Task("teste2", "descrição 1", 2, 0);
        int expResult2 = 0;
        int result2 = instance2.getPercentage();
        assertEquals(expResult2, result2);

        Task instance3 = new Task("teste3", "descrição 1", 3, 50);
        int expResult3 = 50;
        int result3 = instance3.getPercentage();
        assertEquals(expResult3, result3);

        Task instance4 = new Task("teste4", "descrição 1", 1, 100);
        int expResult4 = 0;
        int result4 = instance4.getPercentage();
        assertNotEquals(expResult4, result4);
    }

    /**
     * Test of toDTO method, of class Task.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");

        Task instance = new Task("teste1", "descrição 1", 1, 1);
        TaskDTO expResult = new TaskDTO("teste1", "descrição 1", 1, 1);
        TaskDTO result = instance.toDTO();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of fromDTO method, of class Task.
     */
    @Test
    public void testFromDTO() {
        System.out.println("fromDTO");
        TaskDTO dto = new TaskDTO("teste1", "descrição 1", 1, 1);
        Task expResult = new Task("teste1", "descrição 1", 1, 1);
        Task result = Task.fromDTO(dto);
        assertNotEquals(expResult, result);
    }

}
