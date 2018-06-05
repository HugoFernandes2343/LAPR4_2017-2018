package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain.Contact;

public interface ContactRepository extends Repository<Contact, Long> {
    void remove(User u1, User u2);

    Iterable<User> showContactsByUser(User u);
}
