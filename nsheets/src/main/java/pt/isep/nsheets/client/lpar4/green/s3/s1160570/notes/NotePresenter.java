package pt.isep.nsheets.client.lpar4.green.s3.s1160570.notes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.NoteService;
import pt.isep.nsheets.shared.services.NoteServiceAsync;

public class NotePresenter extends Presenter<NotePresenter.MyView, NotePresenter.MyProxy> {

    private MaterialTextBox title;
    private MaterialTextArea text;
    private MaterialButton saveButton;

    interface MyView extends View {

        MaterialComboBox getComboBox();

        MaterialColumn getCards();

        void addClickHandler(ClickHandler ch);
    }

    @NameToken(NameTokens.notess)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<NotePresenter> {
    }

    @Inject
    NotePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().addClickHandler((event) -> {
            MaterialWindow window = createWindow();
            window.open();
            saveButton.addClickHandler((event2) -> {
                NoteServiceAsync noteServiceAsync = GWT.create(NoteService.class);

                AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error ");
                    }

                    @Override
                    public void onSuccess(NoteDTO result) {
                        MaterialToast.fireToast("Create Sucess");

                        refreshComboBox();
                    }
                };
                NoteDTO noteDTO = new NoteDTO(CurrentUser.getCurrentUser(), title.getText());
                noteServiceAsync.addNote(noteDTO, callback);

                window.close();
            });
        });
    }

    public void refreshComboBox() {
        NoteServiceAsync noteServiceAsync = GWT.create(NoteService.class);

        AsyncCallback<ArrayList<NoteDTO>> callback1 = new AsyncCallback<ArrayList<NoteDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error+1 ");
            }

            @Override
            public void onSuccess(ArrayList<NoteDTO> result) {
                setContents(result);
            }
        };

        noteServiceAsync.getNotes(CurrentUser.getCurrentUser(), callback1);
    }

    private MaterialWindow createWindow() {
        MaterialWindow window = new MaterialWindow("Task Editor");
        MaterialLabel lblTitle = new MaterialLabel("Title");
        MaterialLabel lblText = new MaterialLabel("Text");
        saveButton = new MaterialButton("Create");
        title = new MaterialTextBox();
        text = new MaterialTextArea();
        window.add(lblTitle);
        window.add(title);
        window.add(lblText);
        window.add(text);
        window.add(saveButton);

        title.setPaddingLeft(100);
        title.setPaddingRight(100);

        text.setPaddingLeft(100);
        text.setPaddingRight(100);

        lblText.setPaddingLeft(100);
        lblText.setPaddingRight(100);

        lblTitle.setPaddingLeft(100);
        lblTitle.setPaddingRight(100);
        lblTitle.setPaddingTop(50);

        saveButton.setFloat(Style.Float.RIGHT);
        saveButton.setMarginRight(150);
        saveButton.setMarginBottom(50);
        saveButton.setMarginTop(20);
        return window;
    }

    public void setContents(ArrayList<NoteDTO> contents) {

        getView().getComboBox().clear();

        for (NoteDTO noteDTO : contents) {
            getView().getComboBox().addItem(noteDTO.getTitle());
        }

    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Social Chat", "Trade ideas with the chat", "", "", this);
        refreshComboBox();
    }
}