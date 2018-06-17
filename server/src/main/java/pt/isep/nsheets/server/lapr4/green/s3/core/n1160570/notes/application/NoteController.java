/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1160570.notes.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.List;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1160570.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.NoteRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
public class NoteController implements Controller {

    private  NoteRepository noteRepository = PersistenceContext.repositories().note();

    public List<NoteDTO> allnoteUser(UserDTO userDTO) {
        return noteRepository.getListNoteUser(userDTO);
    }

    public NoteDTO saveNote(NoteDTO noteDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        noteRepository.save(Note.fromDTO(noteDTO));
        return noteDTO;
    }
}
