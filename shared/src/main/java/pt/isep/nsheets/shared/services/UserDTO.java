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

    private EmailDTO email;
    private String password;
    private NameDTO name;
    private NicknameDTO nickname;
    private boolean activate;
    private UserTypeDTO userType;

    public UserDTO(EmailDTO email, String password, NameDTO name, NicknameDTO nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.activate = true;
        this.userType = UserTypeDTO.USER;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public UserDTO() {
        this.activate = true;
        this.userType = UserTypeDTO.USER;
    }

    public UserTypeDTO getUserType() {
        return userType;
    }

    public EmailDTO getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public NameDTO getName() {
        return name;
    }

    public NicknameDTO getNickname() {
        return nickname;
    }

    public boolean isActivate() {
        return activate;
    }

}
