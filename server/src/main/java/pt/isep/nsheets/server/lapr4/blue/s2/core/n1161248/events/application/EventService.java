package pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.events.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain.Event;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.EventRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;

import java.util.ArrayList;

public class EventService {

    public Iterable<Event> allEvents() {

        ArrayList<Event> ret = new ArrayList<>();
        final EventRepository eventRepository = PersistenceContext.repositories().events();
        for (Event event : eventRepository.findAll()) {
            ret.add(event.toEvent());
        }

        return ret;
    }

    public Event saveEvent(Event event) throws DataConcurrencyException, DataIntegrityViolationException {

        final EventRepository eventRepository = PersistenceContext.repositories().events();

        Event ev = eventRepository.findById(event.id());
        if (ev == null) {
            eventRepository.save(ev.fromEvent(event));
        } else {
            ev.setTitle(event.getTitle());
            ev.setDescription(event.getDescription());
            ev.setMadeBy(event.getMadeBy());
            ev.setDate(event.getDate());
            ev.setDuration(event.getDuration());
            eventRepository.save(ev);
        }
        return event;
    }

    public void deleteEvent(Event event) throws DataConcurrencyException, DataIntegrityViolationException {
        final EventRepository workbookRepository = PersistenceContext.repositories().events();

        Event ev = Event.fromEvent(event);

        workbookRepository.save(ev);
    }

}
