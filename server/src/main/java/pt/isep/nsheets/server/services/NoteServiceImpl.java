/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.application.AddNoteController;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.application.ListNoteController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.domain.Note;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.NoteService;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class NoteServiceImpl extends RemoteServiceServlet implements NoteService {

    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url",
        // "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // props.put("javax.persistence.jdbc.password", "");
        // props.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // props.put("javax.persistence.jdbc.user", "");
        // props.put("javax.persistence.schema-generation.database.action", "create");
        // props.put("eclipselink.logging.level", "FINE");
        return new PersistenceSettings(props);
    }

    @Override
    public ArrayList<NoteDTO> getNotes() {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ListNoteController ctrl = new ListNoteController();

        List<Note> notes = (List<Note>) ctrl.listNotes();
        ArrayList<NoteDTO> noteDTOS = new ArrayList();
        for (Note nt: notes) {
            
//            noteDTOS.add(nt.toDTO());
            
        }
        
        
       
        return noteDTOS;

    }

//    @Override
    public NoteDTO addNote(NoteDTO ntDto) throws DataException {
//        PersistenceContext.setSettings(this.getPersistenceSettings());
//
//        AddNoteController ctrl = new AddNoteController();
//
//        try {
////            return ctrl.addNote(ntDto).toDTO();
//
//        } catch (DataConcurrencyException ex) {
//            throw new DataException((Throwable) ex);
//        } catch (DataIntegrityViolationException ex) {
//            throw new DataException((Throwable) ex);
//        }

    return null;
    }
}
