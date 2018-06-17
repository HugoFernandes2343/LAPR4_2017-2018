package pt.isep.nsheets.server.lapr4.blue.s3.ipc.s1161248.PrivateChat.domain;

import eapli.framework.domain.AggregateRoot;
import org.eclipse.persistence.annotations.PrimaryKey;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.shared.services.ChatDTO;
import pt.isep.nsheets.shared.services.MessageDTO;
import pt.isep.nsheets.shared.services.UserDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chat implements AggregateRoot<Long>, Serializable {


    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;

    private String name;

    @ElementCollection
    private List<Message> messages;

    private boolean accepted;

    public Chat() {
        this.setMessages(new ArrayList<>());
        this.setName("<Sem Nome>");

    }

    public Chat(String name, ArrayList<Message> messages, boolean accepted) {
        this.setName(name);
        this.setMessages(messages);
        this.setAccepted(accepted);
    }


    public ChatDTO toDTO() {
        ArrayList<MessageDTO> mList = new ArrayList<>();
        for (Message m : this.getMessages()){
            mList.add(m.toDTO());
        }
        return new ChatDTO(this.getName(), mList, this.isAccepted());
    }

    public static Chat fromDTO(ChatDTO dto) throws IllegalArgumentException {
        ArrayList<Message> mList = new ArrayList<>();
        for (MessageDTO mDTO : dto.getMessages()){
            mList.add(Message.fromDTO(mDTO));
        }
        return new Chat(dto.getName(), mList, dto.isAccepted());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }


    @Override
    public boolean equals(Object object){
        if(!object.getClass().equals(this.getClass())){
            return false;
        }
        Chat o = (Chat) object;
        if(this.getName().equals(o.getName())){
            return true;
        }
        return false;
    }

    @Override
    public boolean sameAs(Object other) {
        Chat message=(Chat) other;
        if(!((Chat) other).name.equals(this.name)){
            return false;
        }
        if(!((Chat) other).messages.equals(this.messages)){
            return false;
        }
        if(!((Chat) other).accepted == this.accepted){
            return false;
        }
        return is(message.pk);
    }

    @Override
    public boolean is(Long id) {
        return false;
    }

    @Override
    public Long id() {
        return null;
    }
}
