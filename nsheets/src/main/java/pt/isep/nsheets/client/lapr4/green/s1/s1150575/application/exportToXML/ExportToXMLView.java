/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.exportToXML;

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
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;

/**
 *
 * @author João Vieira
 */
public class ExportToXMLView extends Composite {

    @UiField
    MaterialWindow window;
    @UiField
    MaterialTextBox textBox1;
    @UiField
    MaterialTextBox textBox2;
    @UiField
    MaterialRadioButton radioButtonWorkbook;
    @UiField
    MaterialRadioButton radioButtonWorksheet;
    @UiField
    MaterialRadioButton radioButtonPartOfWorksheet;
    @UiField
    MaterialButton btnPartFields;
    @UiField
    MaterialButton btnExport;

    private static ExportToXMLUiBinder uiBinder = GWT.create(ExportToXMLUiBinder.class);

    interface ExportToXMLUiBinder extends UiBinder<Widget, ExportToXMLView> {
    }

    public ExportToXMLView() {

        initWidget(uiBinder.createAndBindUi(this));
        window.setPadding(32);
        window.setHeight("450px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Export to XML");
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
        btnPartFields.setWaves(WavesType.LIGHT);
        btnPartFields.setSize(ButtonSize.MEDIUM);
        btnPartFields.setEnabled(false);
        MaterialPanel p3 = new MaterialPanel();
        p3.setTextAlign(TextAlign.LEFT);
        p3.add(btnPartFields);
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
                btnPartFields.setEnabled(event.getValue());
            }
        });

        window.open();
    }

    public MaterialTextBox getTextBox1() {
        return textBox1;
    }

    public MaterialTextBox getTextBox2() {
        return textBox2;
    }

    public MaterialButton getBtnPartFields() {
        return btnPartFields;
    }

    public MaterialButton getBtnExport() {
        return btnExport;
    }

}
