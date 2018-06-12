package pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.persistenc.CalendarRepository;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.domain.Calendar;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.NSheetsJpaRepositoryBase;


public class JPACalendarRepository extends NSheetsJpaRepositoryBase<Calendar, Long> implements CalendarRepository {

    public JPACalendarRepository(PersistenceSettings settings) {
        super(settings);
    }

}
