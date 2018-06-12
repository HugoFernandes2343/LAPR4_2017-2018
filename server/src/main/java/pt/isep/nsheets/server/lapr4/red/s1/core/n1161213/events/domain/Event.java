package pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain;

import com.google.inject.Inject;
import eapli.framework.domain.AggregateRoot;
import gwt.material.design.client.data.HasDataCategory;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Event implements AggregateRoot<Long>, Serializable, HasDataCategory {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;

    private String title;

    private String description;

    @ManyToOne()
    private User madeBy;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date timestamp;

    @Embedded
    private Duration duration;

    /**
     * Constructor for ORM
     */
    protected Event() {

    }

    /**
     * Complete constructor
     */
    public Event(String title, String description, User madeBy, Date timestamp, Duration duration) {
        if (title == null || description == null | madeBy == null || timestamp == null || duration == null) {
            throw new IllegalArgumentException("Error in the input data");
        }

        this.setTitle(title);
        this.setDescription(description);
        this.setMadeBy(madeBy);
        this.setTimestamp(timestamp);
        this.setDuration(duration);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Event)) {
            return false;
        }

        Event e = (Event) other;
        return this.getTimestamp().compareTo(e.getTimestamp()) == 0;
    }

    @Override
    public boolean is(Long id) {
        return this.pk.equals(id);
    }

    @Override
    public Long id() {
        return this.pk;
    }

    public Date whenIs() {
        return this.getTimestamp();
    }

    public Event toEvent() {
        return new Event(this.getTitle(), this.getDescription(), this.getMadeBy(), this.getTimestamp(), this.getDuration());
    }

    /**
     * Title of the event.
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Description of the event
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * User who creates this event
     */
    public User getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(User madeBy) {
        this.madeBy = madeBy;
    }

    /**
     * Timestamp of the event
     */
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Duration of the event
     */
    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return timestamp;
    }

    public void setDate(Date timestamp) {
        this.timestamp = timestamp;
    }

    public static Event fromEvent(Event event) throws IllegalArgumentException {
        return new Event(event.getTitle(), event.getDescription(), event.getMadeBy(), event.getDate(), event.getDuration());
    }

    @Override
    public String getDataCategory() {
        return null;
    }
}
