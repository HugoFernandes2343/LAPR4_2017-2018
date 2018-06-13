package pt.isep.nsheets.client.lpar4.green.s3.s1160570.notes;

import pt.isep.nsheets.client.lapr4.red.s2.s1161569.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.ibm.icu.impl.IllegalIcuArgumentException;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.ChatService;
import pt.isep.nsheets.shared.services.ChatServiceAsync;
import pt.isep.nsheets.shared.services.MessageDTO;

import java.util.ArrayList;
import java.util.Date;

public class NotePresenter extends Presenter<NotePresenter.MyView, NotePresenter.MyProxy> {


    interface MyView extends View {
    }

    @NameToken(NameTokens.notess)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<NotePresenter> {
    }

    @Inject
    NotePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        
    }

  

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Social Chat", "Trade ideas with the chat", "", "", this);
    }
}
