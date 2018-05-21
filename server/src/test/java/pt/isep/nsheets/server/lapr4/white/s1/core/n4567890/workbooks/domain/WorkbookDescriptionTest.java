package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class WorkbookDescriptionTest {

   public WorkbookDescriptionTest() {
   }

   @BeforeClass
   public static void setUpClass() {
       System.out.println("WorkbookDescription");
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

   @Test(expected = IllegalArgumentException.class)
   public void ensureNullIsNotAllowed() {
       System.out.println("ensureNullIsNotAllowed");
       WorkbookDescription instance = new WorkbookDescription(null, null);
   }
}