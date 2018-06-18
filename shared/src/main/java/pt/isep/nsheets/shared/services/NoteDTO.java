/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Paulo Jorge
 */
@SuppressWarnings("serial")
public class NoteDTO implements Serializable {

    private UserDTO user;
    private String title;
    private String text;
    private Date date;

    public NoteDTO(UserDTO user, String title, String text) {
        this.user = user;
        this.title = title;
        this.text = text;
        date = new Date();
    }

    public NoteDTO() {
    }

    public UserDTO getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

}
