/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
@Entity
public class Note implements Serializable  {

    @Id
    @GeneratedValue
    private Long pk;

    private User owner;
    
    public Note(){
        
    }

    public Note(User owner) throws IllegalArgumentException {
        if (owner == null){
             throw new NullPointerException(" Owner can't be null ");
        }
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }


}

