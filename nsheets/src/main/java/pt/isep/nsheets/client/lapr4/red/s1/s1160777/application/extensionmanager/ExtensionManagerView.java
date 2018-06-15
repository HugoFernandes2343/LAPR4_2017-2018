package pt.isep.nsheets.client.lapr4.red.s1.s1160777.application.extensionmanager;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialListValueBox;
import gwt.material.design.client.ui.MaterialSwitch;
import java.util.ArrayList;
import java.util.List;
import org.apache.xpath.operations.Bool;

import javax.inject.Inject;

class ExtensionManagerView extends ViewImpl implements ExtensionManagerPresenter.MyView {

    @UiField
    MaterialButton applyButton;

    @UiField
    MaterialSwitch colorSwitch;

    @UiField
    MaterialSwitch styleExtension;

    @UiField
    MaterialIcon colorExtensionDef;

    @UiField
    MaterialListValueBox<Color> lstColors1;

    @UiField
    MaterialListValueBox<Color> lstColors2;

    @Override
    public void addClickHandlerApplyButton(ClickHandler ch) {
        applyButton.addClickHandler(ch);
    }

    @Override
    public void addStyleSwitchHandler(ValueChangeHandler vc) {
        styleExtension.addValueChangeHandler(vc);
    }

    @Override
    public void addColorSwitchHandler(ValueChangeHandler vc) {
        colorSwitch.addValueChangeHandler(vc);
    }

    @Override
    public MaterialButton getApplyButton() {
        return this.applyButton;
    }

    @Override
    public MaterialSwitch getColorExtensionSwitch() {
        return this.colorSwitch;
    }

    @Override
    public MaterialSwitch getStyleExtensionSwitch() {
        return this.styleExtension;
    }

    @Override
    public MaterialListValueBox<Color> getMaterialListValueBox1() {
        return this.lstColors1;
    }

    @Override
    public MaterialListValueBox<Color> getMaterialListValueBox2() {
        return this.lstColors2;
    }

    interface Binder extends UiBinder<Widget, ExtensionManagerView> {
    }

    @Inject
    ExtensionManagerView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        List<Color> lstColor = new ArrayList<>();
        lstColor.add(Color.WHITE);
        lstColor.add(Color.RED);
        lstColor.add(Color.BLUE);
        lstColor.add(Color.GREEN);
        lstColor.add(Color.BLACK);
        lstColor.add(Color.ORANGE);
        lstColor.add(Color.YELLOW);
        lstColor.add(Color.GREY);
        lstColor.add(Color.BROWN);
        lstColor.add(Color.PURPLE);
        lstColors1.add(Color.BLUE);

        for (Color c : lstColor) {
            lstColors1.addItem(c);
            lstColors2.addItem(c);

        }

    }
}
