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
public class NoteDTO implements Serializable {

    private UserDTO user;
    private String title;

    public NoteDTO(UserDTO user, String title) {
        this.user = user;
        this.title = title;
    }

    public NoteDTO() {
    }

    public UserDTO getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

}
