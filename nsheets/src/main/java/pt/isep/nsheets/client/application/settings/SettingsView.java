package pt.isep.nsheets.client.application.settings;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

class SettingsView extends ViewImpl implements SettingsPresenter.MyView {

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
	interface Binder extends UiBinder<Widget, SettingsView> {
	}

	@Inject
	SettingsView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}