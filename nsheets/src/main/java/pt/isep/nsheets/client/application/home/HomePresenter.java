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

import com.ibm.icu.util.Calendar;
import gwt.material.design.client.ui.MaterialToast;

import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialLabel;
import org.h2.message.DbException;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.workbook.SelectedWorkbookController;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.WorkbookService;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void setContents(ArrayList<Workbook> contents);

        void addClickHandler(ClickHandler ch);
        
        void renameClickHandler(ClickHandler ch);
        
        void deleteClickHandler(ClickHandler ch);
        
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
        
        this.view.renameClickHandler((ClickEvent event) -> {
            MaterialToast.fireToast("rename");
//            Workbook w = SelectedWorkbookController.getActualWorkbook();
//            w.setName();
            getView().getWorkbookTitle().setText("novo");
        });
        
        this.view.deleteClickHandler((ClickEvent event) -> {
            MaterialToast.fireToast("delete");
        });

        this.view.addClickHandler((ClickEvent event) -> {

            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

            AsyncCallback<Workbook> callback = new AsyncCallback<Workbook>() {
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Default name already in use! "+ caught.getMessage());
                }

                public void onSuccess(Workbook result) {
                    refreshView();
                }
            };


            Spreadsheet temp = null;
            Workbook wb = new Workbook("New Workbook ", "description of workbook", temp);
            wb.setNewWb(true);
            workbooksSvc.addWorkbook(wb, callback);

        });
    }

    private void refreshView() {
        WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<Workbook>> callback = new AsyncCallback<ArrayList<Workbook>>() {
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error "+caught.getMessage());
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
