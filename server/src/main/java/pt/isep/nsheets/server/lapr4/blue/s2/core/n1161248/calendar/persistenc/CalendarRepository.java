package pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.persistenc;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.domain.Calendar;
import pt.isep.nsheets.shared.services.CalendarDTO;

public interface CalendarRepository extends Repository<Calendar, Long> {

    void deleteCalendar(String calendar);

    Calendar findCalendarByName(String name);
}
