package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain.Event;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.EventRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.*;

import java.util.Date;
import java.util.HashMap;

public class JpaEventRepository extends NSheetsJpaRepositoryBase<Event, Long> implements EventRepository {

    public JpaEventRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public Iterable<Event> findAllByUser(User user) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("u", user);
        Iterable<Event> ret = match("e.user =: u", params);
        return ret;
    }

    @Override
    public Iterable<Event> findUserEventsInDate(Date date) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("date", date);
        Iterable<Event> ret = match("e.timestamp =: date", params);
        return ret;
    }
}
