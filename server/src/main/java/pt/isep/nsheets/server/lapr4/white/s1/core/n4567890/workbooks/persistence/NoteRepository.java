/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import eapli.framework.persistence.repositories.Repository;
import java.util.List;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1160570.notes.domain.Note;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
public interface NoteRepository extends Repository<Note, Long> {

    Iterable<NoteDTO> getListNoteUser(UserDTO userDTO);
}
