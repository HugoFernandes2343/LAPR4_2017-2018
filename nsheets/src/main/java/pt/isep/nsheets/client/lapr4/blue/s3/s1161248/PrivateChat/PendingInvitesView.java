package pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.CheckBoxType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.services.ChatDTO;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

import java.util.ArrayList;
import java.util.List;

public class PendingInvitesView {


    private MaterialPanel invitesPanel;

    public PendingInvitesView(UserDTO currentUser, PrivateChatView mainPage) {

        MaterialWindow window = new MaterialWindow();
        window.setPadding(32);
        window.setHeight("300px");
        window.setWidth("300px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Pending Invites");
        MaterialWindow.setOverlay(true);

        List<MaterialCheckBox> checkList = new ArrayList<>();


        invitesPanel = setInvites(currentUser, checkList);
        window.add(invitesPanel);

        MaterialPanel p2 = new MaterialPanel();
        MaterialButton accept = new MaterialButton("Accept");
        MaterialButton refuse = new MaterialButton("Refuse");
        p2.add(accept);
        p2.add(refuse);
        window.add(p2);
        window.open();

        refuse.addClickHandler(clickEvent -> {

            UsersServiceAsync userSvc = GWT.create(UsersService.class);
            // Set up the callback object.
            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(UserDTO user) {

                }
            };

            for (MaterialCheckBox box : checkList) {
                if (box.getValue()) {
                    currentUser.getChatList().remove(currentUser.getChatByName(box.getText()));
                    userSvc.saveUser(currentUser, callback);
                }
            }
            window.close();

        });

        accept.addClickHandler(clickEvent -> {

            UsersServiceAsync userSvc = GWT.create(UsersService.class);
            // Set up the callback object.
            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(UserDTO user) {

                }
            };

            for (MaterialCheckBox box : checkList) {
                if (box.getValue()) {
                    currentUser.getChatByName(box.getText()).setAccepted(true);
                    userSvc.saveUser(currentUser, callback);
                }
            }
            mainPage.setContents(currentUser.getChatList());
            window.close();
        });
    }


    private MaterialPanel setInvites(UserDTO currentUser, List<MaterialCheckBox> checkList) {
        MaterialPanel panel = new MaterialPanel();
        for (ChatDTO chat : currentUser.getChatList()) {
            if (!chat.isAccepted()) {
                MaterialCheckBox chatBox = new MaterialCheckBox();
                chatBox.setText(chat.getName());
                checkList.add(chatBox);
                panel.add(chatBox);
            }
        }
        return panel;
    }
}
