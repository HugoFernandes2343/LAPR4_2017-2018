package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;


import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain.Contact;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain.Request;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.RepositoryFactory;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.RequestRepository;

import javax.persistence.Query;

public class JpaRequestRepository extends NSheetsJpaRepositoryBase<Request, Long> implements RequestRepository {
    public JpaRequestRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public Iterable<Request> findRequestByReceiver(User u) {
        final Query q = entityManager().createQuery("SELECT r FROM Request r WHERE r.recieverEmail=:e", this.entityClass);
        q.setParameter("e", u.getEmail());
        return q.getResultList();
    }

    @Override
    public void remove(User u1, User u2) {
        final Query q = entityManager().createQuery("DELETE FROM Request r WHERE r.recieverEmail=:u1 AND r.senderEmail=:u2", this.entityClass);
        q.setParameter("u1", u1.getEmail());
        q.setParameter("u2", u2.getEmail());
    }


}
