package pt.isep.nsheets.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

public class HomePresenter
		extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

	interface MyView extends View {
	}

	@NameToken(NameTokens.home)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<HomePresenter> {
	}

	@Inject
	HomePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
	}

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Home", "The most recent Workbooks", "", "", this);
    }	
}