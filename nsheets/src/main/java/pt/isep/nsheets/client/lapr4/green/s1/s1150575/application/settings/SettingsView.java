package pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.settings;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

class SettingsView extends ViewImpl implements SettingsPresenter.MyView {

    @UiField
    MaterialTextBox txtXMLWorkbook;

    @UiField
    MaterialTextBox txtXMLWorksheet;

    @UiField
    MaterialTextBox txtXMLCell;

    @UiField
    MaterialButton btnXMLApply;

    @Override
    public MaterialTextBox getWorkbookBox() {
        return txtXMLWorkbook;
    }

    @Override
    public MaterialTextBox getWorksheetBox() {
        return txtXMLWorksheet;
    }

    @Override
    public MaterialTextBox getCellBox() {
        return txtXMLCell;
    }

    @Override
    public MaterialButton getApplyButton() {
        return btnXMLApply;
    }

    interface Binder extends UiBinder<Widget, SettingsView> {
    }

    @Inject
    SettingsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
