package pt.isep.nsheets.client.application.home;

import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

class HomeView extends ViewImpl implements HomePresenter.MyView {

    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialSearch txtSearch;

    @UiField
    MaterialNavBar navBar, navBarSearch;

    @UiField
    MaterialButton newWorkbookButton;

    @UiField
    MaterialLink renameLink, deleteLink;

    @UiField
    MaterialCardTitle workbookTitle;

    @UiField
    MaterialLabel workbookDescription;

    @UiField
    MaterialCard card;


    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        // add open handler
        txtSearch.addOpenHandler(openEvent -> {
            navBar.setVisible(false);
            navBarSearch.setVisible(true);
        });

        // Add Close Handler
        txtSearch.addCloseHandler(event -> {
            navBar.setVisible(true);
            navBarSearch.setVisible(false);
        });
    }

    private MaterialCard createCard(Workbook wb) {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_1);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialCardTitle cardTitle = new MaterialCardTitle();
        cardTitle.setText(wb.getName());
        cardTitle.setIconType(IconType.INSERT_DRIVE_FILE);
        cardTitle.setIconPosition(IconPosition.RIGHT);

        MaterialLabel label = new MaterialLabel();
        label.setText(wb.getDescription());

        MaterialCardAction cardAction = new MaterialCardAction();

        MaterialLink renameLink = new MaterialLink();
        renameLink.setText("Rename");
        renameLink.setIconType(IconType.EDIT);
        renameLink.setIconColor(Color.INDIGO);
        renameLink.setTextColor(Color.WHITE);
        renameLink.addClickHandler(event -> {
            MaterialToast.fireToast("rename "+wb.getName());
        });

        MaterialLink deleteLink = new MaterialLink();
        deleteLink.setText("Delete");
        deleteLink.setIconType(IconType.DELETE);
        deleteLink.setIconColor(Color.GREY);
        deleteLink.setTextColor(Color.WHITE);
        deleteLink.addClickHandler(event -> {
            MaterialToast.fireToast("delete "+wb.getName());
        });

        cardContent.add(cardTitle);
        cardContent.add(label);

        cardAction.add(renameLink);
        cardAction.add(deleteLink);

        card.add(cardContent);
        card.add(cardAction);

        return card;
    }

    @Override
    public void setContents(ArrayList<Workbook> contents) {
        int colCount = 1;

        MaterialRow row = null;

        htmlPanel.clear();

        for (Workbook wb : contents) {
            MaterialCard card = createCard(wb);

//            workbookTitle.setText(wb.getName());
//            workbookDescription.setText(wb.getDescription());

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

    @Override
    public void addClickHandler(ClickHandler ch) {
        // TODO Auto-generated method stub

        newWorkbookButton.addClickHandler(ch);
    }

//    @Override
//    public void renameClickHandler(ClickHandler ch) {
//        addClickHandler(ch);
//    }
//
//    @Override
//    public void deleteClickHandler(ClickHandler ch) {
//        deleteLink.addClickHandler(ch);
//    }

    @UiHandler("btnSearch")
    void onSearch(ClickEvent e) {
        txtSearch.open();
    }

    @Override
    public MaterialCardTitle getWorkbookTitle() {
        return workbookTitle;
    }

    @Override
    public MaterialLabel getWorkbookDescription() {
        return workbookDescription;
    }
}
