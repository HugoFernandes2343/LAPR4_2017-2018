/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1150585.forms;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.MapUtils;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author dftsf
 */
public class Form {

    Map<String, String> rows;

    public Form() {
        rows = new HashMap<>();
    }

    public Form(Map<String, String> form) {
        this.rows = form;

    }

    public Map<String, String> getRows() {
        return rows;
    }

    public boolean isEmpty() {
        if (rows.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
