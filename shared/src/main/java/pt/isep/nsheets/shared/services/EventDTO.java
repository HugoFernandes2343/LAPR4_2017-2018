package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;
import java.util.Date;

public class EventDTO implements IsSerializable, Serializable, Comparable<EventDTO> {


    private Long pk;

    private String title;

    private String description;

    private String madeBy;

    private String timestamp;

    private String duration;

    protected EventDTO() {

    }

    /**
     * Complete constructor
     */
    public EventDTO(String title, String description, String madeBy, String timestamp, String duration) {
        this.setTitle(title);
        this.setDescription(description);
        this.setMadeBy(madeBy);
        this.setTimestamp(timestamp);
        this.setDuration(duration);
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
    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    /**
     * Timestamp of the event
     */
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Duration of the event
     */
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return timestamp;
    }

    public void setDate(String timestamp) {
        this.timestamp = timestamp;
    }

    public static EventDTO fromEvent(EventDTO event) throws IllegalArgumentException {
        return new EventDTO(event.getTitle(), event.getDescription(), event.getMadeBy(), event.getDate(), event.getDuration());
    }


    @Override
    public int compareTo(EventDTO o) {
        return (this.getTitle().compareTo(o.getTitle()));
    }

}

