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
public class VersionDTO implements Serializable {

    private NoteDTO note;
    private String text;
    private Date date;

    public VersionDTO() {
    }

    public VersionDTO(NoteDTO note, String text) {
        this.note = note;
        this.text = text;
        this.date = new Date();
    }

    public NoteDTO getNote() {
        return note;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

}
