
package pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.table.MaterialDataTable;


public class AgendaView extends ViewImpl implements AgendaPresenter.MyView {


    @UiField
    MaterialDataTable table;

    interface Binder extends UiBinder<Widget, AgendaView> {
        //MaterialDataTable getTable();
    }

    @Inject
    AgendaView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        table.getTableTitle().setText("Upcoming Events");
        //table = new MaterialDataTable<>();

        /**table.addColumn(new TextColumn<Event>() {
        @Override public boolean isSortable() {
        return true;
        }
        @Override public String getValue(Event object) {
        return object.getTitle();
        }
        }, "Title");*/
    }

    @Override
    protected void onAttach() {
        super.onAttach();
    }

}
