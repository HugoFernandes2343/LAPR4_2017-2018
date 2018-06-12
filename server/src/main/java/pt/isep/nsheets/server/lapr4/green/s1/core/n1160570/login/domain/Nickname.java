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

    private String nickname;

    public Nickname(String username) {
        if (Strings.isNullOrEmpty(username)) {
//            throw new IllegalArgumentException("username should neither be null nor empty");
        }
        // TODO validate other invariants, e.g., regular expression
        this.nickname = username;
    }

    protected Nickname() {
        // for ORM
        nickname = null;
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
        return this.nickname.equals(other.nickname);
    }

    @Override
    public String toString() {
        return this.nickname;
    }

    @Override
    public int hashCode() {
        return this.nickname.hashCode();
    }

    public NicknameDTO toDTO() {
        return new NicknameDTO(nickname);
    }

    public static Nickname fromDTO(NicknameDTO dto) throws IllegalArgumentException {
        return new Nickname(dto.getNickName());
    }

}
