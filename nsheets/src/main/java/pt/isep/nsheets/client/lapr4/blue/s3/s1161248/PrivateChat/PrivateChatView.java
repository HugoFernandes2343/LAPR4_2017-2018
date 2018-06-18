
package pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.shared.services.*;

import java.util.Date;
import java.util.List;


public class PrivateChatView extends ViewImpl implements PrivateChatPresenter.MyView {


    @UiField
    MaterialCard card;

    @UiField
    MaterialLink openChat;


    @UiField
    MaterialButton newChat;

    @UiField
    MaterialButton invites;

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialButton refresh;


    interface Binder extends UiBinder<Widget, PrivateChatView> {
    }


    @Inject
    PrivateChatView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        UserDTO user = CurrentUser.getCurrentUser();
        if (!user.getChatList().isEmpty()) {
            for (ChatDTO chat : user.getChatList()) {
                if (!chat.isAccepted()) {
                    invites.setBackgroundColor(Color.RED);
                }
            }
        }

        newChat.addClickHandler(clickEvent ->
        {
            NewChatView newChat = new NewChatView(user, this);
        });
        invites.addClickHandler(clickEvent ->
        {
            PendingInvitesView pendingInvites = new PendingInvitesView(user, this);
            invites.setBackgroundColor(Color.BLUE_DARKEN_1);

        });
        refresh.addClickHandler(clickEvent -> {

            UsersServiceAsync userSvc = GWT.create(UsersService.class);
            // Set up the callback object.
            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(UserDTO user) {
                    MaterialToast.fireToast("Refresh", "rounded");
                    setContents(user.getChatList());
                }
            };

            userSvc.getUserByEmail(user.getEmail().getEmail(), callback);

        });
    }


    @Override
    protected void onAttach() {
        super.onAttach();
    }


    private MaterialCard createCard(ChatDTO chat) {
        UserDTO user = CurrentUser.getCurrentUser();
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.GREEN_DARKEN_1);
        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialCardTitle cardTitle = new MaterialCardTitle();
        cardTitle.setText(chat.getName());
        cardTitle.setIconType(IconType.DONE);
        cardTitle.setIconPosition(IconPosition.RIGHT);


        MaterialLabel labelDescritpion = new MaterialLabel();
        labelDescritpion.setText("Number of Messages " + chat.getMessages().size());

        MaterialCardAction cardAction = new MaterialCardAction();


        MaterialLink editLink = new MaterialLink();
        editLink.setText("Open");
        editLink.setIconType(IconType.EDIT);
        editLink.setIconColor(Color.INDIGO);
        editLink.setTextColor(Color.WHITE);

        editLink.addClickHandler(event -> {
            MaterialWindow window = new MaterialWindow(chat.getName());


            loadMessages(window, chat, user);
            MaterialTextArea textArea = new MaterialTextArea();
            window.add(textArea);
            MaterialButton sendButton = new MaterialButton("Send");
            window.add(sendButton);

            //aqui vai ser para guardar as mensagens inseridas pelo utilizador
            sendButton.addClickHandler(sendEvet -> {
                if (!textArea.getText().isEmpty()) {
                    MessageDTO message = new MessageDTO(user.getName().getFirstName(), textArea.getText(), new Date());
                    chat.getMessages().add(message);

                    UsersServiceAsync userSvc = GWT.create(UsersService.class);

                    // Set up the callback object.
                    AsyncCallback<List<UserDTO>> callback1 = new AsyncCallback<List<UserDTO>>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            MaterialToast.fireToast("Error! " + caught.getMessage());
                        }

                        @Override
                        public void onSuccess(List<UserDTO> users) {
                            for (UserDTO u : users) {
                                for (ChatDTO c : u.getChatList()) {
                                    if (c.equals(chat)) {
                                        c.getMessages().add(message);
                                        AsyncCallback<UserDTO> callbackU = new AsyncCallback<UserDTO>() {
                                            @Override
                                            public void onFailure(Throwable caught) {
                                                MaterialToast.fireToast("Error! " + caught.getMessage());
                                            }

                                            @Override
                                            public void onSuccess(UserDTO user) {
                                            }
                                        };

                                        userSvc.saveUser(u, callbackU);
                                    }

                                }
                            }
                        }
                    };
                    loadMessages(window, chat, user);
                    window.add(textArea);
                    window.add(sendButton);
                    textArea.clear();
                    userSvc.getAllUser(callback1);
                }
            });

            window.open();

        });

        cardContent.add(cardTitle);
        cardContent.add(labelDescritpion);

        cardAction.add(editLink);

        card.add(cardContent);
        card.add(cardAction);


        return card;
    }

    @Override
    public void setContents(List<ChatDTO> contents) {
        int colCount = 1;

        MaterialRow row = null;

        htmlPanel.clear();

        for (ChatDTO chat : contents) {
            if (chat.isAccepted()) {
                MaterialCard card = createCard(chat);


                if (colCount == 1) {
                    row = new MaterialRow();
                    htmlPanel.add(row);
                    ++colCount;
                    if (colCount >= 4) {
                        colCount = 1;
                    }
                }

                MaterialColumn col = new MaterialColumn();
                col.setGrid("l4");
                row.add(col);

                col.add(card);
            }
        }
    }


    public void loadMessages(MaterialWindow window, ChatDTO chat, UserDTO user) {
        window.clear();

        for (MessageDTO dto : chat.getMessages()) {

            MaterialCard massageCard = new MaterialCard();
            MaterialLabel userLabel = new MaterialLabel();
            MaterialLabel dateLabel = new MaterialLabel();
            MaterialLabel message = new MaterialLabel();
            message.setFontSize("1.2em");
            dateLabel.setFontSize("0.5em");
            userLabel.setText(dto.getUser());
            dateLabel.setText(dto.getDate().toString());
            message.setText(dto.getText());
            massageCard.add(userLabel);
            massageCard.add(dateLabel);
            massageCard.add(message);
            if (userLabel.getText().equals(user.getName().getFirstName())) {
                massageCard.setBackgroundColor(Color.GREEN_DARKEN_1);
            }
            window.add(massageCard);

        }

    }

}


