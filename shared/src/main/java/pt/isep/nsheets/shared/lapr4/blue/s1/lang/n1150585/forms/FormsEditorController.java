/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1150585.forms;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author dftsf
 */
public class FormsEditorController {

    Workbook currentWorkbook;

    public FormsEditorController(Workbook wb) {
        this.currentWorkbook = wb;
    }

    public boolean addForm(Map<String, String> form) {
        Form newForm = new Form(form);
        return currentWorkbook.insertNewForm(newForm);
    }

    public boolean existsForm() {
        return true;
       // return currentWorkbook.formExists();
    }

    public Map<String, String> getExistentForm() {
       /* Map <String,String> teste = new HashMap<>(); 
        teste.put("Isep0", "Linha0");
        teste.put("Isep1", "Linha1");
        teste.put("Isep2", "Linha2");
        teste.put("Isep3", "Linha3");
        teste.put("Isep4", "Linha4");
        teste.put("Isep5", "Linha5");
        return teste;*/
        
        Form returnedForm = currentWorkbook.getForm();
        Map<String, String> rows = returnedForm.getRows();
        return rows;
    }
}
