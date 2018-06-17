package pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.services.ChatDTO;
import pt.isep.nsheets.shared.services.UserDTO;

public class ChatView extends ViewImpl {


    public ChatView(UserDTO currentUser, String currentChat) {



        MaterialWindow window = new MaterialWindow();
        window.setPadding(32);
        window.setHeight("300px");
        window.setWidth("300px");
        window.setTextAlign(TextAlign.LEFT);
        MaterialToast.fireToast("aquele boas");
        MaterialToast.fireToast("FDP do nome ");//+currentChat.getName());
        window.setTitle(currentChat);
        MaterialToast.fireToast("boas 1");

        MaterialWindow.setOverlay(true);


        HTMLPanel mainPanel = new HTMLPanel("");
        window.add(mainPanel);
        MaterialRow row = new MaterialRow();
        MaterialLabel label = new MaterialLabel("Text Area");
        row.add(label);
        MaterialButton sendButton = new MaterialButton("Send");
        row.add(sendButton);
        window.add(row);
        MaterialToast.fireToast("boas");
        window.open();
    }
}
