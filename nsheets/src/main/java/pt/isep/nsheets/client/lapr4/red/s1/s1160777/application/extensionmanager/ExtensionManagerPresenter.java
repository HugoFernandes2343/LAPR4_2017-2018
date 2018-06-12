package pt.isep.nsheets.client.lapr4.red.s1.s1160777.application.extensionmanager;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialListValueBox;
import gwt.material.design.client.ui.MaterialSwitch;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.Extension;
import pt.isep.nsheets.shared.services.ExtensionsService;
import pt.isep.nsheets.shared.services.ExtensionsServiceAsync;

import javax.inject.Inject;
import java.util.ArrayList;
import pt.isep.nsheets.client.application.workbook.WorkbookPresenter;


public class ExtensionManagerPresenter extends Presenter<ExtensionManagerPresenter.MyView, ExtensionManagerPresenter.MyProxy> {

    private ExtensionManagerPresenter.MyView view;



    interface MyView extends View {

        void addClickHandlerApplyButton(ClickHandler ch);

        void addColorSwitchHandler(ValueChangeHandler vc);

        void addStyleSwitchHandler(ValueChangeHandler vc);

        MaterialButton getApplyButton();

        MaterialSwitch getColorExtensionSwitch();

        MaterialSwitch getStyleExtensionSwitch();

        MaterialListValueBox<Color> getMaterialListValueBox1();

        MaterialListValueBox<Color> getMaterialListValueBox2();

    }

    @NameToken(NameTokens.extensionmanager)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ExtensionManagerPresenter> {
    }

    @Inject
    ExtensionManagerPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        this.view = view;
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Extensions Manager", "Manage your extensions", "", "", this);

        this.view.addClickHandlerApplyButton(event -> {
            LocalExtension.getInstance().setColor1(this.view.getMaterialListValueBox1().getSelectedItemText().toLowerCase());
            LocalExtension.getInstance().setColor2(this.view.getMaterialListValueBox2().getSelectedItemText().toLowerCase());
            MaterialToast.fireToast("Colors will be updated on next fomurla insert!");

        });

        this.view.addColorSwitchHandler(vc -> {
            MaterialToast.fireToast("Color Value " + vc.getValue());//diplays the actual value
            //will need to fetch the index and apply the value to the respective extension
        });

        this.view.addStyleSwitchHandler(vc -> {
            MaterialToast.fireToast("Style Value " + vc.getValue());//diplays the actual value
            //will need to fetch the index and apply the value to the respective extension
        });

    }
}
