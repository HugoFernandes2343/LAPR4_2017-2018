package pt.isep.nsheets.client.application.about;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class AboutView extends ViewImpl implements AboutPresenter.MyView {
	interface Binder extends UiBinder<Widget, AboutView> {
	}

	// @UiField
	// SimplePanel main;

	@UiField
	Label secondLabel;

	@Inject
	AboutView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	// @Override
	// public void setInSlot(Object slot, IsWidget content) {
	// if (slot == SecondPresenter.SLOT_Second) {
	// main.setWidget(content);
	// } else {
	// super.setInSlot(slot, content);
	// }
	// }

	public Label getSecondLabel() {
		return secondLabel;
	}
}