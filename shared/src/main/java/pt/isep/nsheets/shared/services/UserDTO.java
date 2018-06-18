/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Paulo Jorge
 */
@SuppressWarnings("serial")
public class UserDTO implements Serializable {

    private EmailDTO email;
    private PasswordDTO password;
    private NameDTO name;
    private NicknameDTO nickname;
    private boolean activate;
    private UserTypeDTO userType;
    private List<ChatDTO> chatList;

    public UserDTO(EmailDTO email, PasswordDTO password, NameDTO name, NicknameDTO nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.activate = true;
        this.userType = UserTypeDTO.USER;
        this.chatList = new ArrayList<>();
    }

    public UserDTO(EmailDTO email, PasswordDTO password, NameDTO name, NicknameDTO nickname, UserTypeDTO usertype) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.activate = true;
        this.userType = UserTypeDTO.ADMIN;
    }

    public UserDTO(EmailDTO email, PasswordDTO password, NameDTO name, NicknameDTO nickname, List<ChatDTO> chatListDTO) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.activate = true;
        this.userType = UserTypeDTO.USER;
        this.chatList = chatListDTO;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public UserDTO() {
        this.activate = true;
        this.userType = UserTypeDTO.USER;
        this.chatList = new ArrayList<>();
    }

    public UserTypeDTO getUserType() {
        return userType;
    }

    public EmailDTO getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return nickname.getNickName();
    }

    public PasswordDTO getPassword() {
        return this.password;
    }

    public NameDTO getName() {
        return name;
    }

    public NicknameDTO getNickname() {
        return nickname;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setName(String fistname, String lastname) {
        this.name.setFirstName(fistname);
        this.name.setLastName(lastname);
    }

    public void setNickname(String nickname) {
        this.nickname.setNickName(nickname);
    }

    public void setUserType(UserTypeDTO userType) {
        this.userType = userType;
    }
    
    public void deactivateUser(){
        this.activate = false;
    }
    
    public void activateUser(){
        this.activate=true;
    }

    public List<ChatDTO> getChatList() {
        return this.chatList;
    }

    public void addChat(ChatDTO chat){ this.chatList.add(chat);}

    public void setChatList(List<ChatDTO> chatList){ this.chatList = chatList;}

    public ChatDTO getChatByName(String name){
        for(ChatDTO chat : this.getChatList()){
            if(chat.getName().equals(name)){
                return chat;
            }
        }
        return null;
    }
}
