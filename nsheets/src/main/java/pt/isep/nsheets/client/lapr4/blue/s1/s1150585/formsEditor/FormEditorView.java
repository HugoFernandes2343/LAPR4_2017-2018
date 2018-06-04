/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.blue.s1.s1150585.formsEditor;

import pt.isep.nsheets.client.lapr4.blue.s1.s1150585.forms.FormView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import pt.isep.nsheets.client.application.workbook.SelectedWorkbookController;
import pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1150585.forms.FormsEditorController;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author dftsf
 */
public class FormEditorView extends Composite {

    int rowCount = 0;
    Map<Integer, MaterialCheckBox> checkBoxMap = new HashMap<>();
    Map<Integer, MaterialTextBox> textBoxMap = new HashMap<>();
    Map<Integer, MaterialLabel> labelMap = new HashMap<>();

    Map<String, String> formMap = new HashMap<>();

    @UiField
    MaterialWindow formEditorWindow;
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

    private static FormEditorViewUiBinder uiBinder = GWT.create(FormEditorViewUiBinder.class);

    interface FormEditorViewUiBinder extends UiBinder<Widget, FormEditorView> {
    }

    public FormEditorView() {
        initWidget(uiBinder.createAndBindUi(this));

        Workbook wb = SelectedWorkbookController.getActualWorkbook();
        FormsEditorController editorController = new FormsEditorController(wb);

        if (editorController.existsForm() == true) {
            formMap = editorController.getExistentForm();
            Iterator it_form = formMap.entrySet().iterator();
            while (it_form.hasNext()) {
                Map.Entry pair = (Map.Entry) it_form.next();

                MaterialLabel label = new MaterialLabel((String) pair.getKey());
                MaterialTextBox txt = new MaterialTextBox();
                txt.setValue((String) pair.getValue());
                MaterialCheckBox cb = new MaterialCheckBox();

                checkBoxMap.put(rowCount, cb);
                textBoxMap.put(rowCount, txt);
                labelMap.put(rowCount, label);

                label.setPaddingLeft(100);
                label.setPaddingRight(100);
                label.setPaddingTop(50);

                txt.setPaddingLeft(100);
                txt.setPaddingRight(100);
                txt.setPaddingTop(25);
                txt.setPaddingBottom(25);
                txt.add(cb);

                formEditorWindow.add(label);
                formEditorWindow.add(txt);
                rowCount++;
            }
        }
        formEditorWindow.open();

        addFormRowButton.addClickHandler(event -> {
            MaterialLabel label = new MaterialLabel("Row " + rowCount);
            MaterialTextBox txt = new MaterialTextBox();
            MaterialCheckBox checkBox = new MaterialCheckBox();

            checkBoxMap.put(rowCount, checkBox);
            textBoxMap.put(rowCount, txt);
            labelMap.put(rowCount, label);

            label.setPaddingLeft(100);
            label.setPaddingRight(100);
            label.setPaddingTop(50);

            txt.setPaddingLeft(100);
            txt.setPaddingRight(100);
            txt.setPaddingTop(25);
            txt.setPaddingBottom(25);
            txt.add(checkBox);

            formEditorWindow.add(label);
            formEditorWindow.add(txt);
            rowCount++;

        });

        deleteFormRowButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Iterator it = checkBoxMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair_checkBox = (Map.Entry<Integer, MaterialCheckBox>) it.next();
                    MaterialCheckBox cb = (MaterialCheckBox) pair_checkBox.getValue();
                    Integer key = (Integer) pair_checkBox.getKey();

                    if (cb.getValue() == true) {
                        formEditorWindow.remove((MaterialCheckBox) pair_checkBox.getValue());
                        formEditorWindow.remove(labelMap.get(key));
                        formEditorWindow.remove(textBoxMap.get(key));

                        MaterialLabel labelRemove = labelMap.get(key);
                        formMap.remove(labelRemove.getValue());

                        checkBoxMap.remove(key);
                        textBoxMap.remove(key);
                        labelMap.remove(key);

                        it.remove();
                        rowCount--;
                    }
                }
            }
        });

        playFormButton.addClickHandler(event -> {
            Iterator it_label = labelMap.entrySet().iterator();
            Iterator it_textBox = textBoxMap.entrySet().iterator();
            while (it_label.hasNext()) {
                Map.Entry pair_label = (Map.Entry) it_label.next();
                Map.Entry pair_txt = (Map.Entry) it_textBox.next();

                MaterialLabel label = (MaterialLabel) pair_label.getValue();
                MaterialTextBox txt = (MaterialTextBox) pair_txt.getValue();

                formMap.put(label.getValue(), txt.getValue());
            }
            new FormView(formMap);
        });

        saveFormButton.addClickHandler(event
                -> {
            Window.alert("Hello");
        });

        editFormRowButton.addClickHandler(event
                -> {
            Iterator it = checkBoxMap.entrySet().iterator();
            Integer key = null;
            int check_count = 0;
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry<MaterialTextBox, MaterialCheckBox>) it.next();
                MaterialCheckBox cb = (MaterialCheckBox) pair.getValue();
                if (cb.getValue() == true) {
                    key = (Integer) pair.getKey();
                    check_count++;
                }
            }

            if (check_count == 0) {
                Window.alert("Select one line to edit");
            } else if (check_count > 1) {
                Window.alert("You can only select one line");
            } else {
                String oldName = labelMap.get(key).toString();
                String name = Window.prompt("What is the new name?", " ");
                labelMap.get((Integer) key).setValue(name);
                String txtContent = formMap.get(oldName);
                formMap.remove(oldName);
                formMap.put(name, txtContent);
            }
        }
        );
    }
}
