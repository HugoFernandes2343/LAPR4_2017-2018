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
    private String name;
    private String nickname;
    private boolean activate;
    private UserType userType;

    public UserDTO(String email, String password, String name, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.activate = true;
        this.userType = UserType.USER;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public UserDTO() {
        this.email = "";
        this.password = "";
        this.name = "";
        this.nickname = "";
        this.activate = true;
        this.userType = UserType.USER;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isActivate() {
        return activate;
    }

}
