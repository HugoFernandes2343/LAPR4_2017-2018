package pt.isep.nsheets.client.application.Requests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

import java.util.ArrayList;

public class RequestsPresenter extends Presenter<RequestsPresenter.MyView, RequestsPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void setContents();

        void addClickHandler(ClickHandler ch);
    }

    @NameToken(NameTokens.requests)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<RequestsPresenter> {
    }

    @Inject
    RequestsPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        view.setContents();
    }

    private void refreshView() {
        view.setContents();
    }




    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Requests", "Accept or refuse your friend requests", "", "", this);

        refreshView();
    }
}
