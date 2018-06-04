

package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import eapli.framework.domain.ValueObject;
import eapli.util.Strings;
import java.io.Serializable;
import javax.persistence.Embeddable;
import pt.isep.nsheets.shared.services.NicknameDTO;

/**
 *
 * @author Paulo Jorge
 */
@Embeddable
public class Nickname implements ValueObject, Serializable {

    private String name;

    public Nickname(String username) {
        if (Strings.isNullOrEmpty(username)) {
            throw new IllegalArgumentException("username should neither be null nor empty");
        }
        // TODO validate other invariants, e.g., regular expression
        this.name = username;
    }

    protected Nickname() {
        // for ORM
        name = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Nickname)) {
            return false;
        }

        final Nickname other = (Nickname) o;
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public NicknameDTO toDTO() {
        return new NicknameDTO(name);
    }

    public static Nickname fromDTO(NicknameDTO dto) throws IllegalArgumentException {
        return new Nickname(dto.getNickName());
    }

}
