package pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.services.CalendarDTO;
import pt.isep.nsheets.shared.services.CalendarService;
import pt.isep.nsheets.shared.services.CalendarServiceAsync;

import java.util.ArrayList;

public class RemoveCalendarView extends Composite {

    @UiField
    MaterialDropDown name = new MaterialDropDown();
    @UiField
    MaterialButton delectButton = new MaterialButton("Delect");
    @UiField
    MaterialButton cancelButton = new MaterialButton("Cancel");

    private static CreateCalendarUiBinder uiBinder = GWT.create(CreateCalendarUiBinder.class);

    interface CreateCalendarUiBinder extends UiBinder<Widget, CreateCalendarView> {
    }

    public RemoveCalendarView() {


    }
}
