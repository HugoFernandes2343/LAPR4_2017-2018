package pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain;

import eapli.framework.domain.ValueObject;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Duration implements ValueObject, Serializable {

    /**
     * Starting time of the event.
     */
    private Integer from;

    /**
     * Ending time of the event.
     */
    private Integer to;

    /**
     * Indicates if the event is a full day.
     */
    private boolean isAllDay = false;

    /**
     * Protected constructor for ORM
     */
    protected Duration(){

    }

    /**
     * Complete constructor. The time in this is saved with the following format: from 100(1h00) to 2400(24h00)
     */
    public Duration(Integer from, Integer to, boolean isAllDay){
        if(from == null || to == null){
            throw new IllegalArgumentException("Error in the input data");
        }

        if(from.compareTo(100) < 0 || to.compareTo(2400) > 0){
            throw new IllegalArgumentException();
        }

        this.from = from;
        this.to = to;
        this.isAllDay = isAllDay;
    }
}