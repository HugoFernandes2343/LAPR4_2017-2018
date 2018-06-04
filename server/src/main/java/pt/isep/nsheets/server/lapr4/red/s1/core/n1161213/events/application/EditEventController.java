package pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain.Event;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.EventRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;

public class EditEventController implements Controller {

    private final EventRepository repo;

    private Event eventToEdit;

    public EditEventController(Long id) {
        this.repo = PersistenceContext.repositories().events();
        eventToEdit = repo.findById(id);
    }

}
