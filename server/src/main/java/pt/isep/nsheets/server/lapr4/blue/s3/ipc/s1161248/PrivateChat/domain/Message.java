package pt.isep.nsheets.server.lapr4.blue.s3.ipc.s1161248.PrivateChat.domain;

import pt.isep.nsheets.shared.services.MessageDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


public class Message implements Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;

    /*@ManyToOne()
    private User user;*/
    private String user;
    private String text;
    private Date date;

    // It is mandatory to have a default constructor with no arguments to be
    // serializable and for ORM!
    protected Message(){
    }

    public Message(String user, String text, Date date){
        if(user==null || text==null || date==null){
            throw new IllegalArgumentException();
        }
        this.user=user;
        this.text=text;
        this.date=date;
    }


    @Override
    public String toString() {
        return this.text + " at " + this.date.toString();
    }

    public MessageDTO toDTO() {
        return new MessageDTO(this.user, this.text, this.date);
    }

    public static Message fromDTO(MessageDTO dto) throws IllegalArgumentException {
        return new Message(dto.getUser(), dto.getText(), dto.getDate());
    }
}
