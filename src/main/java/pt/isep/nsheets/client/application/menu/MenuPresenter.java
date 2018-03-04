package pt.isep.nsheets.client.application.menu;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import pt.isep.nsheets.client.event.ContentPushEvent;

import com.gwtplatform.mvp.client.HasUiHandlers;
//import gwt.material.design.demo.client.event.ContentPushEvent;

public class MenuPresenter extends PresenterWidget<MenuPresenter.MyView> implements MenuUiHandlers {

	interface MyView extends View, HasUiHandlers<MenuUiHandlers> {
	}

	@Inject
	MenuPresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);

		getView().setUiHandlers(this);
	}

	protected void onBind() {
		super.onBind();
	}

	@Override
	public void setContentPush() {
		ContentPushEvent.fire(this);
	}
}