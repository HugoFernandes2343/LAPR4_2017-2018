package pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.domain.Calendar;

public class ListCalendarController implements Controller {

    public Iterable<Calendar> listCalendares() {
        return new CalendarService().allCalendares();
    }
}
