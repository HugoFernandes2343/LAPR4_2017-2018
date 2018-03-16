package pt.isep.nsheets.client.application.home;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class HomeView extends ViewImpl implements HomePresenter.MyView {

	interface Binder extends UiBinder<Widget, HomeView> {
	}

	@Inject
	HomeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}
}