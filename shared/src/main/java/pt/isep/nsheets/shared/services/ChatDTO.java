package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ChatDTO implements Serializable {

    private String name;

    private List<MessageDTO> messages;

    private boolean accepted;

    public ChatDTO() {
        this.setMessages(new ArrayList<>());
        this.setName("<Sem Nome>");
    }

    public ChatDTO(String name, List<MessageDTO> messages, boolean accepted) {
        this.setName(name);
        this.setMessages(messages);
        this.setAccepted(accepted);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o){
        if(!this.getClass().equals(o.getClass())){
            return false;
        }
        ChatDTO outro = (ChatDTO) o;
        if(this.getName().equals(outro.getName())){
            return true;
        }
        return false;
    }
}
