package pt.isep.nsheets.client.lpar4.green.s3.s1160570.notes;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import javax.inject.Inject;

import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;

class NoteView extends ViewImpl implements NotePresenter.MyView {

    @UiField
    MaterialButton newNoteButton;

    @UiField
    HTMLPanel htmlPanel;

    interface Binder extends UiBinder<Widget, NoteView> {
    }

    @Inject
    NoteView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        newNoteButton.addClickHandler(ch);
    }

    @Override
    public HTMLPanel getHtmlPanel() {
        return htmlPanel;
    }

}
