package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

public interface CalendarServiceAsync {
    void addCalendar(CalendarDTO calDto, AsyncCallback<CalendarDTO> callback);
    void getCalendares(AsyncCallback<ArrayList<CalendarDTO>> callback);
}
