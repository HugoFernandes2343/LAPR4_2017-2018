/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author Paulo Jorge
 */
@SuppressWarnings("serial")
public class UserDTO implements Serializable {

    private String email;
    private String password;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public UserDTO() {
        this.email = "";
        this.password = "";
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
