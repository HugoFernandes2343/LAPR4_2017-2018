package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.Date;

public class MessageDTO implements Serializable {

    private String user;
    private String text;
    private Date date;

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public MessageDTO() {
    }


    public MessageDTO(String user, String text, Date date) {
        this.user=user;
        this.text=text;
        this.date=date;
    }


    public String getText() {
        return this.text;
    }

    public Date getDate() {
        return this.date;
    }

    public String getUser(){ return this.user; }

}
