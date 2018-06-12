package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.application.AddCalendarController;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.application.ListCalendarController;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.domain.Calendar;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.CalendarDTO;
import pt.isep.nsheets.shared.services.CalendarService;
import pt.isep.nsheets.shared.services.DataException;

import java.util.ArrayList;
import java.util.Properties;

public class CalendarServiceImpl extends RemoteServiceServlet implements CalendarService {

    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        return new PersistenceSettings(props);
    }

    @Override
    public ArrayList<CalendarDTO> getCalendares() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<CalendarDTO> calendares = new ArrayList<CalendarDTO>();

        ListCalendarController ctrl = new ListCalendarController();

        Iterable<Calendar> cal = ctrl.listCalendares();

        cal.forEach(c -> calendares.add(c.toDTO()));

        return calendares;
    }

    @Override
    public void deleteCalendar(String calendar) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        CalendarDTO calender = new CalendarDTO();
        AddCalendarController ctrl = new AddCalendarController();
        try {
            ctrl.deleteCalendar(calendar);
        } catch (DataConcurrencyException e) {
            e.printStackTrace();
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CalendarDTO addCalendar(CalendarDTO c) throws DataException {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        AddCalendarController ctrl = new AddCalendarController();

        Calendar cal = null;
        try {
            cal = ctrl.addCalendar(c);
        } catch (DataConcurrencyException ex) {
            throw new DataException((Throwable) ex);
        } catch (DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }
        return cal.toDTO();
    }
}
