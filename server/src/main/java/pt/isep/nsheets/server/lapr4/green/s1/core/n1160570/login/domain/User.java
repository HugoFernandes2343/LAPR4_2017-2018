/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
@Entity
public class User implements AggregateRoot<Email>, Serializable {

    @EmbeddedId
    private Email email;
    private String password;
    private Nickname nickname;
    private Name name;
    private boolean activate;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(Email email, String password, Nickname nickname, Name name) throws IllegalArgumentException {
        if (email == null || password == null || nickname == null || name == null) {
            throw new IllegalArgumentException("email or password or nickname or name must be non-null");
        }
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.activate = true;
        this.userType = UserType.USER;

    }

    // It is mandatory to have a default constructor with no arguments to be
    // serializable and for ORM!
    protected User() {
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        if (this.email == null) {
            return super.toString();
        } else {
            return this.email + " " + this.password + " " + this.nickname + " " + this.name;
        }
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof User)) {
            return false;
        }

        final User that = (User) other;
        if (this == that) {
            return true;
        }
        if (!this.email.equals(that.email)) {
            return false;
        }
        if (!this.nickname.equals(that.nickname)) {
            return false;
        }
        if (!this.name.equals(that.name)) {
            return false;
        }
        if (this.activate != that.activate) {
            return false;
        }
        return this.password.equals(that.password);
    }

    @Override
    public boolean is(Email email) {
        return (this.email.equals(this.email));
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public Email id() {
        return this.email;
    }

    public UserDTO toDTO() {
        return new UserDTO(email.toDTO(), password, name.toDTO(), nickname.toDTO());
    }

    public static User fromDTO(UserDTO dto) throws IllegalArgumentException {
        return new User(Email.fromDTO(dto.getEmail()), dto.getPassword(), Nickname.fromDTO(dto.getNickname()), Name.fromDTO(dto.getName()));
    }

}
