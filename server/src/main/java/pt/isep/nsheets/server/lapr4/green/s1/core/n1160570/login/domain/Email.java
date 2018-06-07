package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import eapli.framework.domain.ValueObject;
import eapli.util.Strings;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import javax.persistence.Embeddable;

import pt.isep.nsheets.shared.services.EmailDTO;

/**
 * @author Paulo Jorge
 */
@Embeddable
public class Email implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;
    Pattern pattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}");
    private String email;

    protected Email() {
        this.email = "";
    }

    public Email(String email) {
        
        Matcher m = pattern.matcher(email);
        
        if (m.matches()) {
            throw new IllegalArgumentException("Email not introduced correctly");
        }

        this.email = email;
    }

    @Override
    public String toString() {
        return "Email: " + email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.email);
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
        final Email other = (Email) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    public EmailDTO toDTO() {
        return new EmailDTO(email);
    }

    public static Email fromDTO(EmailDTO dto) throws IllegalArgumentException {
        return new Email(dto.getEmail());
    }
}
