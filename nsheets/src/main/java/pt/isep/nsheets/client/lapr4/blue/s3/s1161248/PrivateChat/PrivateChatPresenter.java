package pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat;

import com.google.gwt.core.client.GWT;
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
import pt.isep.nsheets.shared.services.MessageDTO;
import pt.isep.nsheets.shared.services.PrivateChatService;
import pt.isep.nsheets.shared.services.PrivateChatServiceAsync;

import java.util.ArrayList;

public class PrivateChatPresenter extends Presenter<PrivateChatPresenter.MyView, PrivateChatPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {
        void setContents(ArrayList<MessageDTO> contents);
    }

    @NameToken(NameTokens.privateChat)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<PrivateChatPresenter> {

    }

    @Inject
    PrivateChatPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Private Chat", "", "", "", this);
    }

    private void refreshView() {
        PrivateChatServiceAsync chatSvc = GWT.create(PrivateChatService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<MessageDTO>> callback = new AsyncCallback<ArrayList<MessageDTO>>() {
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error! " + caught.getMessage());
            }

            public void onSuccess(ArrayList<MessageDTO> result) {
                view.setContents(result);
            }
        };

       // chatSvc.getMessages(callback);
    }

}
