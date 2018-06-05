package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application.Services;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application.*;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain.Request;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

public class CommunityService {

    public Iterable<Request> showRequests(User u) {
        try {
            ShowRequestsController controller = new ShowRequestsController();
            ArrayList it = (ArrayList) controller.showRequests(u);
            if (it.isEmpty()) {
                throw new NullPointerException("Parameter Type cannot be null");
            } else {
                return it;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void answerRequest(boolean accpeted, User u1, User u2) {
        AnswerRequestController controller = new AnswerRequestController();

        try {
            controller.answerRequest(accpeted, u1,u2);
        } catch (DataConcurrencyException | DataIntegrityViolationException e) {
            e.printStackTrace();
        }
    }

    //change to email
    public void sendRequest(String emailSender, String emailReciever) {
        CreateRequestController controller = new CreateRequestController();
        controller.sendRequest(emailSender, emailReciever);
    }

    public Iterable<User> showContacts(String mail) {
        try {
            ShowContactsController controller = new ShowContactsController();
            ArrayList it = (ArrayList) controller.showContacts(mail);
            if (it.isEmpty()) {
                throw new NullPointerException("Parameter Type cannot be null");
            } else {
                return controller.showContacts(mail);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void removeContact(String emailUser, String emailTarget) {
        RemoveContactController controller = new RemoveContactController();
        controller.removeContact(emailUser, emailTarget);
    }

}
