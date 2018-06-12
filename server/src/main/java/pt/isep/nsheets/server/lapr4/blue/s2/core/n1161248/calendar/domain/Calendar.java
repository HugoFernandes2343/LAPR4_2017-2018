package pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.domain;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain.Event;
import pt.isep.nsheets.shared.services.CalendarDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Calendar implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = false)
    private String name;
    private String description;
    @ManyToOne
    private User user;


    public Calendar(String name, String description, User user) {
        this.setName(name);
        this.setDescription(description);
        this.setUser(user);
    }

    public Calendar() {
        this.user = null;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CalendarDTO toDTO() {
        return new CalendarDTO(this.name, this.description, this.user.toDTO());
    }

    public static Calendar fromDTO(CalendarDTO calendarDTO) {
        return new Calendar(calendarDTO.getName(), calendarDTO.getDescription(), User.fromDTO(calendarDTO.getUser()));
    }
}
