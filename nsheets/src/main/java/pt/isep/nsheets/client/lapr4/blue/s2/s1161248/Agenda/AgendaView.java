
package pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;



import javax.inject.Inject;

public class AgendaView extends ViewImpl implements AgendaPresenter.MyView {


    interface Binder extends UiBinder<Widget, AgendaView> {
    }

    @Inject
    AgendaView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();
    }

}
