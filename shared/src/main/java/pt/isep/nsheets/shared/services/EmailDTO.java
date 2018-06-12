package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author Paulo Jorge
 */
@SuppressWarnings("serial")
public class EmailDTO implements Serializable {

    private final String email;

    public EmailDTO(String email) {
        this.email = email;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public EmailDTO() {
        this.email = "";
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "EmailDTO{" + "email=" + email + '}';
    }

}
