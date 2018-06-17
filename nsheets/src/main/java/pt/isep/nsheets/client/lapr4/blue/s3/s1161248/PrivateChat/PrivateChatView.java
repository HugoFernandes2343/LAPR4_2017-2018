
package pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login.LoginModule;
import pt.isep.nsheets.shared.services.ChatDTO;
import pt.isep.nsheets.shared.services.MessageDTO;
import pt.isep.nsheets.shared.services.UserDTO;

import java.util.ArrayList;


public class PrivateChatView extends ViewImpl implements PrivateChatPresenter.MyView {


    @UiField
    MaterialLabel chatName;

    @UiField
    MaterialTextArea textField;

    @UiField
    MaterialButton sendButton;

    @UiField
    MaterialButton changeChat;

    @UiField
    MaterialButton newChat;

    @UiField
    MaterialButton invites;

    @UiField
    MaterialButton addFriends;

    @UiField
    HTMLPanel chatPanel;

    interface Binder extends UiBinder<Widget, PrivateChatView> {
    }

    @Inject
    PrivateChatView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        UserDTO user = CurrentUser.getCurrentUser();
        MaterialToast.fireToast("1");
        if (!user.getChatList().isEmpty()) {
            MaterialToast.fireToast("2");
            for (ChatDTO chat : user.getChatList()) {
                MaterialToast.fireToast("3");
                if (!chat.isAccepted()) {
                    MaterialToast.fireToast("4");
                    invites.setBackgroundColor(Color.RED);
                }
            }
        }
        newChat.addClickHandler(clickEvent -> {
            NewChatView newChat = new NewChatView(user);

        });

        invites.addClickHandler(clickEvent -> {
            PendingInvitesView pendingInvites = new PendingInvitesView(user);
        });

    }

    @Override
    protected void onAttach() {
        super.onAttach();
    }

    @Override
    public void setContents(ArrayList<MessageDTO> contents) {
        chatPanel.clear();
        for (MessageDTO dto : contents) {
            MaterialCard mat = new MaterialCard();
            MaterialLabel user = new MaterialLabel();
            MaterialLabel date = new MaterialLabel();
            MaterialLabel text = new MaterialLabel();
            text.setFontSize("1.2em");
            date.setFontSize("0.5em");
            user.setText(dto.getUser());
            date.setText(dto.getDate().toString());
            text.setText(dto.getText());
            mat.add(user);
            mat.add(date);
            mat.add(text);
            chatPanel.add(mat);
        }

    }

}
