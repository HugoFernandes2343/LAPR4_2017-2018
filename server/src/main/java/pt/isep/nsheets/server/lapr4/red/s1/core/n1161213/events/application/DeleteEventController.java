package pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.EventRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;

public class DeleteEventController implements Controller {

    private final EventRepository repo = PersistenceContext.repositories().events();

    public DeleteEventController(){

    }

    public void deleteEvent(Long id){
        repo.deleteEvent(id);
    }
}
