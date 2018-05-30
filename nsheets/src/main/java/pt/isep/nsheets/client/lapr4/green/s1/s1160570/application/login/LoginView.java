package pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class LoginView extends ViewImpl implements LoginPresenter.MyView {

	interface Binder extends UiBinder<Widget, LoginView> {
	}

	@Inject
	LoginView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}