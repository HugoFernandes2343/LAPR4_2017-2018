/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.domain.Note;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class NoteVersion implements Serializable {
    
    @Id
    @GeneratedValue
    private Long pk;

    
    private Note note;
    
    private String title;
    private Calendar date;
    private String text;
    
    public NoteVersion(String title,Calendar date,String text,Note note){
        
        if(title==null || date == null || text==null || note==null){
             throw new NullPointerException("Null values can't be processed");
        }
        if (title.length()>200){
             throw new IllegalArgumentException("Title is too long");
        }
        
        
        this.title=title;
        this.date=date;
        this.text=text;
        this.note=note;
        
    }
    
    
    public Note getNote(){
        return note;
    }
    
    
    public String getTitle() {
        return title;
    }

    public Calendar getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
    
    
}
