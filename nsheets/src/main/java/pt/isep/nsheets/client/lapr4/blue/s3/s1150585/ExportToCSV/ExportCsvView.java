/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.blue.s3.s1150585.ExportToCSV;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.ButtonSize;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public class ExportCsvView extends Composite {

    @UiField
    MaterialWindow window;

    @UiField
    MaterialListBox format;

    @UiField
    MaterialRadioButton radioButtonWorkbook, radioButtonWorksheet, radioButtonPartOfWorksheet;

    @UiField
    MaterialTextBox textBox1, textBox2, titleBox;

    @UiField
    MaterialButton btnExport;

    private static ExportCsvViewUiBinder uiBinder = GWT.create(ExportCsvViewUiBinder.class);

    interface ExportCsvViewUiBinder extends UiBinder<Widget, ExportCsvView> {
    }

    public ExportCsvView(Workbook wb) {
        initWidget(uiBinder.createAndBindUi(this));
        window.setPadding(32);
        window.setHeight("450px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Export to CSV");
        MaterialWindow.setOverlay(true);
        MaterialLabel label1 = new MaterialLabel("Please select what you wish to export.");
        radioButtonWorkbook.setName("Export");
        radioButtonWorksheet.setName("Export");
        radioButtonPartOfWorksheet.setName("Export");
        window.add(label1);
        MaterialPanel p0 = new MaterialPanel();
        MaterialPanel p1 = new MaterialPanel();
        MaterialPanel p2 = new MaterialPanel();
        p0.setTextAlign(TextAlign.LEFT);
        p1.setTextAlign(TextAlign.LEFT);
        p2.setTextAlign(TextAlign.LEFT);
        p0.add(radioButtonWorkbook);
        p1.add(radioButtonWorksheet);
        p2.add(radioButtonPartOfWorksheet);
        window.add(p0);
        window.add(p1);
        window.add(p2);
        textBox1.setEnabled(false);
        textBox2.setEnabled(false);
        window.add(textBox1);
        window.add(textBox2);
        MaterialPanel p3 = new MaterialPanel();
        p3.setTextAlign(TextAlign.LEFT);
        window.add(p3);
        btnExport.setWaves(WavesType.LIGHT);
        btnExport.setSize(ButtonSize.MEDIUM);
        MaterialPanel p4 = new MaterialPanel();
        p4.setTextAlign(TextAlign.RIGHT);
        p4.add(btnExport);
        window.add(p4);

        radioButtonPartOfWorksheet.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                textBox1.setEnabled(event.getValue());
                textBox2.setEnabled(event.getValue());
            }
        });

        btnExport.addClickHandler(event -> {
            if (radioButtonPartOfWorksheet.getValue() && (textBox1.getText().equals("") | textBox2.getText().equals(""))) {
                MaterialToast.fireToast("Part Of a Worksheet selected");
                MaterialToast.fireToast("Please indicate a range");
            } else if (radioButtonPartOfWorksheet.getValue() && !textBox1.getText().equals("") && !textBox2.getText().equals("")) {
                MaterialToast.fireToast("Starting cell: " + textBox1.getText() + "Ending cell: " + textBox2.getText());

            } else if (radioButtonWorkbook.getValue()) {
                MaterialToast.fireToast("Workbook selected");
            } else if (radioButtonWorksheet.getValue()) {
                MaterialToast.fireToast("Worksheet selected");
            } else {
                MaterialToast.fireToast("Please select an option!");
            }
        });
        window.open();
    }
}
