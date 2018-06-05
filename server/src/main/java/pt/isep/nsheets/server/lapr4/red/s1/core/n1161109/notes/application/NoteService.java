/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.persistence.NoteRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.domain.Note;
import pt.isep.nsheets.shared.services.NoteDTO;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class NoteService {
    
     public Iterable<Note> allNotes() {

        final NoteRepository noteRepository = PersistenceContext.repositories().notes();
        return noteRepository.findAll();
    }

    
    public Note addNote(NoteDTO nt) throws DataConcurrencyException, DataIntegrityViolationException {
        
        
        System.out.println("teste antes ntoeRepository");
        
        NoteRepository noteRepository = PersistenceContext.repositories().notes();
        
         System.out.println("teste after ntoeRepository");
//        
//        Note note =Note.fromDTO(nt);
//        
//        System.out.println("String do Note COnvertido:" + note.getString());
        
//        noteRepository.save(note);
//        
//        
//        return note;
return null;
    }
}
