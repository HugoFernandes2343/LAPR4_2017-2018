/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Paulo Jorge
 */
@Entity
public class Login {

    @Id
    @GeneratedValue
    private Long pk = null;

    private String email;
    private String password;

    public Login(String email, String password) throws IllegalArgumentException {
        if (email == null || password == null) {
            throw new IllegalArgumentException("email or password must be non-null");
        }
        this.email = email;
        this.password = password;
    }

    // It is mandatory to have a default constructor with no arguments to be
    // serializable and for ORM!
    protected Login() {
    }

    public String getName() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        if (this.email == null) {
            return super.toString();
        } else {
            return this.email + " " + this.password;
        }
    }

}
