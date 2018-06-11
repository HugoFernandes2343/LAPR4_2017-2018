package pt.isep.nsheets.client.lapr4.red.s2.s1161569;


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

public class ChatPresenter extends Presenter<ChatPresenter.MyView, ChatPresenter.MyProxy>{

    private MyView view;

    interface MyView extends View {
        void setContents(ArrayList<MessageDTO> contents);

        void addClickHandler(ClickHandler ch);

        void addClickHandlerReload(ClickHandler ch);

        public MaterialTextArea getFirstBox();

    }

    @NameToken(NameTokens.chat)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ChatPresenter> {
    }

    @Inject
    ChatPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.addClickHandler(event -> {

            ChatServiceAsync chatSvc = GWT.create(ChatService.class);

            // Set up the callback object.
            AsyncCallback<MessageDTO> callback = new AsyncCallback<MessageDTO>() {
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                public void onSuccess(MessageDTO result) {
                    MaterialToast.fireToast("Chat updated...", "rounded");

                    refreshView();
                }
            };
            if(this.view.getFirstBox().getText().isEmpty()){
                throw new IllegalArgumentException();
            }
            MessageDTO mDto = new MessageDTO("god_should_be_here",this.view.getFirstBox().getText(),new Date());
            chatSvc.addMessage(mDto, callback);
        });
        this.view.addClickHandlerReload(event -> {
            refreshView();
        });
    }

    private void refreshView() {
        ChatServiceAsync chatSvc = GWT.create(ChatService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<MessageDTO>> callback = new AsyncCallback<ArrayList<MessageDTO>>() {
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error! " + caught.getMessage());
            }

            public void onSuccess(ArrayList<MessageDTO> result) {
                view.setContents(result);
            }
        };

        chatSvc.getMessages(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Social Chat", "Trade ideas with the chat", "", "", this);
        refreshView();
    }
}
