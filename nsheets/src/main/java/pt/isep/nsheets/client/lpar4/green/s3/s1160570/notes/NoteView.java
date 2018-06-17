package pt.isep.nsheets.client.lpar4.green.s3.s1160570.notes;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import javax.inject.Inject;

import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialColumn;

class NoteView extends ViewImpl implements NotePresenter.MyView {

    @UiField
    MaterialComboBox comboBox;

    @UiField
    MaterialColumn cards;

    @UiField
    MaterialButton newNoteButton;

    interface Binder extends UiBinder<Widget, NoteView> {
    }

    @Inject
    NoteView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public MaterialComboBox getComboBox() {
        return comboBox;
    }

    @Override
    public MaterialColumn getCards() {
        return cards;
    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        newNoteButton.addClickHandler(ch);
    }

}
