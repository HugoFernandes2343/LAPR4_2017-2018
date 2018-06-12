package pt.isep.nsheets.shared.services;

        import com.google.gwt.user.client.rpc.RemoteService;
        import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

        import java.util.ArrayList;

@RemoteServiceRelativePath("calendarService")
public interface CalendarService extends RemoteService {
    CalendarDTO addCalendar(CalendarDTO cDto) throws DataException;
    ArrayList<CalendarDTO> getCalendares();
}
