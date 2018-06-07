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
     * Protected constructor for ORM
     */
    protected Duration(){

    }

    /**
     * Complete constructor. The time in this is saved with the following format: from 100(1h00) to 2400(24h00)
     */
    public Duration(Integer from, Integer to){
        if(from == null || to == null){
            throw new IllegalArgumentException("Error in the input data");
        }

        if(from.compareTo(0) < 0 || to.compareTo(2359) > 0){
            throw new IllegalArgumentException("Hora inválida!");
        }

        this.from = from;
        this.to = to;
    }

    public boolean isAllDay(){
        if(this.from==0 && this.to==2359){
            return true;
        }else{
            return false;
        }
    }
}
