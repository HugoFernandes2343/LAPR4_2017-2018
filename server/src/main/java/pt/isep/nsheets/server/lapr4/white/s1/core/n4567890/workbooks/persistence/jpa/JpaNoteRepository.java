/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.List;
import javax.persistence.Query;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.green.s3.core.n1160570.notes.domain.Note;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.NoteRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
public class JpaNoteRepository extends NSheetsJpaRepositoryBase<Note, Long> implements NoteRepository {
    
    JpaNoteRepository(PersistenceSettings settings) {
        super(settings);
    }
    
    @Override
    public List<NoteDTO> getListNoteUser(UserDTO userDTO) {
        final Query q = entityManager().createQuery("SELECT n FROM Note n WHERE n.user=:e", this.entityClass);
        q.setParameter("e", User.fromDTO(userDTO));
        return q.getResultList();
    }
    
}
