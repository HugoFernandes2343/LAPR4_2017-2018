/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.util.Calendar;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class NoteVersionDTO {
    
    
    private Calendar date;
    private String text;
    private NoteDTO note;
    

    public NoteVersionDTO(Calendar date,String text,NoteDTO note) {
       
        this.date = date;
        this.text = text;
        this.note = note;
    }

    public Calendar getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public NoteDTO getNote() {
        return note;
    }

    
}
