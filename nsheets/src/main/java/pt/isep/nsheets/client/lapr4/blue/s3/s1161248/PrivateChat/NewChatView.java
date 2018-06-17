package pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.server.lapr4.blue.s3.ipc.s1161248.PrivateChat.domain.Chat;
import pt.isep.nsheets.shared.services.*;

import java.util.ArrayList;
import java.util.List;

public class NewChatView extends Composite {

    @UiField
    MaterialTextBox chatName;

    @UiField
    MaterialButton cancelButton;

    @UiField
    MaterialButton createButton;

    @UiField
    MaterialButton addMember;

    @UiField
    MaterialTextBox email;


    private static NewChatViewUiBinder uiBinder = GWT.create(NewChatViewUiBinder.class);

    interface NewChatViewUiBinder extends UiBinder<Widget, NewChatView> {
    }

    public NewChatView(UserDTO currentUser) {

        List<String> emails = new ArrayList<>();
        initWidget(uiBinder.createAndBindUi(this));
        MaterialWindow window = new MaterialWindow();
        window.setPadding(32);
        window.setHeight("600px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Create new Chat");
        MaterialWindow.setOverlay(true);
        MaterialPanel p1 = new MaterialPanel();
        MaterialLabel chatNameL = new MaterialLabel("Insert Chat's name");
        p1.add(chatNameL);
        p1.add(chatName);
        window.add(p1);
        MaterialPanel p2 = new MaterialPanel();
        MaterialLabel addEmails = new MaterialLabel("Add member email");
        p2.add(addEmails);
        p2.add(email);
        p2.add(addMember);
        window.add(p2);
        MaterialPanel p3 = new MaterialPanel();
        p3.add(this.createButton);
        p3.add(this.cancelButton);
        window.add(p3);
        window.open();

        cancelButton.addClickHandler(clickEvent -> {
            window.close();
        });

        addMember.addClickHandler((clickEvent -> {
            if (email.getText().isEmpty()) {
                MaterialToast.fireToast("Please Insert an email");
            } else {
                MaterialToast.fireToast("Email added");
                emails.add(email.getText());
                email.clear();
                MaterialToast.fireToast(emails.get(0));
            }
        }));


        createButton.addClickHandler(clickEvent -> {

            //criar o chat e insiri-lo no user que o criou
            ChatDTO newChat = new ChatDTO(chatName.getText(), new ArrayList<>(), true);
            currentUser.addChat(newChat);


            UsersServiceAsync userSvc = GWT.create(UsersService.class);
            // Set up the callback object.
            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(UserDTO user) {
                    MaterialToast.fireToast("Chat Created", "rounded");

                }
            };

            userSvc.saveUser(currentUser, callback);


            //mudar para falso os restantes pois eles ainda não aceitaram o pedido
            ChatDTO newChat1 = new ChatDTO(chatName.getText(), new ArrayList<>(), false);

            AsyncCallback<UserDTO> callback1 = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(UserDTO user) {
                    MaterialToast.fireToast("User: "+user.getName().getFirstName(), "rounded");
                    user.addChat(newChat1);

                    AsyncCallback<UserDTO> callback3 = new AsyncCallback<UserDTO>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            MaterialToast.fireToast("Error! " + caught.getMessage());
                        }

                        @Override
                        public void onSuccess(UserDTO user1) {
                            MaterialToast.fireToast("Enviado para amigo", "rounded");

                        }
                    };

                    userSvc.saveUser(user, callback3);
                }
            };

            for (String email : emails) {
                userSvc.getUserByEmail(email, callback1);
            }
            //guardar o user


            //criar uma tabela com pending invites
            //criar chat e a medida que os users vão aceitando os invites seram inseridos no chat


        });
    }
}
