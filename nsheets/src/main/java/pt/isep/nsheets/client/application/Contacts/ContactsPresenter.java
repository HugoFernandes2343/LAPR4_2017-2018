package pt.isep.nsheets.client.application.Contacts;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.Requests.RequestsPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import com.google.web.bindery.event.shared.EventBus;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

import javax.inject.Inject;
import java.util.ArrayList;

public class ContactsPresenter extends Presenter<ContactsPresenter.MyView,ContactsPresenter.MyProxy> {
    private MyView view;

    interface MyView extends View {

        void setContents();

        void addClickHandler(ClickHandler ch);
    }

    @NameToken(NameTokens.contacts)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<ContactsPresenter> {
    }

    @Inject
    ContactsPresenter(EventBus eventBus,MyView view,MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.addClickHandler((ClickEvent event) -> {

        });

    }
    /*private void refreshView() {


        workbooksSvc.getWorkbooks(callback);
    }*/

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Contacts", "See and delete your contacts here", "", "", this);

    }
}
