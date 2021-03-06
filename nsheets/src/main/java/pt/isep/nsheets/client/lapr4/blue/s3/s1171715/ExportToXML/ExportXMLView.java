/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isep.nsheets.client.lapr4.blue.s3.s1171715.ExportToXML;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
import java.util.ArrayList;
import java.util.Set;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.ExportCsvRangeService;
import pt.isep.nsheets.shared.services.ExportCsvRangeServiceAsync;
import pt.isep.nsheets.shared.services.ExportCsvService;
import pt.isep.nsheets.shared.services.ExportCsvServiceAsync;
import pt.isep.nsheets.shared.services.ExportCsvSpreadsheetService;
import pt.isep.nsheets.shared.services.ExportCsvSpreadsheetServiceAsync;
import pt.isep.nsheets.shared.services.ExportXMLCellRangeService;
import pt.isep.nsheets.shared.services.ExportXMLCellRangeServiceAsync;
import pt.isep.nsheets.shared.services.ExportXMLSpreadsheetService;
import pt.isep.nsheets.shared.services.ExportXMLSpreadsheetServiceAsync;
import pt.isep.nsheets.shared.services.ExportXMLWorkbookService;
import pt.isep.nsheets.shared.services.ExportXMLWorkbookServiceAsync;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.WorkbookDTO;


public class ExportXMLView extends Composite {

    @UiField
    MaterialWindow window;

    @UiField
    MaterialRadioButton radioButtonWorkbook, radioButtonWorksheet, radioButtonPartOfWorksheet;

    @UiField
    MaterialTextBox textBox1, textBox2, titleBox;

    @UiField
    MaterialButton btnExport;

    private static ExportXMLViewUiBinder uiBinder = GWT.create(ExportXMLViewUiBinder.class);

    interface ExportXMLViewUiBinder extends UiBinder<Widget, ExportXMLView> {
    }

    public ExportXMLView(Workbook wb) {
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
        MaterialPanel p3 = new MaterialPanel();
        p3.setTextAlign(TextAlign.LEFT);
        window.add(p3);
        btnExport.setWaves(WavesType.LIGHT);
        btnExport.setSize(ButtonSize.MEDIUM);
        MaterialPanel p4 = new MaterialPanel();
        p4.setTextAlign(TextAlign.RIGHT);
        p4.add(btnExport);
        window.add(p4);
        window.open();

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

                String upperCell = textBox1.getText();
                String lowerCell = textBox2.getText();

                Address addLower = wb.getSpreadsheet(0).findAddress(lowerCell);
                Address addUpper = wb.getSpreadsheet(0).findAddress(upperCell);

                String nSpreadsheet = Window.prompt("Insert spreadsheet number", "");
                int nSpreadsheetInt = Integer.parseInt(nSpreadsheet);
                SpreadsheetDTO sh = wb.getSpreadsheet(nSpreadsheetInt).toDTO();

                String[][] range = sh.getCellRange(addUpper.getRow(), addUpper.getColumn(), addLower.getRow(), addLower.getColumn());

                ExportXMLCellRangeServiceAsync downAsync = GWT.create(ExportXMLCellRangeService.class);

                downAsync.exportToDownload(range, new AsyncCallback<String[][]>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error in Export to XML! " + caught.getMessage());
                    }

                    @Override
                    public void onSuccess(String[][] result) {
                        String url = GWT.getModuleBaseURL() + "exportXMLCellRangeService?filename=" + titleBox.getText() + ".csv";;
                        Window.open(url, "Download XML file", "status=0,toolbar=0,menubar=0,location=0");
                    }
                });

            } else if (radioButtonWorkbook.getValue()) {
                WorkbookDTO dto = wb.toDTO();

                ExportXMLWorkbookServiceAsync downAsync = GWT.create(ExportXMLWorkbookService.class);

                downAsync.exportToDownload(dto, new AsyncCallback<WorkbookDTO>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error in Export to XML! " + caught.getMessage());
                    }

                    @Override
                    public void onSuccess(WorkbookDTO result) {
                        String url = GWT.getModuleBaseURL() + "exportXMLWorkbookService?filename=" + titleBox.getText() + ".csv";;
                        Window.open(url, "Download XML file", "status=0,toolbar=0,menubar=0,location=0");
                    }
                });
            } else if (radioButtonWorksheet.getValue()) {

                String nSpreadsheet = Window.prompt("Insert spreadsheet number", "");
                int nSpreadsheetInt = Integer.parseInt(nSpreadsheet);

                SpreadsheetDTO dto = wb.getSpreadsheet(nSpreadsheetInt).toDTO();

                if (dto.content == null) {
                    MaterialToast.fireToast("This spreadsheet doesn't exist ");
                } else {
                    ExportXMLSpreadsheetServiceAsync downAsync = GWT.create(ExportXMLSpreadsheetService.class);
                    downAsync.exportToDownload(dto, new AsyncCallback<SpreadsheetDTO>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            MaterialToast.fireToast("Error in Export to XML! " + caught.getMessage());
                        }

                        @Override
                        public void onSuccess(SpreadsheetDTO result) {
                            String url = GWT.getModuleBaseURL() + "exportXMLSpreadsheetService?filename=" + titleBox.getText() + ".csv";;
                            Window.open(url, "Download XML file", "status=0,toolbar=0,menubar=0,location=0");
                        }

                    });
                }
            } else {
                MaterialToast.fireToast("Please select an option!");
            }
        });
    }
}
