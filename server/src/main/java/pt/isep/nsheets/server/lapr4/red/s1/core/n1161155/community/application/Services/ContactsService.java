package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application.Services;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.ContactRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaLoginRepository;

public class ContactsService {
    public void removeContact(String email1, String email2) {
        final ContactRepository contactRepository = PersistenceContext.repositories().contacts();
        final UserRepository userRepository = PersistenceContext.repositories().user();
        User u1 = userRepository.getUserByEmail(email1);
        User u2 = userRepository.getUserByEmail(email2);
        contactRepository.remove(u1,u2);
    }

    public Iterable<User> showContacts(String email) {
        final ContactRepository contactRepository = PersistenceContext.repositories().contacts();
        final UserRepository userRepository = PersistenceContext.repositories().user();
        User u1 = userRepository.getUserByEmail(email);
        return contactRepository.showContactsByUser(u1);
    }
}
