package pt.isep.nsheets.client.lapr4.red.s2.n1161213.application.exportpdf;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

import java.util.ArrayList;

public class ExportToPdfView extends Composite {

    @UiField
    MaterialWindow window;

    @UiField
    MaterialRadioButton completeWorkbook, completeSpreadsheet, partSpreadsheet;

    @UiField
    MaterialPanel radioPanel, workbookPanel, spreadsheetPanel, partSpreadsheetPanel;

    MaterialListValueBox<Workbook> workbook = new MaterialListValueBox<>();

    MaterialListValueBox<Spreadsheet> spreadsheet = new MaterialListValueBox<>();

    MaterialButton exportButton = new MaterialButton();

    private static ExportToPdfUiBinder uiBinder = GWT.create(ExportToPdfUiBinder.class);

    interface ExportToPdfUiBinder extends UiBinder<Widget, ExportToPdfView> {
    }

    @Inject
    public ExportToPdfView() {
        initWidget(uiBinder.createAndBindUi(this));
        window = new MaterialWindow();
        this.window.setWidth("70");
        this.window.setTitle("Export to PDF");
        this.window.setTextAlign(TextAlign.LEFT);
        this.window.setPadding(32);
        this.window.setHeight("600");
        MaterialWindow.setOverlay(true);
        //Inititates the panel with the radio buttons
        radioButtonsPanel();
        this.window.add(this.radioPanel);
        //Creates the list boxes and buttons and set all its necessary attributes
        this.workbook.setPlaceholder("Chose workbook to export");
        this.workbook.setGrid("s12");
        //Filling the MaterialListValueBox
        WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
        AsyncCallback<ArrayList<Workbook>> callback = new AsyncCallback<ArrayList<Workbook>>() {
            @Override
            public void onFailure(Throwable throwable) {
                MaterialToast.fireToast(throwable.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<Workbook> workbookDTOS) {
                for (Workbook w : workbookDTOS) {
                    workbook.addItem(w);
                }
            }
        };
        //workbooksSvc.getWorkbooks(callback);
        this.spreadsheet.setPlaceholder("Chose spreadsheet to export");
        this.spreadsheet.setGrid("s12");


        this.exportButton.setText("Export");
        this.exportButton.setWaves(WavesType.DEFAULT);
        this.exportButton.setBackgroundColor(Color.BLUE);
        this.exportButton.setTextColor(Color.WHITE);
        //Creates the panels and sets all attributes

        this.completeWorkbook.addClickHandler(event -> {
            this.window.remove(spreadsheetPanel);
            this.window.remove(partSpreadsheetPanel);
            workbookPanel();
            this.window.add(this.workbookPanel);
        });

        this.completeSpreadsheet.addClickHandler(event -> {
            this.window.remove(this.workbookPanel);
            this.window.remove(this.partSpreadsheetPanel);
            spreadsheetPanel();
            this.window.add(this.spreadsheetPanel);
        });

        this.partSpreadsheet.addClickHandler(event -> {
            this.window.remove(this.spreadsheetPanel);
            this.window.remove(this.workbookPanel);
            partSpreadsheetPanel();
            this.window.add(this.partSpreadsheetPanel);
        });

        this.workbook.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Workbook w = workbook.getSelectedValue();
//                for (int i = 0; i < w.spreadsheets.size(); i++) {
//                    spreadsheet.addItem(w.spreadsheets.get(i));
//                }
            }
        });

        this.window.open();
    }

    /**
     * Inititates the Panel that keeps the Radio Buttons.
     */
    private void radioButtonsPanel() {
        this.radioPanel = new MaterialPanel();
        this.radioPanel.setTitle("What do you wish to export");
        this.completeWorkbook = new MaterialRadioButton("select");
        MaterialPanel p0 = new MaterialPanel();
        p0.add(this.completeWorkbook);
        this.completeWorkbook.setText("Export whole workbook");
        this.completeSpreadsheet = new MaterialRadioButton("select");
        this.completeSpreadsheet.setText("Export one spreadsheet");
        MaterialPanel p1 = new MaterialPanel();
        p1.add(this.completeSpreadsheet);
        this.partSpreadsheet = new MaterialRadioButton("select");
        this.partSpreadsheet.setText("Export part of a spreadsheet");
        MaterialPanel p2 = new MaterialPanel();
        p0.add(this.partSpreadsheet);
        this.radioPanel.add(this.completeWorkbook);
        this.radioPanel.add(this.completeSpreadsheet);
        this.radioPanel.add(this.partSpreadsheet);
        this.radioPanel.setVisible(true);
    }

    private void workbookPanel() {
        this.workbookPanel = new MaterialPanel();
        this.workbookPanel.setTitle("Chose worksheet to export");
        this.workbookPanel.add(this.workbook);
        MaterialPanel button = new MaterialPanel();
        button.setTextAlign(TextAlign.RIGHT);
        button.add(this.exportButton);
        this.workbookPanel.add(button);
    }

    private void spreadsheetPanel() {
        this.spreadsheetPanel = new MaterialPanel();
        this.spreadsheetPanel.setTitle("Chose spreadsheet to export");
        this.spreadsheetPanel.add(this.workbook);
        this.spreadsheetPanel.add(this.spreadsheet);
        MaterialPanel button = new MaterialPanel();
        button.setTextAlign(TextAlign.RIGHT);
        button.add(this.exportButton);
        this.spreadsheetPanel.add(button);
    }

    private void partSpreadsheetPanel() {
        this.partSpreadsheetPanel = new MaterialPanel();
        this.partSpreadsheetPanel.setTitle("Chose worksheet to export");
        this.partSpreadsheetPanel.add(this.workbook);
        this.partSpreadsheetPanel.add(this.spreadsheet);
        MaterialPanel button = new MaterialPanel();
        button.setTextAlign(TextAlign.RIGHT);
        button.add(this.exportButton);
        this.partSpreadsheetPanel.add(button);
    }

    private void fillSpreadsheets(){

    }
}