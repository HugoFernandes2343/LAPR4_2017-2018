package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.application.Services.RequestService;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain.Request;

public class ShowRequestsController {
    public Iterable<Request> showRequests(User u) {
        RequestService service = new RequestService();
        return service.showRequest(u);
    }
}
