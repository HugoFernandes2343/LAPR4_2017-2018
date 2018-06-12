package pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.services.*;

public class CreateCalendarView extends Composite {

    @UiField
    MaterialTextBox name = new MaterialTextBox();
    @UiField
    MaterialTextArea description = new MaterialTextArea();
    @UiField
    MaterialComboBox color = new MaterialComboBox();
    @UiField
    MaterialButton saveButton = new MaterialButton("Save");
    @UiField
    MaterialButton cancelButton = new MaterialButton("Cancel");

    private static CreateCalendarUiBinder uiBinder = GWT.create(CreateCalendarUiBinder.class);

    interface CreateCalendarUiBinder extends UiBinder<Widget, CreateCalendarView> {
    }

    public CreateCalendarView() {

        initWidget(uiBinder.createAndBindUi(this));
        MaterialWindow window = new MaterialWindow();
        window.setPadding(32);
        window.setHeight("600px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Create a Calendar");
        MaterialWindow.setOverlay(true);
        MaterialPanel p0 = new MaterialPanel();
        MaterialLabel label = new MaterialLabel("COLOR");
        this.color.addItem("BLUE");
        this.color.addItem("RED");
        this.color.addItem("GREEN");
        this.color.addItem("YELLOW");
        p0.add(label);
        p0.add(this.color);
        window.add(p0);
        MaterialPanel p1 = new MaterialPanel();
        MaterialLabel macroNameL = new MaterialLabel("Insert Calendar's name");
        p1.add(macroNameL);
        p1.add(this.name);
        window.add(p1);
        MaterialPanel p2 = new MaterialPanel();
        MaterialLabel label2 = new MaterialLabel("Insert Description");
        p2.add(label2);
        p2.add(this.description);
        window.add(p2);
        MaterialPanel p3 = new MaterialPanel();
        p3.add(this.saveButton);
        p3.add(this.cancelButton);
        window.add(p3);
        window.open();

        cancelButton.addClickHandler(clickEvent -> {
            window.close();
        });

        saveButton.addClickHandler(clickEvent -> {
                    String name = getCalendarName().getText();
                    String description = getCalendarDescription().getText();
                    EmailDTO email = new EmailDTO("lalala@");
                    PasswordDTO password = new PasswordDTO("voalasdsds");
                    NameDTO n = new NameDTO("teste", "boas");
                    NicknameDTO nick = new NicknameDTO("ola");
                    UserDTO user = new UserDTO(email,password,n, nick);
                    CalendarDTO calendar = new CalendarDTO(name, description, user);


                    CalendarServiceAsync calendarSvc = GWT.create(CalendarService.class);

                    // Set up the callback object.
                    AsyncCallback<CalendarDTO> callback = new AsyncCallback<CalendarDTO>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            MaterialToast.fireToast("Error! " + caught.getMessage());
                        }

                        @Override
                        public void onSuccess(CalendarDTO result) {
                            MaterialToast.fireToast("New Calendar Created...", "rounded");

                        }
                    };

                    calendarSvc.addCalendar(calendar, callback);

                    window.close();


                }
        );

    }


    public MaterialComboBox getColor() {
        return this.color;
    }

    public MaterialTextBox getCalendarName() {
        return this.name;
    }

    public MaterialTextArea getCalendarDescription() {
        return this.description;
    }

    public MaterialButton getSaveButton() {
        return this.saveButton;
    }

    public MaterialButton getCancelButton() {
        return this.cancelButton;
    }

}
