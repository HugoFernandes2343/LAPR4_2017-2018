package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.ArrayList;


public class ChatDTO implements Serializable {

    private String name;

    private ArrayList<MessageDTO> messages;

    private boolean accepted;

    public ChatDTO() {
        this.setMessages(new ArrayList<>());
        this.setName("<Sem Nome>");
    }

    public ChatDTO(String name, ArrayList<MessageDTO> messages, boolean accepted) {
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

    public ArrayList<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageDTO> messages) {
        this.messages = messages;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
