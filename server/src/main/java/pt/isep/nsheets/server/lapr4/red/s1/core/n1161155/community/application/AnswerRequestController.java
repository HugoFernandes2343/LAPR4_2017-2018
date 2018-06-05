package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application.Services.RequestService;

public class AnswerRequestController {
    public void answerRequest(boolean accpeted, User u1, User u2) throws DataConcurrencyException, DataIntegrityViolationException {
        RequestService service = new RequestService();
        service.answerRequest(accpeted, u1,u2);
    }
}
