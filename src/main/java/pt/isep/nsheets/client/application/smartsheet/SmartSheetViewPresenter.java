package pt.isep.nsheets.client.application.smartsheet;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.place.NameTokens;

public class SmartSheetViewPresenter
		extends Presenter<SmartSheetViewPresenter.MyView, SmartSheetViewPresenter.MyProxy> {

	interface MyView extends View {
	}

	@NameToken(NameTokens.smartsheet)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<SmartSheetViewPresenter> {
	}

	@Inject
	SmartSheetViewPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
	}

}