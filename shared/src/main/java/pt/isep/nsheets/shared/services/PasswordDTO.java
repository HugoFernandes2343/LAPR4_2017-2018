package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author Paulo Jorge
 */
@SuppressWarnings("serial")
public class PasswordDTO implements Serializable {

    private String password;

    public PasswordDTO(String password) {
        this.password = password;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public PasswordDTO() {
        this.password = "";
    }

    public String getPassword() {
        return this.password;
    }
}
