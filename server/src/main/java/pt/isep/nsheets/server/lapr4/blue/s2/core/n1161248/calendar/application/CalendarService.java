package pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.persistenc.CalendarRepository;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.domain.Calendar;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.CalendarDTO;

public class CalendarService {

    public Calendar addCalendar(CalendarDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {

        final CalendarRepository calendarRepository = PersistenceContext.repositories().calendares();

        Calendar cal = Calendar.fromDTO(dto);

        calendarRepository.save(cal);

        return cal;
    }

    public Iterable<Calendar> allCalendares() {

        final CalendarRepository calendarRepository = PersistenceContext.repositories().calendares();
        return calendarRepository.findAll();
    }

    public Calendar findCalendarByName(String name){
        final CalendarRepository calendarRepository = PersistenceContext.repositories().calendares();
        return calendarRepository.findCalendarByName(name);
    }

    
}
