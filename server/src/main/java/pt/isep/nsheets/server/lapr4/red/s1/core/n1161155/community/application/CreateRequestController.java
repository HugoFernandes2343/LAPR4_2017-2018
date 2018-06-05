package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application.Services.RequestService;

public class CreateRequestController {
    public void sendRequest(String emailSender, String emailReciever) {
        RequestService service = new RequestService();
        try {
            service.sendRequest( emailSender,  emailReciever);
        } catch (DataConcurrencyException | DataIntegrityViolationException e) {
            e.printStackTrace();
        }
    }
}
