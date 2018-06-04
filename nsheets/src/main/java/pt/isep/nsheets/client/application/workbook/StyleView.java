package pt.isep.nsheets.client.application.workbook;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialTextBox;

public class StyleView extends ViewImpl {

    @UiField
    public static MaterialWindow styleWindow;

    @UiField
    public static MaterialButton confirmButton;

    @UiField
    public static MaterialDropDown styleChooser;

    @UiField
    public static MaterialTextBox cellInfo;
/**
    @UiField
    public static MaterialDropDown colorChooser;
**/
    private static StyleView.StyleViewUiBinder uiBinder = GWT.create(StyleView.StyleViewUiBinder.class);

    interface StyleViewUiBinder extends UiBinder<Widget,StyleView>{

    }

    public StyleView()  {
        initWidget(uiBinder.createAndBindUi(this));
        styleWindow.open();

    }

    @UiHandler("dropdown")
    void onDropdown(SelectionEvent<Widget> callback){
        MaterialToast.fireToast("Selected : " + ((MaterialLink)callback.getSelectedItem()).getText());
    }

}
