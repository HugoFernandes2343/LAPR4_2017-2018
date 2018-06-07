package pt.isep.nsheets.client.application.home;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import gwt.material.design.client.ui.MaterialToast;

import com.gwtplatform.mvp.client.annotations.NameToken;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialLabel;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.*;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

    private MyView view;

    private int nrWb;

    interface MyView extends View {

        void setContents(ArrayList<Workbook> contents);

        void addClickHandlerPublic(ClickHandler ch);

        void addClickHandlerPrivate(ClickHandler ch);


        //        void renameClickHandler( ClickHandler ch);
//
//        void deleteClickHandler(ClickHandler ch);
        MaterialCardTitle getWorkbookTitle();

        MaterialLabel getWorkbookDescription();
    }

    @NameToken(NameTokens.home)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.addClickHandlerPublic((ClickEvent event) -> {

            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

            AsyncCallback<Workbook> callback = new AsyncCallback<Workbook>() {
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error creating Workbook " + caught.getMessage());
                }

                public void onSuccess(Workbook result) {
                    refreshView();
                }
            };

            Spreadsheet temp = null;
            Workbook wb = new Workbook("New Public Workbook " + nrWb++, "description of workbook", temp, "");
            wb.setNewWb(true);
            workbooksSvc.addWorkbook(wb, callback);


        });

        this.view.addClickHandlerPrivate((ClickEvent event) -> {

            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

            AsyncCallback<Workbook> callback = new AsyncCallback<Workbook>() {
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error creating Workbook " + caught.getMessage());
                }

                public void onSuccess(Workbook result) {
                    refreshView();
                }
            };

            Spreadsheet temp = null;
            if (CurrentUser.isIsLoggedIn()) {
                Workbook wb = new Workbook("New Private Workbook " + nrWb++, "description of workbook", temp, CurrentUser.getCurrentUser().getEmail().getEmail());
                wb.setNewWb(true);
                workbooksSvc.addWorkbook(wb, callback);
            } else {
                MaterialToast.fireToast("Please login First!");
            }

        });
    }

    private void refreshView() {
        WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<Workbook>> callback = new AsyncCallback<ArrayList<Workbook>>() {
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error " + caught.getMessage());
            }

            public void onSuccess(ArrayList<Workbook> result) {
                nrWb = result.size();
                view.setContents(result);
            }
        };

        workbooksSvc.getWorkbooks(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

//        --------------------------------------------------------

        EmailDTO m = new EmailDTO("mail@isep.pt");
        PasswordDTO p = new PasswordDTO("pass");
        NicknameDTO nn = new NicknameDTO("user");
        NameDTO n = new NameDTO("fn", "ln");
        UserDTO temp = new UserDTO(m, p, n, nn);

        CurrentUser.setCurrentUser(temp);
        CurrentUser.setIsLoggedIn(true);

//        ----------------------------------------------------------

        SetPageTitleEvent.fire("Home", "The most recent Workbooks", "", "", this);

        refreshView();
    }
}
