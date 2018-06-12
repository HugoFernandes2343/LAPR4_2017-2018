
package pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.table.MaterialInfiniteDataTable;
import gwt.material.design.client.ui.table.cell.TextColumn;
import pt.isep.nsheets.shared.services.*;

import java.util.ArrayList;
import java.util.List;


public class AgendaView extends ViewImpl implements AgendaPresenter.MyView {


    @UiField
    MaterialInfiniteDataTable<EventDTO> table;

    @UiField
    MaterialButton create;

    @UiField
    MaterialButton remove;

    @UiField
    MaterialButton edit;

    @UiField
    MaterialInfiniteDataTable<EventDTO> calendarTable;

    interface Binder extends UiBinder<Widget, AgendaView> {
    }

    @Inject
    AgendaView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        List<EventDTO> list = new ArrayList<>();
        EventDTO event = new EventDTO("teste", "teste", "teste", "teste", "teste");
        list.add(event);
        list.add(event);
        list.add(event);
        list.add(event);

        table.setRowHeight(4);
        table.setRowData(0, list);
        //table.getView().setRedraw(true);
       // table.getView().refresh();
        table.getTableTitle().setText("Upcoming Events");


        table.addColumn(new TextColumn<EventDTO>() {

            @Override
            public boolean isSortable() {
                return true;
            }
            @Override
            public String getValue(EventDTO object) {
                return object.getTitle();
            }
        }, "Title");

        table.addColumn(new TextColumn<EventDTO>() {

            @Override
            public boolean isSortable() {
                return true;
            }
            @Override
            public String getValue(EventDTO object) {
                return object.getDescription();
            }
        }, "Description");


        create.addClickHandler(clickEvent -> {
            CreateCalendarView calendarView = new CreateCalendarView();

        });

        remove.addClickHandler(clickEvent -> {
            RemoveCalendarView calendarView = new RemoveCalendarView();

        });

    }

    @Override
    protected void onAttach() {
        super.onAttach();
    }

}
