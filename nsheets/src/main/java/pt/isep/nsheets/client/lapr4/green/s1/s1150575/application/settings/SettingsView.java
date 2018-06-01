package pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.settings;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

class SettingsView extends ViewImpl implements SettingsPresenter.MyView {

    @UiField
    MaterialButton extensionManagerButton;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MaterialButton getExtensionManagerButton() {
        return this.extensionManagerButton;
    }

    interface Binder extends UiBinder<Widget, SettingsView> {
	}

	@Inject
	SettingsView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}