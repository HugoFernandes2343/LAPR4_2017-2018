package pt.isep.nsheets.client.lapr4.green.s3.s1151136.application.extension;

import com.google.gwt.event.dom.client.ClickHandler;
import javax.inject.Inject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

class ExtensionView extends ViewImpl implements ExtensionPresenter.MyView {

    @UiField
    MaterialTextBox txtPopup;

    @UiField
    MaterialButton btnPopup;

    interface Binder extends UiBinder<Widget, ExtensionView> {
    }

    @Inject
    ExtensionView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public MaterialTextBox getTxtPopup() {
        return txtPopup;
    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        btnPopup.addClickHandler(ch);
    }
}
