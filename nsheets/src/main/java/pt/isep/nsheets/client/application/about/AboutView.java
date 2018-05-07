package pt.isep.nsheets.client.application.about;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class AboutView extends ViewImpl implements AboutPresenter.MyView {
	interface Binder extends UiBinder<Widget, AboutView> {
	}

	@Inject
	AboutView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}