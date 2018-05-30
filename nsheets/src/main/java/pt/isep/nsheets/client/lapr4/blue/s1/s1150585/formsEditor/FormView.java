/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.blue.s1.s1150585.formsEditor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTextBox;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author dftsf
 */
public class FormView extends ViewImpl {

    int rowCount = 0;
    Map<MaterialTextBox, MaterialCheckBox> rowMap = new HashMap<>();

    @UiField
    MaterialWindow formWindow;
    @UiField
    MaterialIcon addFormRowButton;
    @UiField
    MaterialIcon deleteFormRowButton;
    @UiField
    MaterialIcon playFormButton;
    @UiField
    MaterialIcon saveFormButton;
    @UiField
    MaterialIcon editFormRowButton;

    private static FormViewUiBinder uiBinder = GWT.create(FormViewUiBinder.class);

    interface FormViewUiBinder extends UiBinder<Widget, FormView> {
    }

    public FormView() {
        initWidget(uiBinder.createAndBindUi(this));

        formWindow.open();

        addFormRowButton.addClickHandler(event -> {
            rowCount++;
            MaterialTextBox txt = new MaterialTextBox("Row " + rowCount);
            MaterialCheckBox checkBox = new MaterialCheckBox();
            rowMap.put(txt, checkBox);
            formWindow.add(txt);
            formWindow.add(checkBox);
        });

        deleteFormRowButton.addClickHandler(event -> {
            Iterator it = rowMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry<MaterialTextBox, MaterialCheckBox>) it.next();
                MaterialCheckBox cb = (MaterialCheckBox) pair.getValue();
                if (cb.getValue() == true) {
                    formWindow.remove((MaterialCheckBox) pair.getValue());
                    formWindow.remove((MaterialTextBox) pair.getKey());
                    it.remove();
                }
            }
        });

        playFormButton.addClickHandler(event -> {
            Window.alert("Hello");
        });
        saveFormButton.addClickHandler(event -> {
            Window.alert("Hello");
        });

        editFormRowButton.addClickHandler(event -> {
            Iterator it = rowMap.entrySet().iterator();
            MaterialTextBox key = null;
            int check_count = 0;
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry<MaterialTextBox, MaterialCheckBox>) it.next();
                MaterialCheckBox cb = (MaterialCheckBox) pair.getValue();
                if (cb.getValue() == true) {
                    key = (MaterialTextBox) pair.getKey();
                    check_count++;
                }
            }

            if (check_count == 0) {
                Window.alert("Select one line to edit");
            } else if (check_count > 1) {
                Window.alert("You can only select one line");
            } else {
                String name = Window.prompt("What is the new name?", " ");
                MaterialTextBox newTxBox = new MaterialTextBox(name);
                rowMap.put(newTxBox, rowMap.get(key));

            }
        });
    }
}
