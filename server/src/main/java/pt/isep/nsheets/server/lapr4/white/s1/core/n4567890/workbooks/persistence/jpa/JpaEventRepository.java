package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import eapli.framework.persistence.repositories.impl.inmemory.NotFoundException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161213.events.domain.Event;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.EventRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.*;

import javax.persistence.Query;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class JpaEventRepository extends NSheetsJpaRepositoryBase<Event, Long> implements EventRepository {

    public JpaEventRepository(PersistenceSettings settings) {
        super(settings);
    }

    public void deleteEvent(Long id){
        deleteByPK(id);
    }

    public Event findById(Long id){
        Optional<Event> e = findOne(id);

        return e.get();
    }

    @Override
    public List<Event> findByUserAndDates(User u, Date date) {
         HashMap<String, Object> params = new HashMap<>();
         params.put("u", u);
         params.put("date", date);
         List<Event> ret = match("e.user = u and e.date = date", params);
         return ret;
    }
}
