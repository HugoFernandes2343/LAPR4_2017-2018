package pt.isep.nsheets.shared.core.formula.lapr4.red.s3.s1161110.globalVariables;

import java.util.Objects;
import pt.isep.nsheets.shared.core.Value;

/**
 * @author David Maia
 */
public class GlobalVariable {

    private String name;
    private Value value;

    public GlobalVariable(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
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
        final GlobalVariable other = (GlobalVariable) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
