/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rodrigo
 * 
 * VariableList is now Serializable - João Vieira - 1150575
 */
public class VariableList implements Serializable {
    public Map<String, Variable> variableList;

    public VariableList() {
        variableList = new HashMap<String, Variable>();
    }

    public VariableList(Map<String, Variable> variableList) {
        this.variableList = variableList;
    }
    
    public void addVariable(Variable v){
        variableList.put (v.getName(), v);
    }
    
    public boolean contains (String name){
        return variableList.containsKey(name);
    }
    
    public Variable get (String name){
        return variableList.get(name);
    }
}
