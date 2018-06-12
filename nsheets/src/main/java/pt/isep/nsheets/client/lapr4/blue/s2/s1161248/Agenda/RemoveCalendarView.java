package pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.services.CalendarDTO;
import pt.isep.nsheets.shared.services.CalendarService;
import pt.isep.nsheets.shared.services.CalendarServiceAsync;

import java.util.ArrayList;

public class RemoveCalendarView extends Composite {

    @UiField
    MaterialComboBox calendar = new MaterialComboBox();
    @UiField
    MaterialButton deleteButton = new MaterialButton("Delete");
    @UiField
    MaterialButton cancelButton = new MaterialButton("Cancel");
    @UiField
    MaterialWindow window;

    private static RemoveCalendarUiBinder uiBinder = GWT.create(RemoveCalendarUiBinder.class);

    interface RemoveCalendarUiBinder extends UiBinder<Widget, RemoveCalendarView> {
    }

    public RemoveCalendarView() {

        initWidget(uiBinder.createAndBindUi(this));
        MaterialWindow window = new MaterialWindow();
        window.setPadding(32);
        window.setHeight("600px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Remove a Calendar");
        MaterialWindow.setOverlay(true);
        MaterialPanel p1 = new MaterialPanel();
        ArrayList<String> list = new ArrayList<>();
        CalendarServiceAsync calendarSvc = GWT.create(CalendarService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<CalendarDTO>> callback = new AsyncCallback<ArrayList<CalendarDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<CalendarDTO> result) {
                MaterialToast.fireToast("Calendares Loaded...", "rounded");
                for (CalendarDTO c : result) {
                    calendar.addItem(c.getName());

                }

            }
        };

        calendarSvc.getCalendares(callback);

        p1.add(calendar);
        MaterialLabel label = new MaterialLabel("Choose one Calendar");
        window.add(label);
        window.add(p1);
        window.add(p1);
        MaterialPanel p2 = new MaterialPanel();
        p2.add(deleteButton);
        p2.add(cancelButton);
        window.add(p2);

        window.open();


        cancelButton.addClickHandler(clickEvent -> {
            window.close();
        });


    }
}