/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import pt.isep.nsheets.server.lapr4.blue.s3.ipc.s1161248.PrivateChat.domain.Chat;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain.Request;
import pt.isep.nsheets.shared.services.ChatDTO;
import javax.persistence.*;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UserTypeDTO;

/**
 *
 * @author Paulo Jorge
 */
@Entity
public class User implements AggregateRoot<Email>, Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private Email email;
    private Password password;
    private Nickname nickname;
    private Name name;
    private boolean activate;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @ElementCollection
    private List<Chat> chatList;

    public User(Email email, Password password, Nickname nickname, Name name) throws IllegalArgumentException {
        if (email == null || password == null || nickname == null || name == null) {
            throw new IllegalArgumentException("email or password or nickname or name must be non-null");
        }
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.activate = true;
        this.userType = UserType.USER;
        this.chatList = new ArrayList<>();
    }
    
    public User(Email email, Password password, Nickname nickname, Name name, String admin) throws IllegalArgumentException {
        if (email == null || password == null || nickname == null || name == null) {
            throw new IllegalArgumentException("email or password or nickname or name must be non-null");
        }
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.activate = true;
        this.userType = UserType.ADMIN;

    }


    public User(Email email, Password password, Nickname nickname, Name name, List<Chat> chatList) throws IllegalArgumentException {
        if (email == null || password == null || nickname == null || name == null) {
            throw new IllegalArgumentException("email or password or nickname or name must be non-null");
        }
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.activate = true;
        this.userType = UserType.USER;
        this.chatList = chatList;
    }
    // It is mandatory to have a default constructor with no arguments to be
    // serializable and for ORM!
    protected User() {
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        if (this.email == null) {
            return super.toString();
        } else {
            return this.email + " " + this.password + " " + this.nickname + " " + this.name;
        }
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof User)) {
            return false;
        }

        final User that = (User) other;
        if (this == that) {
            return true;
        }
        if (!this.email.equals(that.email)) {
            return false;
        }
        if (!this.nickname.equals(that.nickname)) {
            return false;
        }
        if (!this.name.equals(that.name)) {
            return false;
        }
        if (this.activate != that.activate) {
            return false;
        }
        return this.password.equals(that.password);
    }

    @Override
    public boolean is(Email email) {
        return (this.email.equals(this.email));
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public Email id() {
        return this.email;
    }

    public UserDTO toDTO() {
        List<ChatDTO> chatListDTO = new ArrayList<>();
        for(Chat chat: this.chatList){
            chatListDTO.add(chat.toDTO());
        }
        return new UserDTO(email.toDTO(), password.toDTO(), name.toDTO(), nickname.toDTO(), chatListDTO);
    }
    
    public UserDTO toDTOAdmin(UserTypeDTO usertype){
        return new UserDTO(email.toDTO(), password.toDTO(), name.toDTO(), nickname.toDTO(), usertype);
    }
    
    public UserType getUserType() {
        return userType;
    }

    public Nickname getNickname() {
        return nickname;
    }

    public Name getName() {
        return name;
    }

    public List<Chat> getChatList(){return chatList;}

    public void addChat(Chat chat){ this.chatList.add(chat);}

    public static User fromDTO(UserDTO dto) throws IllegalArgumentException {
        List<Chat> chatList = new ArrayList<>();
        for(ChatDTO chat: dto.getChatList()){
            chatList.add(Chat.fromDTO(chat));
        }
        return new User(Email.fromDTO(dto.getEmail()), Password.fromDTO(dto.getPassword()), Nickname.fromDTO(dto.getNickname()), Name.fromDTO(dto.getName()), chatList);
    }
    
    public static User fromDTOAdmin(UserDTO dto, String admin) throws IllegalArgumentException {
        return new User(Email.fromDTO(dto.getEmail()), Password.fromDTO(dto.getPassword()), Nickname.fromDTO(dto.getNickname()), Name.fromDTO(dto.getName()), admin);
    }
    
    public void deactivate(){
        this.activate=false;
    }
    
    public void activate(){
        this.activate=true;
    }

}
