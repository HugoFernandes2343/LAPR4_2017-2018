/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.persistence.NoteRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDTO;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.domain.Note;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */

public class JpaNoteRepository extends NSheetsJpaRepositoryBase<Note, Long> implements NoteRepository {
    
    JpaNoteRepository(PersistenceSettings settings) {
        super(settings);
    }
    
}