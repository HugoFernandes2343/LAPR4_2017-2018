package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application.Services.ContactsService;

public class ShowContactsController {
    public Iterable<User> showContacts(String mail) {
        ContactsService service = new ContactsService();
        return service.showContacts(mail);
    }
}
