package pt.isep.nsheets.client.lapr4.green.s2.s1160570.application.exchange;

import pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login.*;
import com.google.gwt.event.dom.client.ClickHandler;
import javax.inject.Inject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.core.ConvertCurrencie;

class ExchangeView extends ViewImpl implements ExchangePresenter.MyView {

    @UiField
    MaterialComboBox comboBox1, comboBox2;

    @UiField
    MaterialTextBox value;

    @UiField
    MaterialButton changeBtn;

    interface Binder extends UiBinder<Widget, ExchangeView> {
    }

    @Inject
    ExchangeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        this.comboBox1.addItem("DOLLAR");
        this.comboBox1.addItem("EURO");
        this.comboBox1.addItem("POUND");
        this.comboBox2.addItem("DOLLAR");
        this.comboBox2.addItem("EURO");
        this.comboBox2.addItem("POUND");
       

    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        changeBtn.addClickHandler(ch);
    }

    public MaterialComboBox getComboBox1() {
        return comboBox1;
    }

    public MaterialComboBox getComboBox2() {
        return comboBox2;
    }

    public MaterialTextBox getValue() {
        return value;
    }

}
