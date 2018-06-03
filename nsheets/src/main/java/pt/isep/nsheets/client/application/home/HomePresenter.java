package pt.isep.nsheets.client.application.home;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.InvocationException;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import gwt.material.design.client.ui.MaterialToast;

import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import org.h2.message.DbException;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.workbook.SelectedWorkbookController;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void setContents(ArrayList<Workbook> contents);

        void addClickHandler(ClickHandler ch);
    }

    @NameToken(NameTokens.home)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.addClickHandler((ClickEvent event) -> {

            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

            AsyncCallback<Workbook> callback = new AsyncCallback<Workbook>() {
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error teste!");
//                }

                public void onFailure(Throwable caught) {
                    // Convenient way to find out which exception was thrown.
                    //MaterialToast.fireToast("Error teste!");
                    try {
                        throw caught;
                    } catch (IncompatibleRemoteServiceException e) {
                        // this client is not compatible with the server; cleanup and refresh the browser
                        MaterialToast.fireToast("this client is not compatible with the server; cleanup and refresh the browser");
                    } catch (InvocationException e) {
                        // the call didn't complete cleanly
                        MaterialToast.fireToast("the call didn't complete cleanly");
                    } catch (Throwable e) {
                        // last resort -- a very unexpected exception
                        MaterialToast.fireToast("last resort -- a very unexpected exception");
                    }
                }

                public void onSuccess(Workbook result) {
                    refreshView();
                }
            };

            Workbook wb = SelectedWorkbookController.getActualWorkbook();
            workbooksSvc.addWorkbook(wb, callback);

//            // Set up the callback object.
//            AsyncCallback<WorkbookDescriptionDTO> callback = new AsyncCallback<WorkbookDescriptionDTO>() {
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error!");
//                }
//
//                public void onSuccess(WorkbookDescriptionDTO result) {
//
//                    refreshView();
//                }
//            };
//
//            WorkbookDescriptionDTO wdDto = new WorkbookDescriptionDTO("WorkbookDescription 123",
//                    "New WorkbookDescription 123 Description");
//            workbooksSvc.addWorkbookDescription(wdDto, callback);
        });
    }

    private void refreshView() {
        WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<Workbook>> callback = new AsyncCallback<ArrayList<Workbook>>() {
            public void onFailure(Throwable caught) {
                // TODO: Do something with errors.
            }

            public void onSuccess(ArrayList<Workbook> result) {
                view.setContents(result);
            }
        };

        workbooksSvc.getWorkbooks(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Home", "The most recent Workbooks", "", "", this);

        refreshView();
    }
}
