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
    Form form;
    
    public FormsEditorController(Workbook wb) {
        this.currentWorkbook = wb;
        this.form = new Form();
    }
    
    public void addForm(Map<String, String> form) {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    public boolean existsForm() { //Verifica se a form existe
        return true;
    }
    

    public Map<String, String> getExistentForm() {
        Map<String, String> test = new HashMap<>();
        
        test.put("Daniel", "Daniel123");
        test.put("Carlos", "Carlos123");
        test.put("Zé", "Zé123");
        test.put("João", "João123");
        
        return test;
       
    }
}
