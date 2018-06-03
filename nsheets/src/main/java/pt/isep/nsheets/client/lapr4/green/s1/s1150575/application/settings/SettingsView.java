package pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.settings;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;

class SettingsView extends ViewImpl implements SettingsPresenter.MyView {

    @UiField
    MaterialButton extensionManagerButton;

    @UiField
    MaterialButton btnCSVApply;

    @UiField
    MaterialRadioButton comma;

    @UiField
    MaterialRadioButton pointComma;

    @UiField
    MaterialRadioButton barra;

    @UiField
    MaterialRadioButton point;

    @Override
    public void addClickHandlerExtensionManager(ClickHandler ch) {
        extensionManagerButton.addClickHandler(ch);
    }

    @Override
    public MaterialTextBox getWorkbookBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MaterialTextBox getWorksheetBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MaterialTextBox getCellBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MaterialButton getApplyButton() {
        return btnCSVApply;
    }

    @Override
    public MaterialButton getExtensionManagerButton() {
        return this.extensionManagerButton;
    }

    @Override
    public void addClickHandlerApplyCSV(ClickHandler ch) {
        btnCSVApply.addClickHandler(ch);
    }

    interface Binder extends UiBinder<Widget, SettingsView> {
	}

    @Override
    public MaterialRadioButton getComma() {
        return comma;
    }

    @Override
    public MaterialRadioButton getPointComma() {
        return pointComma;
    }

    @Override
    public MaterialRadioButton getBarra() {
        return barra;
    }

    @Override
    public MaterialRadioButton getPoint() {
        return point;
    }


    @Inject
    SettingsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
