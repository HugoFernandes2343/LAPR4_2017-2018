package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CalendarDTO implements Serializable{
    private String name;
    private String description;
    private UserDTO user;


    public CalendarDTO() {

    }

    public CalendarDTO(String name, String description, UserDTO user){
        this.setName(name);
        this.setDescription(description);
        this.setUser(user);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
