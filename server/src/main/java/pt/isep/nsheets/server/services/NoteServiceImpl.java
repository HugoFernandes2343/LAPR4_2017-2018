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
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1160570.notes.application.NoteController;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1160570.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.NoteService;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
public class NoteServiceImpl extends RemoteServiceServlet implements NoteService {

    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        return new PersistenceSettings(props);
    }

    @Override
    public NoteDTO addNote(NoteDTO noteDTO) throws DataException {
        try {
            PersistenceContext.setSettings(this.getPersistenceSettings());
            NoteController ctr = new NoteController();
            ctr.saveNote(noteDTO);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(NoteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noteDTO;

    }

    @Override
    public Iterable<NoteDTO> getNotes(UserDTO userDTO) {
        NoteController controller = new NoteController();
        Iterable<NoteDTO> listNote = controller.getNotes(userDTO);

        List<NoteDTO> listDTO = new ArrayList<>();

        Iterator it = listNote.iterator();

        while (it.hasNext()) {
            Note t = (Note) it.next();
            NoteDTO dto = t.toDTO();
            listDTO.add(dto);
        }
        return listDTO;
    }

    @Override
    public void deleteNote(NoteDTO noteDTO) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        NoteController ctr = new NoteController();
        try {
            ctr.deleteNote(noteDTO);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;
    }

    @Override
    public void editNote(String title, String text, String oldName) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        NoteController ctr = new NoteController();

        try {
            ctr.editNote(title, text, oldName);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
