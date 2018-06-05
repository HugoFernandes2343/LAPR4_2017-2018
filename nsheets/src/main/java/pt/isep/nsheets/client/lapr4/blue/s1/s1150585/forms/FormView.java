/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.blue.s1.s1150585.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author dftsf
 */
public class FormView extends Composite {

    @UiField
    MaterialIcon executeForm;
    @UiField
    MaterialWindow formWindow;

    int rowCount = 0;
    Map<Integer, MaterialCheckBox> checkBoxMap = new HashMap<>();
    Map<Integer, MaterialTextBox> textBoxMap = new HashMap<>();
    Map<Integer, MaterialLabel> labelMap = new HashMap<>();

    private static FormViewUiBinder uiBinder = GWT.create(FormViewUiBinder.class);

    interface FormViewUiBinder extends UiBinder<Widget, FormView> {
    }

    public FormView(Map<String, String> formMap) {
        initWidget(uiBinder.createAndBindUi(this));

        Iterator it_form = formMap.entrySet().iterator();
        while (it_form.hasNext()) {
            Map.Entry pair = (Map.Entry) it_form.next();

            MaterialLabel label = new MaterialLabel((String) pair.getKey());
            MaterialTextBox txt = new MaterialTextBox();
            txt.setValue((String) pair.getValue());
            txt.setEnabled(false);
            MaterialCheckBox cb = new MaterialCheckBox();

            label.setPaddingLeft(100);
            label.setPaddingRight(100);
            label.setPaddingTop(50);
            label.add(txt);
            txt.setPaddingBottom(25);
            txt.add(cb);
           
            formWindow.add(label);

            labelMap.put(rowCount, label);
            textBoxMap.put(rowCount, txt);
            checkBoxMap.put(rowCount, cb);
            rowCount++;
        }
        formWindow.open();

        executeForm.addClickHandler(event
                -> {
            Iterator it = checkBoxMap.entrySet().iterator();
            Integer key = null;
            int check_count = 0;
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry<Integer, MaterialCheckBox>) it.next();
                MaterialCheckBox cb = (MaterialCheckBox) pair.getValue();
                if (cb.getValue() == true) {
                    check_count++;
                }
            }
            if (check_count == 0) {
                Window.alert("Select one line to execute");
            } else if (check_count > 1) {
                Window.alert("You can only select one line to execute");
            } else {
                Window.alert("Execute");
            }
        });
    }
}
