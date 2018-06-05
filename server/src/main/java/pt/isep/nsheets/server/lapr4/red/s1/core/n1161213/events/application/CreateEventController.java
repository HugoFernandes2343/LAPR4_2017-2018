package pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain.Duration;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain.Event;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.EventRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateEventController implements Controller {

    private final EventRepository repo = PersistenceContext.repositories().events();

    public CreateEventController(){

    }

    public void newEvent(String title, String description, User user, Date timestamp, Integer from, Integer to, boolean isAllDay){
        Duration duration = new Duration(from, to, isAllDay);
        Event event = new Event(title, description, user, timestamp, duration); //Can't obtain the user that is logged in. Not implemented yet.

        try {
            repo.save(event);
        } catch (DataConcurrencyException e) {
            Logger.getLogger(CreateEventController.class.getName()).log(Level.SEVERE, null, e);
        } catch (DataIntegrityViolationException e) {
            Logger.getLogger(CreateEventController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
