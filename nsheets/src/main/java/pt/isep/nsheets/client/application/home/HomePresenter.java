package pt.isep.nsheets.client.application.home;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import gwt.material.design.client.ui.MaterialToast;

import com.gwtplatform.mvp.client.annotations.NameToken;
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

        void setContents(ArrayList<WorkbookDescriptionDTO> contents);

        void addClickHandlerPublic(ClickHandler ch);

        void addClickHandlerPrivate(ClickHandler ch);

        void addEventChangeHandler(ValueChangeHandler<String> vc);

        void addEventChangeSearch(ValueChangeHandler<String> vc);

        void addSearchClose(CloseHandler<String> ch);

    }

    @NameToken(NameTokens.home)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.addEventChangeHandler((ValueChangeEvent<String> event) -> {
            if (event.getValue().equalsIgnoreCase("Show Private and Public Workbooks")) {
                CurrentUser.setShowAll(true);
            } else {
                CurrentUser.setShowAll(false);
                if (!CurrentUser.isIsLoggedIn()) {
                    MaterialToast.fireToast("Please login to view private workbooks");
                }
            }
            refreshView();
        });

        this.view.addClickHandlerPublic((ClickEvent event) -> {

            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

            // Set up the callback object.
            AsyncCallback<WorkbookDescriptionDTO> callback = new AsyncCallback<WorkbookDescriptionDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(WorkbookDescriptionDTO result) {
                    MaterialToast.fireToast("New Workbook Created...", "rounded");
                    
                    refreshView();
                }
            };

            String name = Window.prompt("Name of new Workbook:", "New Public Workbook " + nrWb++);
            String description = Window.prompt("Description of new Workbook:", "No Description");
            WorkbookDescriptionDTO wdDto = new WorkbookDescriptionDTO(name, description,"" );

            workbooksSvc.addWorkbookDescription(wdDto, callback);

        });

        this.view.addEventChangeSearch((ValueChangeEvent<String> event) -> {
            refreshViewSearch(event.getValue());
        });

        this.view.addSearchClose((CloseEvent<String> event) -> {
            refreshView();
        });

        this.view.addClickHandlerPrivate((ClickEvent event) -> {

            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

            AsyncCallback<WorkbookDescriptionDTO> callback = new AsyncCallback<WorkbookDescriptionDTO>() {
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error creating Workbook " + caught.getMessage());
                }

                public void onSuccess(WorkbookDescriptionDTO result) {
                    refreshView();
                }
            };

            Spreadsheet temp = null;
            if (CurrentUser.isIsLoggedIn()) {
                String name = Window.prompt("Name of new Private Workbook:", "New Private Workbook " + nrWb++);
                String description = Window.prompt("Description of new Workbook:", "No Description");

                WorkbookDescriptionDTO dDTO = new WorkbookDescriptionDTO(name, description, CurrentUser.getCurrentUser().getEmail().getEmail());
                workbooksSvc.addWorkbookDescription(dDTO, callback);

            } else {
                MaterialToast.fireToast("Please login First!");
            }

        });
    }

    private void refreshView() {
        WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<WorkbookDescriptionDTO>> callback = new AsyncCallback<ArrayList<WorkbookDescriptionDTO>>() {
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error " + caught.getMessage());
            }

            public void onSuccess(ArrayList<WorkbookDescriptionDTO> result) {
                nrWb = result.size();
                view.setContents(result);
            }
        };

        workbooksSvc.getWorkbooks(callback);
    }

    private void refreshViewSearch(String pattern) {
        WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<WorkbookDescriptionDTO>> callback = new AsyncCallback<ArrayList<WorkbookDescriptionDTO>>() {
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error " + caught.getMessage());
            }

            public void onSuccess(ArrayList<WorkbookDescriptionDTO> result) {
                nrWb = result.size();
                ArrayList<WorkbookDescriptionDTO> filter = new ArrayList<>();

                RegExp exp = RegExp.compile(pattern);

                for (WorkbookDescriptionDTO wb : result) {
                    if ( exp.test(wb.getName())|| exp.test(wb.getDescription()) || wb.getDescription().contains(pattern) || wb.getName().contains(pattern)) {
                        filter.add(wb);
                    }
                }
                view.setContents(filter);
            }
        };
        workbooksSvc.getWorkbooks(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

//        ----------------------------------------------------------

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

    @Override
    public MyView getView() {
        return view;
    }
}
