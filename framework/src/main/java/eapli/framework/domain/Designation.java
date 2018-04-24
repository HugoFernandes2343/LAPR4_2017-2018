/**
 *
 */
package eapli.framework.domain;

import eapli.util.Strings;
import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Generic name concept
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@Embeddable
public class Designation implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;
    private String designation;

    public Designation(String name) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalStateException("Name should neither be null nor empty");
        }
        this.designation = name;
    }

    protected Designation() {
        // for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Designation)) {
            return false;
        }

        final Designation other = (Designation) o;

        return this.designation.equals(other.designation);
    }

    @Override
    public String toString() {
        return this.designation;
    }

    @Override
    public int hashCode() {
        return this.designation.hashCode();
    }
}
