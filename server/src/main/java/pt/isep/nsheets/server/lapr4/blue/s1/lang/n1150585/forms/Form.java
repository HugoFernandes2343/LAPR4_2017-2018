/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s1.lang.n1150585.forms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dftsf
 */
public class Form {

    Map<String, String> form;

    public Form() {
        form = new HashMap<>();
    }
    public Form(Map<String, String> form) {
        this.form = form;
    }
    
    public Map<String, String> getForm() {
        return form;
    }

}
