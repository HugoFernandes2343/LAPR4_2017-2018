package pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda;

/**import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

public class AgendaPresenter extends Presenter<AgendaPresenter.MyView, AgendaPresenter.MyProxy> {

    interface MyView extends View {
    }

    private AgendaPresenter.MyView view;

    @NameToken(NameTokens.agenda)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<AgendaPresenter> {

    }

    @Inject
    AgendaPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Agenda", "", "", "", this);

    }

}
*/