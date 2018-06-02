/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
@Entity
public class User implements AggregateRoot<Long>, Serializable {

    @Id
    @GeneratedValue
    private Long pk;

    public enum UserType {

        USER {

            @Override
            public String toString() {
                return "User";
            }
        },
        ADMIN {

            @Override
            public String toString() {
                return "Admin";
            }
        }
    };

    private String email;
    private String password;
    private String nickname;
    private String name;
    private boolean activate;
    private UserType userType;

    public User(String email, String password, String nickname, String name) throws IllegalArgumentException {
        if (email == null || password == null || nickname == null || name == null) {
            throw new IllegalArgumentException("email or password must be non-null");
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
    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Long id() {
        return this.pk;
    }

    public UserDTO toDTO() {
        return new UserDTO(this.email, this.password, this.name, this.nickname);
    }

    public static User fromDTO(UserDTO dto) throws IllegalArgumentException {
        return new User(dto.getEmail(), dto.getPassword(), dto.getName(), dto.getNickname());
    }

}
