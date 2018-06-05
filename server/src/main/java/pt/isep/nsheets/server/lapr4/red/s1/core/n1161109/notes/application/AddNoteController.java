/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.domain.Note;
import pt.isep.nsheets.shared.services.NoteDTO;



/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class AddNoteController implements Controller{
    

    public Note addNote(NoteDTO nt) throws DataConcurrencyException, DataIntegrityViolationException {
        
    	return new NoteService().addNote(nt);
    }
    
}
