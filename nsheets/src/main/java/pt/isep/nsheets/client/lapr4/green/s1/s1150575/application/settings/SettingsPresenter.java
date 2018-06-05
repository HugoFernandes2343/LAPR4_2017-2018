package pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.settings;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.TagsService;
import pt.isep.nsheets.shared.services.TagsServiceAsync;
import pt.isep.nsheets.shared.services.TagsDTO;

public class SettingsPresenter extends Presenter<SettingsPresenter.MyView, SettingsPresenter.MyProxy> {

    interface MyView extends View {

        void addClickHandlerExtensionManager(ClickHandler ch);

        public MaterialTextBox getWorkbookBox();

        public MaterialTextBox getWorksheetBox();

        public MaterialTextBox getCellBox();

        public MaterialButton getApplyButton();

        //1160777
        public MaterialButton getExtensionManagerButton();

        //1160696
        public MaterialRadioButton getComma();

        public MaterialRadioButton getPointComma();

        public MaterialRadioButton getBarra();

        public MaterialRadioButton getPoint();

        void addClickHandlerApplyCSV(ClickHandler ch);
    }

    private SettingsPresenter.MyView view;
    private PlaceManager placeManager;

    @NameToken(NameTokens.settings)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<SettingsPresenter> {
    }

    @Inject
    SettingsPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        this.view = view;
        this.placeManager = placeManager;

    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Settings", "", "", "", this);

        getView().getApplyButton().addClickHandler((ClickEvent event) -> {

            String tagWorkbook = getView().getWorkbookBox().getValue();
            String tagWorksheet = getView().getWorksheetBox().getValue();
            String tagCells = getView().getCellBox().getValue();

            if (tagWorkbook.equals("") && tagWorksheet.equals("")
                    && tagCells.equals("")) {
                MaterialToast.fireToast("Please insert all the tags you want to use");
            } else if (tagWorkbook.equals("")) {
                MaterialToast.fireToast("Workbook tag empty");
            } else if (tagWorksheet.equals("")) {
                MaterialToast.fireToast("Worksheet tag empty");
            } else if (tagCells.equals("")) {
                MaterialToast.fireToast("Cell tag empty");
            } else {

                MaterialToast.fireToast("Workbook tag: "+tagWorkbook);
                MaterialToast.fireToast("\nWorksheet tag: "+tagWorksheet);
                MaterialToast.fireToast("Cell tag: "+tagCells);
//                TagsServiceAsync tagsSvc = GWT.create(TagsService.class);
//
//                AsyncCallback<TagsDTO> callback = new AsyncCallback<TagsDTO>() {
//                    @Override
//                    public void onFailure(Throwable caught) {
//                        MaterialToast.fireToast("Save Insucess");
//                        getView().getWorkbookBox().setText("");
//                        getView().getWorksheetBox().setText("");
//                        getView().getCellBox().setText("");
//                    }
//
//                    @Override
//                    public void onSuccess(TagsDTO result) {
//                        MaterialToast.fireToast("Sucess");
//                    }
//
////                        Tags tags = new Tags(tagWorkbook, tagWorksheet, tagCells);
//                };
//                    Export.setTags(dto);
//                    Export.setWorksheetTag(tagWorksheet);
//                    Export.setCellTag(tagCells);
//                tagsSvc.addTags(getView().getWorkbookBox().getText(), getView().getWorkbookBox().getText(), getView().getWorkbookBox().getText(), callback);
            }
        }
        );
        /*
         * @author <1160777>Marco Carneiro</1160777>
         */
        this.view.addClickHandlerExtensionManager(event
                -> {
            PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(NameTokens.getExtensionManager()).build();
            placeManager.revealPlace(placeRequest);
        }
        );

        this.view.addClickHandlerApplyCSV(event
                -> {

            MaterialToast.fireToast("Failure");

        }
        );
    }
}
