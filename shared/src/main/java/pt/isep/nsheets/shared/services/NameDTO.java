package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NameDTO implements Serializable {

    private String firstName;
    private String lastName;

    public NameDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public NameDTO() {
        this.firstName = "";
        this.lastName = "";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
