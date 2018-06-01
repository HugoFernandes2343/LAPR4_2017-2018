package pt.isep.nsheets.client.lapr4.red.s1.s1160777.application.extensionmanager;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialSwitch;

import javax.inject.Inject;

class ExtensionManagerView extends ViewImpl implements ExtensionManagerPresenter.MyView {

    @UiField
    MaterialButton applyButton;

    @Override
    public void addClickHandlerApplyButton(ClickHandler ch) { applyButton.addClickHandler(ch); }

    @Override
    public MaterialButton getApplyButton() {
        return this.applyButton;
    }

    @Override
    public MaterialCheckBox getCheckBox() {
        return null;
    }

    @Override
    public MaterialSwitch getSwitchPanelSelection() {
        return null;
    }

    interface Binder extends UiBinder<Widget, ExtensionManagerView> {
    }

    @Inject
    ExtensionManagerView(Binder uiBinder) { initWidget(uiBinder.createAndBindUi(this));}
}
