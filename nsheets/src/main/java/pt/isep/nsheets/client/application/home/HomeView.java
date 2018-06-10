package pt.isep.nsheets.client.application.home;

import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;

import gwt.material.design.client.ui.*;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.DeleteWorkbookController;
import pt.isep.nsheets.server.services.WorkbooksServiceImpl;
import pt.isep.nsheets.shared.services.*;

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
    MaterialButton newWorkbookButtonPublic;

    @UiField
    MaterialButton newWorkbookButtonPrivate;

    @UiField
    MaterialListBox showAllWb;

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

    private MaterialCard createCard(WorkbookDescriptionDTO wb) {
        MaterialCard card = new MaterialCard();

        MaterialCardContent cardContent = new MaterialCardContent();

        MaterialCardTitle cardTitle = new MaterialCardTitle();

        MaterialLabel label = new MaterialLabel();

        MaterialCardAction cardAction = new MaterialCardAction();

        MaterialLink renameLink = new MaterialLink();
        MaterialLink deleteLink = new MaterialLink();
        MaterialLink addSpreadsheetLink = new MaterialLink();

        if (wb.getUserMail().equalsIgnoreCase("")) {
            card.setBackgroundColor(Color.BLUE_DARKEN_1);
            cardTitle.setIconType(IconType.INSERT_DRIVE_FILE);
        } else {
            card.setBackgroundColor(Color.LIGHT_GREEN_ACCENT_4);
            cardTitle.setIconType(IconType.LOCK);
        }

        cardContent.setTextColor(Color.WHITE);

        cardTitle.setText(wb.getName());
        cardTitle.setIconPosition(IconPosition.RIGHT);

        label.setText(wb.getDescription());
        renameLink.setText("Rename");
        renameLink.setIconType(IconType.EDIT);
        renameLink.setIconColor(Color.INDIGO);
        renameLink.setTextColor(Color.WHITE);
        renameLink.addClickHandler(event -> {
//            MaterialToast.fireToast("rename " + wb.getName());
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
            AsyncCallback callback = new AsyncCallback() {

                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error deleting " + caught.getMessage());
                }

                @Override
                public void onSuccess(Object result) {
                    MaterialToast.fireToast("test" + event.toString());
                }
            };

            workbooksSvc.deleteWorkbook(wb, callback);
        });

        deleteLink.setText("Delete");
        deleteLink.setIconType(IconType.DELETE);
        deleteLink.setIconColor(Color.GREY);
        deleteLink.setTextColor(Color.WHITE);
        deleteLink.addClickHandler(event -> {
            WorkbooksServiceAsync async = GWT.create(WorkbooksService.class);
            AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error deleting workbook...");
                }

                @Override
                public void onSuccess(Boolean result) {
                    MaterialToast.fireToast("Success deleting workbook...");
                    card.setVisible(false);
                }
            };
            
            async.deleteWorkbook(wb, callback);
        });

        addSpreadsheetLink.setText("Add Spreadsheet");
        addSpreadsheetLink.setIconType(IconType.ADD);
        addSpreadsheetLink.setIconColor(Color.GREEN);
        addSpreadsheetLink.setTextColor(Color.WHITE);
        addSpreadsheetLink.addClickHandler(event2 -> {

            MaterialToast.fireToast("Spreadsheet Added to " + wb.getName());
        });

        cardContent.add(cardTitle);
        cardContent.add(label);

        cardAction.add(renameLink);
        cardAction.add(deleteLink);
        cardAction.add(addSpreadsheetLink);

        card.add(cardContent);
        card.add(cardAction);

        return card;

    }

    @Override
    public void setContents(ArrayList<WorkbookDescriptionDTO> contents) {
        int colCount = 1;

        MaterialRow row = null;

        htmlPanel.clear();

        for (WorkbookDescriptionDTO wb : contents) {

            if ((wb.getUserMail().equals("") && CurrentUser.isShowAll()) || (CurrentUser.isIsLoggedIn() && wb.getUserMail().equalsIgnoreCase(CurrentUser.getCurrentUser().getEmail().getEmail()))) {
                MaterialCard card = createCard(wb);

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

    @Override
    public void addClickHandlerPublic(ClickHandler ch) {
        newWorkbookButtonPublic.addClickHandler(ch);
    }

    @Override
    public void addClickHandlerPrivate(ClickHandler ch) {
        newWorkbookButtonPrivate.addClickHandler(ch);
    }

    @Override
    public void addEventChangeHandler(ValueChangeHandler<String> vc) {
        showAllWb.addValueChangeHandler(vc);
    }

    @Override
    public void addEventChangeSearch(ValueChangeHandler<String> vc) {
        txtSearch.addValueChangeHandler(vc);
    }

    @Override
    public void addSearchClose(CloseHandler<String> ch) {
        txtSearch.addCloseHandler(ch);
    }

    @UiHandler("btnSearch")
    void onSearch(ClickEvent e) {
        txtSearch.open();
    }

}
