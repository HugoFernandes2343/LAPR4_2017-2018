/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class NoteDTO implements Serializable{
   
   private UserDTO owner;
    

    public NoteDTO(UserDTO owner) {
       
        this.owner = owner;
    }

    public UserDTO getOwner() {
        return this.owner;
    }
    
}
