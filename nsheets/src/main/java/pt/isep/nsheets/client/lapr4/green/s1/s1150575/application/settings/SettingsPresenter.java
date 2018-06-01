package pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.settings;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

public class SettingsPresenter extends Presenter<SettingsPresenter.MyView, SettingsPresenter.MyProxy> {

    interface MyView extends View {

        public MaterialTextBox getWorkbookBox();

        public MaterialTextBox getWorksheetBox();

        public MaterialTextBox getCellBox();

        public MaterialButton getApplyButton();
    }

    @NameToken(NameTokens.settings)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<SettingsPresenter> {
    }

    @Inject
    SettingsPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Settings", "", "", "", this);

        getView().getApplyButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

            }

        });
    }
}
