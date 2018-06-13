package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import eapli.framework.domain.ValueObject;
import eapli.util.Strings;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import pt.isep.nsheets.shared.services.PasswordDTO;

/**
 *
 * @author Paulo Jorge
 */
@Embeddable
public class Password implements ValueObject, Serializable {

    private String password;

    protected Password() {
    }

    public Password(String password) {
        if (Strings.isNullOrEmpty(password)) {
           throw new IllegalArgumentException();
        }
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Password other = (Password) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Password{" + "password=" + password + '}';
    }

    public PasswordDTO toDTO() {
        return new PasswordDTO(password);
    }

    public static Password fromDTO(PasswordDTO dto) throws IllegalArgumentException {
        return new Password(dto.getPassword());
    }

}
