package pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain;

import eapli.framework.domain.AggregateRoot;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Event implements AggregateRoot<Long>, Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;

    /**
     * Title of the event.
     */
    private String title;

    /**
     * Description of the event
     */
    private String description;

    /**
     * User who creates this event
     */
    @ManyToOne()
    private User madeBy;

    /**
     * Timestamp of the event
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date timestamp;

    /**
     * Duration of the event
     */
    @Embedded
    private Duration duration;

    /**
     * Constructor for ORM
     */
    protected Event(){

    }
    /**
     * Complete constructor
     */
    public Event(String title, String description, User madeBy, Date timestamp, Duration duration){
        if(title == null || description == null | madeBy == null || timestamp == null || duration == null) {
            throw new IllegalArgumentException("Error in the input data");
        }

        this.title = title;
        this.description = description;
        this.madeBy = madeBy;
        this.timestamp = timestamp;
        this.duration = duration;
    }

    @Override
    public boolean sameAs(Object other) {
        if(!(other instanceof Event)){
            return false;
        }

        Event e = (Event) other;
        return this.timestamp.compareTo(e.timestamp) == 0;
    }

    @Override
    public boolean is(Long id) {
        return this.pk.equals(id);
    }

    @Override
    public Long id() {
        return this.pk;
    }

    public Date whenIs(){
        return this.timestamp;
    }
}
