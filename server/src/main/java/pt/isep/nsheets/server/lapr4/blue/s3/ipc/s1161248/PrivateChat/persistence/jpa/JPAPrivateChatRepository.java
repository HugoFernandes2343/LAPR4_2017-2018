package pt.isep.nsheets.server.lapr4.blue.s3.ipc.s1161248.PrivateChat.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.s3.ipc.s1161248.PrivateChat.domain.Chat;
import pt.isep.nsheets.server.lapr4.blue.s3.ipc.s1161248.PrivateChat.persistence.PrivateChatRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.NSheetsJpaRepositoryBase;

public class JPAPrivateChatRepository extends NSheetsJpaRepositoryBase<Chat, Long> implements PrivateChatRepository {
    public JPAPrivateChatRepository(PersistenceSettings settings) {
        super(settings);
    }


}
