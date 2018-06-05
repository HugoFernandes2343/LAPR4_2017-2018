package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application.Services;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain.Contact;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain.Request;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.ContactRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.RequestRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRequestRepository;

public class RequestService {


    public void answerRequest(Boolean accepted, User u1, User u2) throws DataConcurrencyException, DataIntegrityViolationException {
        final RequestRepository requestRepository = PersistenceContext.repositories().requests();
        if (accepted) {
            final ContactRepository contactRepository = PersistenceContext.repositories().contacts();
            Contact contact = new Contact(u1,u2);
            contactRepository.save(contact);
            requestRepository.remove(u1,u2);
        } else {
            requestRepository.remove(u1,u2);
        }
    }

    public void sendRequest(String emailSender, String emailReciever) throws DataConcurrencyException, DataIntegrityViolationException {
        final RequestRepository requestRepository = PersistenceContext.repositories().requests();
        final UserRepository userRepository = PersistenceContext.repositories().user();
        try {
            if (userRepository.getUserByEmail(emailReciever) == null) {
                throw new NullPointerException("Reciever email is wrong");
            }
        } catch (NullPointerException e) {
            System.out.print(e.toString());
        }
        Email emailS = new Email(emailSender);
        Email emailR = new Email(emailReciever);

        Request request = new Request(emailS, emailR);
        requestRepository.save(request);
    }

    public Iterable<Request> showRequest(User u) {
        final RequestRepository requestRepository = PersistenceContext.repositories().requests();

        return requestRepository.findRequestByReceiver(u);
    }
}
