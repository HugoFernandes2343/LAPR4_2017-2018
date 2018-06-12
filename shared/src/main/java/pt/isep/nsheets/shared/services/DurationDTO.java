package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class DurationDTO implements IsSerializable, Serializable {

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
    public DurationDTO(){

    }

    /**
     * Complete constructor. The time in this is saved with the following format: from 100(1h00) to 2400(24h00)
     */
    public DurationDTO(Integer from, Integer to){
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
