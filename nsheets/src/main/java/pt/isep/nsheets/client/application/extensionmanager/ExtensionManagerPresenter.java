package pt.isep.nsheets.client.application.extensionmanager;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialSwitch;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

import javax.inject.Inject;

public class ExtensionManagerPresenter extends Presenter<ExtensionManagerPresenter.MyView,ExtensionManagerPresenter.MyProxy> {

    interface MyView extends View {

        public MaterialButton getApplyButton();

        public MaterialCheckBox getCheckBox();

        public MaterialSwitch getSwitchPanelSelection();

    }

    @NameToken(NameTokens.extensionmanager)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ExtensionManagerPresenter> {
    }

    @Inject
    ExtensionManagerPresenter(EventBus eventBus,MyView view,MyProxy proxy){
        super(eventBus,view,proxy,ApplicationPresenter.SLOT_CONTENT);
    }

    @Override
    protected void onReveal(){
        super.onReveal();

        SetPageTitleEvent.fire("Extensions Manager","Manage your extensions","","",this);

        getView().getApplyButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //Add behaviour to persist the changes and apply the effects
                //of the extensions in use
            }
        });
    }
}
