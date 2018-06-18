package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import eapli.framework.domain.ValueObject;
import eapli.util.Strings;
import java.io.Serializable;
import javax.persistence.Embeddable;
import pt.isep.nsheets.shared.services.NameDTO;

/**
 *
 * @author Paulo Jorge
 */
@Embeddable
public class Name implements ValueObject, Serializable {

    //public static final Pattern VALID_NAME_REGEX = Pattern.compile("^[A-Z]+[a-zA-Z ]+$", Pattern.CASE_INSENSITIVE);
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        if (Strings.isNullOrEmpty(firstName) || Strings.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("First name and last name should neither be null nor empty");
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Name() {
        // for ORM only
        firstName = lastName = null;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }

        final Name name = (Name) o;

        if (!firstName.equals(name.firstName)) {
            return false;
        }
        return lastName.equals(name.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public NameDTO toDTO() {
        return new NameDTO(firstName, lastName);
    }

    public static Name fromDTO(NameDTO dto) throws IllegalArgumentException {
        return new Name(dto.getFirstName(), dto.getLastName());
    }
}
