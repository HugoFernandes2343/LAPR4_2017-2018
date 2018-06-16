package pt.isep.nsheets.client.lapr4.green.s3.s1151136.application.extension;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

public class ExtensionPresenter extends Presenter<ExtensionPresenter.MyView, ExtensionPresenter.MyProxy> {

    interface MyView extends View {

        MaterialTextBox getTxtPopup();

        void addClickHandler(ClickHandler ch);

    }

    @NameToken(NameTokens.extension)
    @ProxyStandard

    interface MyProxy extends ProxyPlace<ExtensionPresenter> {
    }

    @Inject
    ExtensionPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        getView().addClickHandler((event) -> {
            if (getView().getTxtPopup().getText().isEmpty()) {
                MaterialToast.fireToast("Write something");
            } else {
                MaterialToast.fireToast("Button action");
            }
        });

    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Extension", "", "", "", this);
    }

}
