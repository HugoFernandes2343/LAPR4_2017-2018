package pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.domain.Calendar;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.persistenc.CalendarRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.CalendarDTO;

public class AddCalendarController implements Controller {


    public Calendar addCalendar(CalendarDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {

        return new CalendarService().addCalendar(dto);
    }

    public void deleteCalendar(String calendarDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        CalendarRepository calendarRepository = PersistenceContext.repositories().calendares();
        calendarRepository.deleteCalendar(calendarDTO);
    }

    public Calendar findCalendarByName(String name) throws DataConcurrencyException, DataIntegrityViolationException {

        return new CalendarService().findCalendarByName(name);
    }

}
