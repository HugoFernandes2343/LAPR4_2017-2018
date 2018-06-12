/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package pt.isep.nsheets.client.application.workbook;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.ButtonSize;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.client.lapr4.blue.s1.s1150585.forms.FormView;
//import pt.isep.nsheets.client.lapr4.blue.s1.s1150585.formsEditor.FormEditorView;
import pt.isep.nsheets.client.lapr4.blue.s1161248.BaseJavascriptLanguage.MacrosView;
import pt.isep.nsheets.client.lapr4.blue.s2.s1140420.basicChartWizard.BasicChartWizardView;
import pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.exportToXML.ExportToXMLView;
//import pt.isep.nsheets.client.lapr4.red.s2.n1161213.application.exportpdf.ExportToPdfView;
import pt.isep.nsheets.client.lapr4.red.s2.n1161213.application.exportpdf.ExportToPdfView;
import pt.isep.nsheets.client.lapr4.red.s2.s1160777.application.exportToCLS.ExportToCLSView;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.services.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;
import pt.isep.nsheets.client.lapr4.blue.s2.s1091234.addSpreadsheet.addSpreadsheetView;
import pt.isep.nsheets.client.lapr4.blue.s2.s1171715.filterCellRange.FilterCellRangeView;
import pt.isep.nsheets.shared.core.CellImpl;

import pt.isep.nsheets.shared.core.SpreadsheetImpl;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.RelationalOperator;

// public class HomeView extends ViewImpl implements HomePresenter.MyView {
// public class WorkbookView extends NavigatedView implements WorkbookPresenter.MyView {
public class WorkbookView extends ViewImpl implements WorkbookPresenter.MyView {

    public MaterialTextBox getFirstBox() {
        return firstBox;
    }

    public MaterialIcon getFirstButton() {
        return firstButton;
    }

    public MaterialButton getformulaButton() {
        return formulaButton;
    }

    public MaterialLink getConditionalLink() {
        return conditionalLink;
    }

    List<MaterialRadioButton> falseColorButtons = new ArrayList<>();
    List<MaterialRadioButton> falseFontButtons = new ArrayList<>();
    List<MaterialRadioButton> formulasButtons = new ArrayList<>();
    List<MaterialRadioButton> trueColorButtons = new ArrayList<>();
    List<MaterialRadioButton> trueFontButtons = new ArrayList<>();
    
    @UiField
    MaterialCollapsible colap;

    @UiField
    MaterialLink conditionalLink;

    @UiField
    MaterialButton formulaButton;

    @UiField
    MaterialButton trueColorButton;

    @UiField
    MaterialButton trueFontButton;

    @UiField
    MaterialButton falseColorButton;

    @UiField
    MaterialButton falseFontButton;

    @UiField
    MaterialCollection formulas;

    @UiField
    MaterialCollection trueColor;

    @UiField
    MaterialCollection falseColor;

    @UiField
    MaterialCollection trueFont;

    @UiField
    MaterialCollection falseFont;

    @UiField
    MaterialTextBox formulaValue;

    @UiField
    MaterialTextBox trueCase;

    @UiField
    MaterialButton confirmCF;

    @UiField
    MaterialTextBox firstBox;
    @UiField
    MaterialIcon firstButton;
    @UiField
    MaterialButton exportToXMLButton;
    @UiField
    MaterialButton macrosButton;

    //1140420
    @UiField
    MaterialButton chartWizardButton;
    
    //1171715
    @UiField
    MaterialButton filterCellRange;
    
    //1091234
    @UiField
    MaterialButton newSpreadsheetButton;

    @UiField
    MaterialWindow windowconditional;

    @UiField
    MaterialLink editformat;

    @UiField
    MaterialButton confirm;

    @UiField
    MaterialButton exportToCSVButton;

    //1160777
    @UiField
    MaterialButton exportToCLSButton;

    @UiField
    MaterialButton exportToPdfButton;

    @UiField
    MaterialIcon styleButton;

    @UiField
    MaterialDataTable<SheetCell> customTable;

    @UiField
    MaterialPopupMenu popupMenu;

    @UiField
    MaterialIcon formButton;

    @UiField
    MaterialButton searchButton;

    @UiField
    MaterialButton sortButton;

    @UiField
    MaterialListValueBox<String> sortingTypeBox;
    @UiField
    MaterialListValueBox<String> dataTypeBox;
    @UiField
    MaterialTextBox upperCellInfo;
    @UiField
    MaterialTextBox lowerCellInfo;

    interface Binder extends UiBinder<Widget, WorkbookView> {
    }

    private pt.isep.nsheets.shared.core.Cell activeCell = null;

    public void setActiveCell(pt.isep.nsheets.shared.core.Cell cell) {
        this.activeCell = cell;

        this.customTable.getTableTitle().setText(cell.toString() + ": " + cell.getContent().toString());
        this.firstBox.setText(cell.getContent().toString());
    }

    public pt.isep.nsheets.shared.core.Cell getActiveCell() {
        return this.activeCell;
    }

    public MaterialDataTable<SheetCell> getTable() {
        return customTable;
    }

    class SheetCell {

        private Spreadsheet sheet;
        private int row = -1;

        public SheetCell(Spreadsheet sheet, int row) {
            this.row = row;
            this.sheet = sheet;
        }

        pt.isep.nsheets.shared.core.Cell getCell(int column) {
            return this.sheet.getCell(column, this.row);
        }
    }

    void initWorkbook() throws Exception {
        // Test the initialization of an Workbook

        String contents[][] = { // first spreadsheet
                {"10", "9", "8", "7", "a", "b", "c"}, {"8", "=1+7", "6", "5", "4", "3", "2"},
                {"1", "2", "3", "4", "5", "6", "7"}};

        Workbook wb = new Workbook(contents);
//        WorkbookDescriptionDTO desc = new WorkbookDescriptionDTO("Workbook", "New Workbook", wb.toDTO(), "");

//        SpreadsheetDTO temp = desc.getWorkbook().getSpreadsheets().get(0);
        Spreadsheet sh  = new SpreadsheetImpl(wb,"sheet", contents);


        int columnNumber = 0;

        // Add the columns...
        customTable.addColumn(new SheetWidgetColumn(-1, this));
        for (int i = 0; i < sh.getColumnCount(); ++i) {

            // Add a column for the column :-)
            customTable.addColumn(new SheetWidgetColumn(columnNumber, this));

            ++columnNumber;
        }

        // int rowIndex = 0;
        List<SheetCell> rows = new ArrayList<>();
        for (int k = 0; k < sh.getRowCount(); k++) {
            rows.add(new SheetCell(sh, k));
        }
        customTable.setRowData(0, rows);

    }

    @Inject
    WorkbookView(Binder uiBinder) throws Exception {

        initWidget(uiBinder.createAndBindUi(this));
        
        
        //INICIO 1160696
        MaterialCollection c = new MaterialCollection();
        Language l = new Language("teste");
        List<RelationalOperator> list = l.relationalOperators();
        for (RelationalOperator o : list) {
            MaterialRadioButton b = new MaterialRadioButton("condition");
            b.setText(o.toString());
            c.add(b);
            formulasButtons.add(b);
        }
        formulas.add(c);

        //preenchimento de radioButtons com cores / estilos de fonte a serem aplicados
        MaterialCollection trueC = new MaterialCollection();
        MaterialCollection falseC = new MaterialCollection();

//        List<Color> listColor = l.relationalOperators();
        List<String> lc = new ArrayList<String>();

        lc.add("Green");
        lc.add("Purple");
        lc.add("Red");
        lc.add("Black");
        lc.add("Blue");
        lc.add("Yellow");

        for (String string : lc) {
            MaterialRadioButton colorF = new MaterialRadioButton("ColorsF");
            MaterialRadioButton colorT = new MaterialRadioButton("ColorsT");

            colorF.setText(string);
            colorT.setText(string);
            trueC.add(colorF);
            falseC.add(colorT);
            trueColorButtons.add(colorF);
            falseColorButtons.add(colorT);
        }
        trueColor.add(trueC);
        falseColor.add(falseC);

        MaterialCollection trueF = new MaterialCollection();
        MaterialCollection falseF = new MaterialCollection();

//        List<Font> listFont = l.relationalOperators();
        List<String> lf = new ArrayList<String>();
        
        
        lf.add("Times New Roman");
        lf.add("Arial");
        lf.add("Calisto MT");
        lf.add("Charter BT");
        lf.add("Comic Sans");
        lf.add("LucidaSans");

        for (String string : lf) {

            MaterialRadioButton fontF = new MaterialRadioButton("FontsF");
            MaterialRadioButton fontT = new MaterialRadioButton("FontsT");

            fontT.setText(string);
            fontF.setText(string);
            trueF.add(fontT);
            falseF.add(fontF);
            trueFontButtons.add(fontT);
            falseFontButtons.add(fontF);
        }
        trueFont.add(trueF);
        falseFont.add(falseF);

        confirmCF.addClickHandler(event -> {
            if (activeCell != null) {
                if (activeCell.getContent().compareTo("\u200B") != 0) {
                    String formula = "";
                    for (MaterialRadioButton rb : formulasButtons) {
                        if (rb.getValue()) {
                            formula = rb.getText();
                        }
                    }
                    if (!formula.equalsIgnoreCase("")) {
                        String value = formulaValue.getText();
                        String trueColor = "";
                        String falseColor = "";
                        String trueFont = "";
                        String falseFont = "";
                        for (MaterialRadioButton tcb : trueColorButtons) {
                            if (tcb.getValue()) {
                                trueColor = tcb.getText();
                            }
                        }
                        for (MaterialRadioButton fcb : falseColorButtons) {
                            if (fcb.getValue()) {
                                falseColor = fcb.getText();
                            }
                        }
                        for (MaterialRadioButton tfb : trueFontButtons) {
                            if (tfb.getValue()) {
                                trueFont = tfb.getText();
                            }
                        }
                        for (MaterialRadioButton ffb : falseFontButtons) {
                            if (ffb.getValue()) {
                                falseFont = ffb.getText();
                            }
                        }
                        
                        
                        
                        
                        boolean resultado = false;
                        if (!trueColor.equalsIgnoreCase("") || !falseColor.equalsIgnoreCase("") || !trueFont.equalsIgnoreCase("") || !falseFont.equalsIgnoreCase("")) {
                            resultado = true;
                        }
                        
                        
                        
                        if (!value.isEmpty()) {
                            
                            
                            
                            if (resultado) {

                            CellImplDTO activeCellDTO = activeCell.toDTO();




                                WorkbooksServiceAsync workbookServiceAsync = GWT.create(WorkbooksService.class);
                                AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                                    @Override
                                    public void onFailure(Throwable caught) {
                                        MaterialToast.fireToast(caught.getMessage());
                                    }

                                    @Override
                                    public void onSuccess(Boolean result) {
                                        if (result) {

                                            MaterialToast.fireToast("Conditional Format applied with success!", "rounded");
                                            ;
                                        } else {
                                            MaterialToast.fireToast("Conditional Format not applied...", "rounded");
                                        }

                                    }
                                };

                                workbookServiceAsync.activateConditional(activeCellDTO, "test", formula, value, callback);
                            } else {
                                MaterialToast.fireToast("Did you forget to apply a style?", "rounded");
                            }

                        } else {
                            MaterialToast.fireToast("Did you forget to insert a value?", "rounded");
                        }
                    } else {
                        MaterialToast.fireToast("Did you forget to insert a formula?", "rounded");
                    }
                } else {
                    MaterialToast.fireToast("The Conditional Function was not applied beacuse the cell is empty!");
                }
            } else {
                MaterialToast.fireToast("No Cell Selected", "rounded");

            }
        }
        );

        //FIM 1160696

        firstButton.addClickHandler(event -> {
            if (activeCell != null) {
                String result = "";
                try {
                    activeCell.setContent(firstBox.getText());
                } catch (FormulaCompilationException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                    result = e.getMessage();
                } finally {
                    //resultLabel.setText(result);

                    // refresh the table...
                    customTable.getView().setRedraw(true);
                    customTable.getView().refresh();

                    // refresh the active cell
                    this.setActiveCell(activeCell);
                }
            }
            // Window.alert("Hello");
        });

//        firstButton.addClickHandler(event -> {
//            if (firstBox.getText().equals("form") || firstBox.getText().equals("FORM")) {
//                //Workbook wb = CurrentWorkbook.getCurrentWorkbook();
//                Workbook wb = new Workbook("Teste1", "Teste2", "");
//                /*Map<String, String> teste = new HashMap<>();
//                teste.put("Isep0", "Linha0");
//                teste.put("Isep1", "Linha1");
//                teste.put("Isep2", "Linha2");
//                teste.put("Isep3", "Linha3");
//                teste.put("Isep4", "Linha4");
//                teste.put("Isep5", "Linha5");
//                Form form = new Form(teste);
//                wb.insertNewForm(form);*/
//
//                if (!wb.formExists()) {
//                    new FormView(wb.getForm().getRows());
//                } else {
//                    Window.alert("This workbook dont have a form");
//                }
//            }
//        });

        exportToXMLButton.addClickHandler(event -> {
            new ExportToXMLView();
        });
        
        newSpreadsheetButton.addClickHandler((ClickEvent event) -> {
            new addSpreadsheetView();
        });


        /*Opens the prompt for the user to type the name of the CLS*/
        exportToCLSButton.addClickHandler(event -> {
            new ExportToCLSView(/*send the current workbook*/this.getActiveCell().getSpreadsheet().getWorkbook());
        });

        macrosButton.addClickHandler(event -> {
            MacrosView macrosView = new MacrosView();
        });


        searchButton.addClickHandler(event -> {
            SearchView searchView = new SearchView();
        });

    exportToPdfButton.addClickHandler(event -> {
          new ExportToPdfView(this.getActiveCell().getSpreadsheet().getWorkbook());

       });

//        formButton.addClickHandler(event -> {
//            //Window.alert("Hello");
//            new FormEditorView();
//
//        });

        //1140420
        chartWizardButton.addClickHandler(event -> {
            new BasicChartWizardView(customTable.getRow(0).getData().sheet);
        });

        //1171715
        filterCellRange.addClickHandler(event -> {
            new FilterCellRangeView(customTable.getRow(0).getData().sheet);
        });
        
        dataTypeBox.add("Number");
        dataTypeBox.add("Text");
        dataTypeBox.add("Date");
        sortingTypeBox.add("Ascending");
        sortingTypeBox.add("Descending");
        sortButton.addClickHandler(event -> {
            // Show Loader
            MaterialLoader.loading(true);
            String sortingType = sortingTypeBox.getValue();
            String dataType = dataTypeBox.getValue();
            String lowerCell = lowerCellInfo.getText();
            String upperCell = upperCellInfo.getText();
            Spreadsheet sh = customTable.getRow(0).getData().sheet;
            sh.sortCells(upperCell, lowerCell, dataType, sortingType); //Still needs work
            List<SheetCell> rows = new ArrayList<>();
            for (int k = 0; k < sh.getRowCount(); k++) {
                rows.add(new SheetCell(sh, k));
            }
            customTable.clearRows(true);
            customTable.setRowData(0, rows);
            customTable.getView().setRedraw(true);
            customTable.getView().refresh();
            MaterialLoader.loading(false);
        });

        // It is possible to create your own custom renderer per table
        // When you use the BaseRenderer you can override certain draw
        // methods to create elements the way you would like.
        customTable.getView().setRenderer(new SheetRenderer<SheetCell>());

        editformat.addClickHandler(event -> {
            windowconditional.open();

        });

        confirm.addClickHandler(event -> {
            windowconditional.close();

        });

        initWorkbook();

        // Set the visible range of the table for pager (later)
        customTable.setVisibleRange(0, 2001);

        // Configure the tables long press duration configuration.
        // The short press is when a click is held less than this duration.
        customTable.setLongPressDuration(400);

        customTable.addRowContextMenuHandler(event -> {
            // Firing Row Context will automatically select the row where it was right
            // clicked
            customTable.selectRow($(event.getRow()).asElement(), true);
            popupMenu.setSelected(event.getModel());
            // Get the PageX and getPageY
            popupMenu.setPopupPosition(event.getMouseEvent().getPageX(), event.getMouseEvent().getPageY());
            popupMenu.open();
        });

        styleButton.addClickHandler(event -> {
            //Window.alert("Style Extension Activated");
            new StyleView();
            StyleView.confirmButton.addClickHandler(event1 -> {
                //String style = StyleView.styleChooser.getActivatorElement().getAttribute();
                //String cell= StyleView.cellInfo.getValue();
                //String option = StyleView.colorChooser.getActivatorElement().getAttribute();
                StyleView.styleWindow.close();
            });

        });


//        exportToCSVButton.addClickHandler(event -> {
//            MaterialWindow window = new MaterialWindow();
//            window.setPadding(32);
//            window.setHeight("600px");
//            window.setTextAlign(TextAlign.LEFT);
//            window.setTitle("Export to CSV");
//            MaterialWindow.setOverlay(true);
//            MaterialLabel label1 = new MaterialLabel("Please select what you wish to export:");
//            MaterialRadioButton radioButtonWorkbook = new MaterialRadioButton("radioButtonWorkbook", "Export Workbook");
//            MaterialRadioButton radioButtonWorksheet = new MaterialRadioButton("radioButtonWorksheet", "Export Spreadsheet");
//            MaterialRadioButton radioButtonPartOfWorksheet = new MaterialRadioButton("radioButtonPartOfWorksheet", "Export Part Of A Spreadsheet");
//            radioButtonWorkbook.setName("Export");
//            radioButtonWorksheet.setName("Export");
//            radioButtonPartOfWorksheet.setName("Export");
//
//            window.add(label1);
//
//            MaterialPanel p0 = new MaterialPanel();
//            MaterialPanel p1 = new MaterialPanel();
//            MaterialPanel p2 = new MaterialPanel();
//            p0.setTextAlign(TextAlign.LEFT);
//            p1.setTextAlign(TextAlign.LEFT);
//            p2.setTextAlign(TextAlign.LEFT);
//            p0.add(radioButtonWorkbook);
//            p1.add(radioButtonWorksheet);
//            p2.add(radioButtonPartOfWorksheet);
//            window.add(p0);
//            window.add(p1);
//            window.add(p2);
//
//            MaterialComboBox<Workbook> cworkbook = new MaterialComboBox<>();
//            cworkbook.setPlaceholder("Choose the Workbook you want to export");
//            cworkbook.setAllowClear(true);
//            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);
//
//            AsyncCallback<ArrayList<Workbook>> callback = new AsyncCallback<ArrayList<Workbook>>() {
//                @Override
//                public void onFailure(Throwable throwable) {
//                    MaterialToast.fireToast(throwable.getMessage());
//                }
//
//                @Override
//                public void onSuccess(ArrayList<Workbook> workbookDTOS) {
//                    for (Workbook w : workbookDTOS) {
//                        cworkbook.addItem(w);
//                    }
//                }
//            };
//            workbooksSvc.getWorkbooks(callback);
//
////            window.add(cworkbook);
//            MaterialComboBox<Spreadsheet> cspreadsheets = new MaterialComboBox();
//            cspreadsheets.setPlaceholder("Choose the Spreadsheet you want to export");
//            cspreadsheets.setAllowClear(true);
//            cworkbook.addClickHandler(new ClickHandler() {
//                @Override
//                public void onClick(ClickEvent clickEvent) {
//                    Workbook w = cworkbook.getSelectedValue().get(0);
//                    for (int i = 0; i < w.spreadsheets.size(); i++) {
//                        cspreadsheets.addItem(w.spreadsheets.get(i));
//                    }
//                }
//            });
//
////            window.add(cspreadsheets);
//            MaterialTextBox cellVertical = new MaterialTextBox();
//            cellVertical.setPlaceholder("Vertical Address of the cell (A1)");
//
//            MaterialTextBox cellHorizontal = new MaterialTextBox();
//            cellHorizontal.setPlaceholder("Horizontal Address of the cell (A1)");
//
//            MaterialTextBox name = new MaterialTextBox();
//            name.setPlaceholder("Name of the file");
//
//            cellVertical.setEnabled(true);
//            cellHorizontal.setEnabled(true);
//            name.setEnabled(true);
////            window.add(cellVertical);
////            window.add(cellHorizontal);
////            window.add(name);
//
//            MaterialLabel label2 = new MaterialLabel("Now select the delimiter of the CSV file:");
////            window.add(label2);
//
//            MaterialRadioButton comma = new MaterialRadioButton();
//            comma.setName("Delimiter");
//            comma.setText(",");
//
//            MaterialRadioButton commaPoint = new MaterialRadioButton();
//            commaPoint.setName("Delimiter");
//            commaPoint.setText(";");
//
//            MaterialRadioButton point = new MaterialRadioButton();
//            point.setName("Delimiter");
//            point.setText(".");
//
//            MaterialRadioButton barra = new MaterialRadioButton();
//            barra.setName("Delimiter");
//            barra.setText("/");
//
//            MaterialRadioButton twoPoints = new MaterialRadioButton();
//            twoPoints.setName("Delimiter");
//            twoPoints.setText(":");
//
//            MaterialPanel p3 = new MaterialPanel();
//            MaterialPanel p4 = new MaterialPanel();
//            MaterialPanel p5 = new MaterialPanel();
//            MaterialPanel p7 = new MaterialPanel();
//
//            p3.setTextAlign(TextAlign.LEFT);
//            p4.setTextAlign(TextAlign.LEFT);
//            p5.setTextAlign(TextAlign.LEFT);
//            p7.setTextAlign(TextAlign.LEFT);
//
//            p3.add(comma);
//            p4.add(commaPoint);
//            p5.add(barra);
//            p7.add(twoPoints);
//
////            window.add(p3);
////            window.add(p4);
////            window.add(p5);
////            window.add(p7);
//            MaterialButton exportCSV = new MaterialButton("EXPORT");
//            exportCSV.addClickHandler(evnt -> {
//                WorkbooksServiceAsync wsvc = GWT.create(WorkbooksService.class);
//                // Set up the callback object.
//                AsyncCallback<Workbook> cb = new AsyncCallback<Workbook>() {
//                    @Override
//                    public void onFailure(Throwable caught) {
//                        MaterialToast.fireToast("Error! " + caught.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(Workbook result) {
//                        MaterialToast.fireToast("Exported successfully!", "rounded");
//
//                    }
//                };
//            });
//
//            exportCSV.setWaves(WavesType.LIGHT);
//            exportCSV.setSize(ButtonSize.MEDIUM);
//            MaterialPanel p6 = new MaterialPanel();
//            p6.setTextAlign(TextAlign.RIGHT);
//            p6.add(exportCSV);
////            window.add(p6);
////            window.open();
//
//            radioButtonWorkbook.addClickHandler(new ClickHandler() {
//                @Override
//                public void onClick(ClickEvent clickEvent) {
//                    window.add(cworkbook);
//                    window.remove(cspreadsheets);
//                    window.remove(cellVertical);
//                    window.remove(cellHorizontal);
//                    window.add(name);
//                    window.add(label2);
//                    window.add(p3);
//                    window.add(p4);
//                    window.add(p5);
//                    window.add(p7);
//                    window.add(p6);
//                }
//            });
//
//            radioButtonWorksheet.addClickHandler(new ClickHandler() {
//                @Override
//                public void onClick(ClickEvent clickEvent) {
//                    window.add(cworkbook);
//                    window.add(cspreadsheets);
//                    window.remove(cellVertical);
//                    window.remove(cellHorizontal);
//                    window.add(name);
//                    window.add(label2);
//                    window.add(p3);
//                    window.add(p4);
//                    window.add(p5);
//                    window.add(p7);
//                    window.add(p6);
//                }
//            });
//
//            radioButtonPartOfWorksheet.addClickHandler(new ClickHandler() {
//                @Override
//                public void onClick(ClickEvent clickEvent) {
//                    window.add(cworkbook);
//                    window.add(cspreadsheets);
//                    window.add(cellVertical);
//                    window.add(cellHorizontal);
//                    window.add(name);
//                    window.add(label2);
//                    window.add(p3);
//                    window.add(p4);
//                    window.add(p5);
//                    window.add(p7);
//                    window.add(p6);
//                }
//            });
//
////            exportCSV.setWaves(WavesType.LIGHT);
////            exportCSV.setSize(ButtonSize.MEDIUM);
////            MaterialPanel p6 = new MaterialPanel();
////            p6.setTextAlign(TextAlign.RIGHT);
////            p6.add(exportCSV);
////            window.add(p6);
//
//            window.open();
//        });

        // Added access to ToolPanel to add icon widget
        Panel panel = customTable.getScaffolding().getToolPanel();
        panel.clear();
        panel.setVisible(false);

        customTable.getTableTitle().setText("The Future Worksheet!");
    }


    @Override
    protected void onAttach() {
        super.onAttach();

        // table.getTableTitle().setText("The Future Worksheet!");
    }

    protected static String[][] getDefaultContent(){
        String contents[][] = { // first spreadsheet
                {"10", "9", "8", "7", "a", "b", "c"}, {"8", "=1+7", "6", "5", "4", "3", "2"},
                {"1", "2", "3", "4", "5", "6", "7"}};
        return contents;
    }
}
