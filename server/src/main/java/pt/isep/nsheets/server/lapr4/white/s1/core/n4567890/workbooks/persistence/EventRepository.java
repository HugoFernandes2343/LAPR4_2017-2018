package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain.Event;

import java.util.Date;


public interface EventRepository extends Repository<Event, Long> {

    public void deleteEvent(Long id);

    public Event findById(Long id);

    public Iterable<Event> findByUserAndDates(User u, Date date);
}
