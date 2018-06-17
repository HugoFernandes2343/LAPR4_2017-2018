/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lapr4.red.s3.s1161110.globalVariables;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David Maia
 *
 */
public class GlobalVariableList implements Serializable {
    public Map<String, GlobalVariable> globalvariableList;

    public GlobalVariableList() {
        globalvariableList = new HashMap<String, GlobalVariable>();
    }

    public GlobalVariableList(Map<String, GlobalVariable> variableList) {
        this.globalvariableList = variableList;
    }
    
    public void addVariable(GlobalVariable v){
        if (!globalvariableList.containsValue(v)) {
            globalvariableList.put(v.getName(), v);
        }
    }
    
    public boolean contains (String name){
        return globalvariableList.containsKey(name);
    }
    
    public GlobalVariable get (String name){
        return globalvariableList.get(name);
    }
}
