package pt.isep.nsheets.client.application.menu;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import pt.isep.nsheets.client.event.ContentPushEvent;

import com.gwtplatform.mvp.client.HasUiHandlers;
import pt.isep.nsheets.client.application.CurrentUser;

public class MenuPresenter extends PresenterWidget<MenuPresenter.MyView> implements MenuUiHandlers {

	interface MyView extends View, HasUiHandlers<MenuUiHandlers> {
            void addClickHandler(ClickHandler ch);
	}

	@Inject
	MenuPresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);

		getView().setUiHandlers(this);
                
                    getView().addClickHandler((event) -> {
                   
                        CurrentUser.logout();
               });
                
	}

	protected void onBind() {
		super.onBind();
	}

	@Override
	public void setContentPush() {
		ContentPushEvent.fire(this);
	}
}