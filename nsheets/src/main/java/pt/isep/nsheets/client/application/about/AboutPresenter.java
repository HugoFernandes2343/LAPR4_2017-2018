package pt.isep.nsheets.client.application.about;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

public class AboutPresenter extends Presenter<AboutPresenter.MyView, AboutPresenter.MyProxy>  {
	
    interface MyView extends View  {
    }
    
    @NameToken(NameTokens.about)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<AboutPresenter> {
    }

    @Inject
    AboutPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }
    
    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("About", "A description of NSheets", "", "", this);
    }
        
}