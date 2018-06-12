package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161569.domain.Message;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.MessageRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

public class JpaMessageRepository extends NSheetsJpaRepositoryBase<Message, Long> implements MessageRepository {
    JpaMessageRepository(PersistenceSettings settings) {
        super(settings);
    }
}
