package pt.isep.nsheets.client.lpar4.green.s3.s1160570.notes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardAction;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRow;
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

        HTMLPanel getHtmlPanel();

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
                        MaterialToast.fireToast("Error Note");
                    }

                    @Override
                    public void onSuccess(NoteDTO result) {
                        refresh();
                    }
                };
                NoteDTO noteDTO = new NoteDTO(CurrentUser.getCurrentUser(), title.getText(), text.getText());
                noteServiceAsync.addNote(noteDTO, callback);
                window.close();
            });
        });
    }

    public void refresh() {
        NoteServiceAsync noteServiceAsync = GWT.create(NoteService.class);

        AsyncCallback<ArrayList<NoteDTO>> callback1 = new AsyncCallback<ArrayList<NoteDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error list note");
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
        saveButton = new MaterialButton("Create Note");
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

    private void setContents(ArrayList<NoteDTO> contents) {
        int colCount = 1;

        MaterialRow row = null;

        getView().getHtmlPanel().clear();

        for (NoteDTO note : contents) {
            MaterialCard card = createCard(note);

            if (colCount == 1) {
                row = new MaterialRow();
                getView().getHtmlPanel().add(row);
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

    public MaterialCard createCard(NoteDTO note) {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_1);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialCardAction cardAction = new MaterialCardAction();

        MaterialCardTitle cardTitle = new MaterialCardTitle();
        cardTitle.setText(note.getTitle());

        MaterialLabel date = new MaterialLabel();
        date.setText("Date:" + note.getDate().toString());

        MaterialLink editLink = new MaterialLink();
        editLink.setText("Edit");
        editLink.setIconType(IconType.EDIT);
        editLink.setIconColor(Color.INDIGO);
        editLink.setTextColor(Color.WHITE);
        String oldTitle = note.getTitle();
        editLink.addClickHandler((event) -> {
            MaterialWindow window = createWindow();
            window.open();

            title.setText(note.getTitle());
            text.setText(note.getText());
            saveButton.setText("Edit Note");
            saveButton.addClickHandler((event1) -> {

                NoteServiceAsync noteServiceAsync = GWT.create(NoteService.class);

                AsyncCallback<NoteDTO> callback1 = new AsyncCallback<NoteDTO>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error Edit Note");
                    }

                    @Override
                    public void onSuccess(NoteDTO result) {
                        refresh();
                    }
                };

                noteServiceAsync.editNote(title.getText(), text.getText(), oldTitle, callback1);
                window.close();
            });
        });

        MaterialLink deleteLink = new MaterialLink();
        deleteLink.setText("Delete");
        deleteLink.setIconType(IconType.DELETE);
        deleteLink.setIconColor(Color.GREY);
        deleteLink.setTextColor(Color.WHITE);
        deleteLink.addClickHandler(event -> {
            NoteServiceAsync noteServiceAsync = GWT.create(NoteService.class);

            AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error deleting Task ");
                }

                @Override
                public void onSuccess(NoteDTO result) {
                    MaterialToast.fireToast(note.getTitle() + " deleted");
                    card.setVisible(false);
                }

            };

            noteServiceAsync.deleteNote(note, callback);
        });

        cardContent.add(cardTitle);
        cardContent.add(date);

        cardAction.add(editLink);
        cardAction.add(deleteLink);

        card.add(cardContent);
        card.add(cardAction);

        return card;

    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Notes", "User Notes", "", "", this);
        refresh();
    }
}
