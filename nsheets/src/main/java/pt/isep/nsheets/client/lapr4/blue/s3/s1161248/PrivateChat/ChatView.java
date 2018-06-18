package pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.services.UserDTO;

public class ChatView extends ViewImpl {


    public ChatView(UserDTO currentUser, String currentChat) {



        MaterialWindow window = new MaterialWindow();
        window.setPadding(32);
        window.setHeight("300px");
        window.setWidth("300px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle(currentChat);

        MaterialWindow.setOverlay(true);


        HTMLPanel mainPanel = new HTMLPanel("");
        window.add(mainPanel);
        MaterialRow row = new MaterialRow();
        MaterialLabel label = new MaterialLabel("Text Area");
        row.add(label);
        MaterialButton sendButton = new MaterialButton("Send");
        MaterialColumn col = new MaterialColumn();
        col.add(sendButton);
        MaterialRow rowButton = new MaterialRow();
        rowButton.add(col);
        col.setPaddingLeft(10);
        window.add(row);
        window.open();
    }
}
