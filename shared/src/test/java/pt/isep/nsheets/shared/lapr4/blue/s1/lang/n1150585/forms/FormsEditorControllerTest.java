/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1150585.forms;

import com.google.gwt.thirdparty.guava.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author dftsf
 */
public class FormsEditorControllerTest {

    @Test
    public void testAddForm() {
        Workbook wb = new Workbook("Teste1", "Teste2","");
        Map<String, String> teste = new HashMap<>();
        teste.put("Isep0", "Linha0");
        teste.put("Isep1", "Linha1");
        teste.put("Isep2", "Linha2");
        teste.put("Isep3", "Linha3");
        teste.put("Isep4", "Linha4");
        teste.put("Isep5", "Linha5");

        Workbook wb2 = new Workbook("Teste1", "Teste2","");
        Map<String, String> teste2 = new HashMap<>();
        teste2.put("Linha1", "Linha0");
        teste2.put("Linha2", "Linha1");
        teste2.put("Linha3", "Linha2");
        teste2.put("Linha4", "Linha3");
        teste2.put("Linha5", "Linha4");

        System.out.println("addForm");
        FormsEditorController instance = new FormsEditorController(wb);
        boolean expResult = true;
        boolean result = instance.addForm(teste);
        assertEquals(expResult, result);

        FormsEditorController instance2 = new FormsEditorController(wb2);
        boolean expResult2 = true;
        boolean result2 = instance.addForm(teste2);

    }

    /**
     * Test of existsForm method, of class FormsEditorController.
     */
    @Test
    public void testExistsForm() {
        Workbook wb = new Workbook("Teste1", "Teste2","");
        Map<String, String> teste = new HashMap<>();
        teste.put("Isep0", "Linha0");
        teste.put("Isep1", "Linha1");
        teste.put("Isep2", "Linha2");
        teste.put("Isep3", "Linha3");
        teste.put("Isep4", "Linha4");
        teste.put("Isep5", "Linha5");
        Form form = new Form(teste);
        wb.insertNewForm(form);

        Workbook wb2 = new Workbook("Teste1", "Teste2","");
        Map<String, String> teste2 = new HashMap<>();
        teste2.put("Linha1", "Linha0");
        teste2.put("Linha2", "Linha1");
        teste2.put("Linha3", "Linha2");
        teste2.put("Linha4", "Linha3");
        teste2.put("Linha5", "Linha4");
        Form form2 = new Form(teste2);
        wb2.insertNewForm(form2);

        Workbook wb3 = new Workbook("Teste1", "Teste2","");
        Workbook wb4 = new Workbook("Teste1", "Teste2","");

        System.out.println("existsForm");

        FormsEditorController instance = new FormsEditorController(wb);
        boolean expResult = true;
        boolean result = instance.existsForm();
        assertEquals(expResult, result);

        FormsEditorController instance2 = new FormsEditorController(wb2);
        boolean expResult2 = true;
        boolean result2 = instance2.existsForm();
        assertEquals(expResult2, result2);

        FormsEditorController instance3 = new FormsEditorController(wb3);
        boolean expResult3 = true;
        boolean result3 = instance3.existsForm();
        assertEquals(expResult3, result3);

        FormsEditorController instance4 = new FormsEditorController(wb4);
        boolean expResult4 = true;
        boolean result4 = instance4.existsForm();
        assertEquals(expResult4, result4);

    }

    /**
     * Test of getExistentForm method, of class FormsEditorController.
     */
    @Test
    public void testGetExistentForm() {
        Workbook wb = new Workbook("Teste1", "Teste2","");
        Map<String, String> teste = new HashMap<>();
        teste.put("Isep0", "Linha0");
        teste.put("Isep1", "Linha1");
        teste.put("Isep2", "Linha2");
        teste.put("Isep3", "Linha3");
        teste.put("Isep4", "Linha4");
        teste.put("Isep5", "Linha5");
        Form form = new Form(teste);
        wb.insertNewForm(form);

        Workbook wb2 = new Workbook("Teste1", "Teste2","");
        Map<String, String> teste2 = new HashMap<>();
        teste2.put("Linha1", "Linha0");
        teste2.put("Linha2", "Linha1");
        teste2.put("Linha3", "Linha2");
        teste2.put("Linha4", "Linha3");
        teste2.put("Linha5", "Linha4");
        Form form2 = new Form(teste2);
        wb2.insertNewForm(form2);

        System.out.println("getExistentForm");
        FormsEditorController instance = new FormsEditorController(wb);
        Map<String, String> expResult = new HashMap<>();
        expResult.put("Isep0", "Linha0");
        expResult.put("Isep1", "Linha1");
        expResult.put("Isep2", "Linha2");
        expResult.put("Isep3", "Linha3");
        expResult.put("Isep4", "Linha4");
        expResult.put("Isep5", "Linha5");
        Map<String, String> result = instance.getExistentForm();
        assertEquals(expResult, result);

        FormsEditorController instance2 = new FormsEditorController(wb2);
        Map<String, String> expResult2 = new HashMap<>();
        expResult2.put("Linha1", "Linha0");
        expResult2.put("Linha2", "Linha1");
        expResult2.put("Linha3", "Linha2");
        expResult2.put("Linha4", "Linha3");
        expResult2.put("Linha5", "Linha4");
        Map<String, String> result2 = instance2.getExistentForm();
        assertEquals(expResult2, result2);

    }

}
