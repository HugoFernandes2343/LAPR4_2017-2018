package pt.isep.nsheets.client.lapr4.red.s2.s1161569;


import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.application.workbook.SheetWidgetColumn;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.MessageDTO;

import java.util.ArrayList;
import java.util.List;

class ChatView extends ViewImpl implements ChatPresenter.MyView {

    @UiField
    MaterialButton publishButton;

    @UiField
    MaterialButton refreshButton;

    @UiField
    MaterialTextArea textField;

    @UiField
    HTMLPanel chatPanel;

    @Override
    public void setContents(ArrayList<MessageDTO> contents) {
        chatPanel.clear();
        for(MessageDTO dto:contents){
            MaterialCard mat=new MaterialCard();
            MaterialLabel user=new MaterialLabel();
            MaterialLabel date=new MaterialLabel();
            MaterialLabel text=new MaterialLabel();
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

    @Override
    public void addClickHandler(ClickHandler ch) {
        publishButton.addClickHandler(ch);
    }

    @Override
    public void addClickHandlerReload(ClickHandler ch) {
        refreshButton.addClickHandler(ch);
    }

    @Override
    public MaterialTextArea getFirstBox() {
        return this.textField;
    }


    interface Binder extends UiBinder<Widget, ChatView> {
    }

    @Inject
    ChatView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}