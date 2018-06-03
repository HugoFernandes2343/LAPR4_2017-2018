/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rodrigo
 */
public class VariableList {
    public Map<String, List<Variable>> variableList;

    public VariableList() {
        variableList = new HashMap<String, List<Variable>>();
    }

    public VariableList(Map<String, List<Variable>> variableList) {
        this.variableList = variableList;
    }
    
    
}
