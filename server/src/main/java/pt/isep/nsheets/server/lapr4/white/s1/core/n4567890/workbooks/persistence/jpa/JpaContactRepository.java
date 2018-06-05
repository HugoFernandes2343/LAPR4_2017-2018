package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain.Contact;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.ContactRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.RepositoryFactory;

import javax.persistence.Query;

public class JpaContactRepository extends NSheetsJpaRepositoryBase<Contact, Long> implements ContactRepository {
    public JpaContactRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public void remove(User u1, User u2) {
        final Query q = entityManager().createQuery("DELETE FROM Contact c WHERE c.u1=:u1 AND c.u2=:u2", this.entityClass);
        q.setParameter("u1", u1);
        q.setParameter("u2", u2);
    }

    @Override
    public Iterable<User> showContactsByUser(User u) {
        final Query q = entityManager().createQuery("SELECT c FROM Contact c WHERE c.u1=:u OR c.u2=:u", this.entityClass);
        q.setParameter("u", u);
        return q.getResultList();
    }
}
