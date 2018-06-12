package pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161569.domain;

import eapli.framework.domain.AggregateRoot;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.shared.services.MessageDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Message implements AggregateRoot<Long>, Serializable {

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
    public boolean sameAs(Object other) {
        Message message=(Message) other;
        if(!((Message) other).date.equals(this.date)){
            return false;
        }
        if(!((Message) other).text.equals(this.text)){
            return false;
        }
        if(!((Message) other).user.equals(this.user)){
            return false;
        }
        return is(message.pk);
    }

    @Override
    public boolean is(Long id) {
        return this.pk.equals(id);
    }

    @Override
    public Long id() {
        return this.pk;
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
