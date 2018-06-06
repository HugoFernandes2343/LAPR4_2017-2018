package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import eapli.framework.domain.ValueObject;
import eapli.util.Strings;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

import pt.isep.nsheets.shared.services.EmailDTO;

/**
 * @author Paulo Jorge
 */
@Embeddable
public class Email implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;
    //  private static final Pattern VALID_NAME_REGEX = Pattern.compile("^[A-Z]+[a-zA-Z ]+$", Pattern.CASE_INSENSITIVE);
    private String email;

    protected Email() {
        this.email = "";
    }

    public Email(String email) {
        if (Strings.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("Email should neither be null nor empty");
        }

//        Matcher matcher = VALID_NAME_REGEX.matcher(email);
//        if (!matcher.find()) {
//            throw new IllegalArgumentException("Invalid Email: " + email);
//        }
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
