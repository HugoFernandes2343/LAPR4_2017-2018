package pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.domain.Calendar;
import pt.isep.nsheets.shared.services.CalendarDTO;

public class AddCalendarController implements Controller {


    public Calendar addCalendar(CalendarDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {

        return new CalendarService().addCalendar(dto);
    }
}
