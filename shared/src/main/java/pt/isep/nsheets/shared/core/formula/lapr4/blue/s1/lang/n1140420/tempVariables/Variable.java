/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables;

import java.util.Objects;
import pt.isep.nsheets.shared.core.Value;

/**
 *
 * @author Rodrigo
 */
public class Variable {
    private String name;
    private Value value;

    public Variable(String name, Value value) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * return true if the object is equal to this variable
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Variable other = (Variable) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
