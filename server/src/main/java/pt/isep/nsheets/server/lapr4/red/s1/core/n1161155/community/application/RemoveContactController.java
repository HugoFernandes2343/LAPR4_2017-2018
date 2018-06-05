package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application.Services.ContactsService;

public class RemoveContactController {
    public void removeContact(String emailUser, String emailTarget) {
        ContactsService service = new ContactsService();
        service.removeContact(emailUser, emailTarget);
    }
}
