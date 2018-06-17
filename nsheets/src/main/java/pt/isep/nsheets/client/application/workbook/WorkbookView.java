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
import com.google.gwt.dom.client.Style;
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
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.client.lapr4.blue.s1.s1150585.forms.FormView;
//import pt.isep.nsheets.client.lapr4.blue.s1.s1150585.formsEditor.FormEditorView;
import pt.isep.nsheets.client.lapr4.blue.s1161248.BaseJavascriptLanguage.MacrosView;
import pt.isep.nsheets.client.lapr4.blue.s2.s1140420.basicChartWizard.BasicChartWizardView;
import pt.isep.nsheets.client.lapr4.blue.s2.s1171715.filterCellRange.FilterCellRangeView;
import pt.isep.nsheets.client.lapr4.blue.s3.s1140420ExportToPDF.ExportToPDFView;
import pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.exportToXML.ExportToXMLView;
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
import java.util.HashMap;
import pt.isep.nsheets.client.lapr4.blue.s2.s1091234.addSpreadsheet.addSpreadsheetView;
import pt.isep.nsheets.client.lapr4.blue.s2.s1171715.filterCellRange.FilterCellRangeView;
import pt.isep.nsheets.client.lapr4.blue.s3.s1150585.ExportToCSV.ExportCsvView;
import pt.isep.nsheets.client.lapr4.red.s1.s1160777.application.extensionmanager.LocalExtension;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;

import pt.isep.nsheets.shared.core.SpreadsheetImpl;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.RelationalOperator;
import pt.isep.nsheets.shared.lapr4.green.s1.lang.n1160696.StylesCell.StylesCellController;
import pt.isep.nsheets.shared.lapr4.green.s1.lang.n1160696.StylesCell.StylesCellExt;

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
    
    public MaterialLink getConditionalLinkStyle() {
        return conditionalLinkStyle;
    }
    
    public MaterialButton getBoldButton() {
         return boldButton;
     }
 
     public MaterialButton getItalicButton() {
         return italicButton;
     }
     
     /**
     * @return the alignLeftBtn
     */
    public MaterialButton getAlignLeftBtn() {
        return alignLeftBtn;
    }

    /**
     * @return the alignRightBtn
     */
    public MaterialButton getAlignRightBtn() {
        return alignRightBtn;
    }

    /**
     * @return the alignCenterBtn
     */
    public MaterialButton getAlignCenterBtn() {
        return alignCenterBtn;
    }

    /**
     * @return the underlineBtn
     */
    public MaterialButton getUnderlineBtn() {
        return underlineBtn;
    }

    /**
     * @return the cFillBtn
     */
    public MaterialButton getcFillBtn() {
        return cFillBtn;
    }

    /**
     * @return the cTextBtn
     */
    public MaterialButton getcTextBtn() {
        return cTextBtn;
    }

    //1160696
    List<MaterialRadioButton> falseColorButtons = new ArrayList<>();
    List<MaterialRadioButton> falseFontButtons = new ArrayList<>();
    List<MaterialRadioButton> formulasButtons = new ArrayList<>();
    List<MaterialRadioButton> trueColorButtons = new ArrayList<>();
    List<MaterialRadioButton> trueFontButtons = new ArrayList<>();
    
    @UiField
    MaterialButton confirmBG;

//    @UiField
//    MaterialCollapsible backgroundColorColaps;

    @UiField
     MaterialButton colorTextButton;
 
    @UiField
    MaterialButton confirmTXT;

//    @UiField
//    MaterialCollapsible textColorColaps;
    
    @UiField
    MaterialCollection backgroundColor;

    @UiField
    MaterialCollection textColor;
    
    List<MaterialRadioButton> backgroundColorButtons = new ArrayList<>();
    List<MaterialRadioButton> textColorButtons = new ArrayList<>();
    
    @UiField
    MaterialButton alignLeftBtn;
    
    @UiField
    MaterialButton alignRightBtn;
    
    @UiField
    MaterialButton alignCenterBtn;
    
    @UiField
    MaterialButton underlineBtn;
    
    @UiField
    MaterialButton cFillBtn;
    
    @UiField
    MaterialButton cTextBtn;
    
    @UiField
    MaterialCollapsible colapStyle;

    @UiField
    MaterialLink conditionalLinkStyle;
    
    @UiField
    MaterialButton boldButton;

    @UiField
    MaterialButton italicButton;

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
    
    //1160696
    HashMap<Cell, StylesCellExt> extCells = new HashMap<>();
    private static final int ITALIC = 1;
    private static final int BOLD = 2;
    private static final int ALIGN_CENTER = 3;
    private static final int ALIGN_LEFT = 4;
    private static final int ALIGN_RIGHT = 5;
    private static final int UNDERLINE = 6;
    private static final int BG_COLOR = 7;
    private static final int TXT_COLOR = 8;
    //1160696
    
    

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
        Spreadsheet sh = new SpreadsheetImpl(wb, "sheet", contents);

        CurrentWorkbook.setCurrentWorkbook(wb);

        CurrentWorkbook.setCurrentSpreadsheet(sh);

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
        
        //Core08.1 - 1160696
        
        StylesCellController scc = new StylesCellController();
        
        boldButton.addClickHandler(event -> {
            
                        
            if (!extCells.containsKey(activeCell)) {
                StylesCellExt extension = new StylesCellExt();
                extCells.put(activeCell, extension);
            }
            StylesCellExt extension = extCells.get(activeCell);
            scc.setChosenExtension(extension);
            extension.setFontWeight(Style.FontWeight.BOLD);
            doStyleExt(BOLD);

        });

        italicButton.addClickHandler(event -> {
            
            if (!extCells.containsKey(activeCell)) {
                StylesCellExt extension = new StylesCellExt();
                extCells.put(activeCell, extension);
            }
            StylesCellExt extension = new StylesCellExt();
            extCells.put(activeCell, extension);
            scc.setChosenExtension(extension);
            extension.setFontStyle(Style.FontStyle.ITALIC);
            doStyleExt(ITALIC);

        });
        
        alignLeftBtn.addClickHandler(event -> {
           
            if (!extCells.containsKey(activeCell)) {
                StylesCellExt extension = new StylesCellExt();
                extCells.put(activeCell, extension);
            }
            StylesCellExt extension = new StylesCellExt();
            extCells.put(activeCell, extension);
            scc.setChosenExtension(extension);
            extension.setTextAlign(TextAlign.LEFT);
            doStyleExt(ALIGN_LEFT);
            
        });
        
        alignRightBtn.addClickHandler(event -> {
           
            if (!extCells.containsKey(activeCell)) {
                StylesCellExt extension = new StylesCellExt();
                extCells.put(activeCell, extension);
            }
            StylesCellExt extension = new StylesCellExt();
            extCells.put(activeCell, extension);
            scc.setChosenExtension(extension);
            extension.setTextAlign(TextAlign.RIGHT);
            doStyleExt(ALIGN_RIGHT);
            
        });
        
        alignCenterBtn.addClickHandler(event -> {
           
            if (!extCells.containsKey(activeCell)) {
                StylesCellExt extension = new StylesCellExt();
                extCells.put(activeCell, extension);
            }
            StylesCellExt extension = new StylesCellExt();
            extCells.put(activeCell, extension);
            scc.setChosenExtension(extension);
            extension.setTextAlign(TextAlign.CENTER);
            doStyleExt(ALIGN_CENTER);
            
        });
        
        underlineBtn.addClickHandler(event -> {
           
            if (!extCells.containsKey(activeCell)) {
                StylesCellExt extension = new StylesCellExt();
                extCells.put(activeCell, extension);
            }
            StylesCellExt extension = new StylesCellExt();
            extCells.put(activeCell, extension);
            scc.setChosenExtension(extension);
            extension.setUnderline(Style.TextDecoration.UNDERLINE);
            doStyleExt(UNDERLINE);
            
        });
        
        
        MaterialCollection bgColors = new MaterialCollection();
        
        
        for (Color color : Color.values()) {
            MaterialRadioButton bg = new MaterialRadioButton("bg");
            
            
            bg.setText(color.name());
//            mb.setBackgroundColor(x);
            backgroundColorButtons.add(bg);
            bgColors.add(bg);
        }

        backgroundColor.add(bgColors);

        MaterialCollection tColors = new MaterialCollection();
        for (Color color : Color.values()) {
            MaterialRadioButton bg = new MaterialRadioButton("bg");
            
            
            bg.setText(color.name());
//            mb.setBackgroundColor(x);
            textColorButtons.add(bg);
            textColor.add(bg);
        }

        textColor.add(tColors);
        
        confirmBG.addClickHandler(event -> {
            
            
            if (activeCell != null) {
                
                if (!extCells.containsKey(activeCell)) {
                    
                    
                    StylesCellExt extension = new StylesCellExt();
                    extCells.put(activeCell, extension);
                    
               }
                
                
                StylesCellExt extension = extCells.get(activeCell);
                scc.setChosenExtension(extension);
                String colorA = "";
                
                
                for (MaterialRadioButton bgcb : backgroundColorButtons) {
                    if (bgcb.getValue()) {
                        colorA = bgcb.getText();
                        break;
                    }
                }
                
                
                Color set = extension.DEFAULT_BACKGROUND_COLOR;
                
                
                for (Color colorB : Color.values()) {
                    if (colorB.name().compareToIgnoreCase(colorA) == 0) {
                        set = colorB;
                        break;
                    }
                }

                extension.setBackgroundColor(set);
                doStyleExt(BG_COLOR);
//                backgroundColorColaps.closeAll();
            }
        
        });
        
        
        confirmTXT.addClickHandler(event -> {
            
            
            if (activeCell != null) {
                
                if (!extCells.containsKey(activeCell)) {
                    
                    
                    StylesCellExt extension = new StylesCellExt();
                    extCells.put(activeCell, extension);
                    
               }
                
                
                StylesCellExt extension = extCells.get(activeCell);
                scc.setChosenExtension(extension);
                String colorA = "";
                
                
                for (MaterialRadioButton tcb : textColorButtons) {
                    if (tcb.getValue()) {
                        colorA = tcb.getText();
                        break;
                    }
                }
                
                
                Color set = extension.DEFAULT_BACKGROUND_COLOR;
                
                
                for (Color colorB : Color.values()) {
                    if (colorB.name().compareToIgnoreCase(colorA) == 0) {
                        set = colorB;
                        break;
                    }
                }

                extension.setTextColor(set);
                doStyleExt(TXT_COLOR);
//                backgroundColorColaps.closeAll();
            }
        
        });
        
        
       //Core08.1 - 1160696
        
        
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
                    this.negativeColors();
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

        //1140420 Rodrigo
        exportToPdfButton.addClickHandler(event -> {
            new ExportToPDFView(this.getActiveCell().getSpreadsheet().getWorkbook());
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

        exportToCSVButton.addClickHandler(event -> {
            new ExportCsvView(this.getActiveCell().getSpreadsheet().getWorkbook());
        });

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

    protected static String[][] getDefaultContent() {
        String contents[][] = { // first spreadsheet
            {"10", "9", "8", "7", "a", "b", "c"}, {"8", "=1+7", "6", "5", "4", "3", "2"},
            {"1", "2", "3", "4", "5", "6", "7"}};
        return contents;
    }

    public boolean isNumeric(String s) {
        return s.matches("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)");
    }

    private int negativeColors() {
        int rows = this.customTable.getRowCount();
        int columns = this.customTable.getRow(0).getWidget().getWidgetCount();
        for (int a = 0; a < rows; a++) {
            for (int b = 1; b < columns; b++) {
                if (isNumeric(customTable.getRow(a).getWidget().getColumn(b).getElement().getInnerText())) {

                    Double content = Double.parseDouble(customTable.getRow(a).getWidget().getColumn(b).getElement().getInnerText());
                    if (content > 0) {
                        customTable.getRow(a).getWidget().getColumn(b).getElement().getStyle().setBackgroundColor(LocalExtension.getInstance().getColor1());
                    } else {
                        customTable.getRow(a).getWidget().getColumn(b).getElement().getStyle().setBackgroundColor(LocalExtension.getInstance().getColor2());
                    }
                }
            }

        }
        customTable.getRow(0).getWidget().getColumn(1).getBackgroundColor().getCssName();

        return 0;

    }
    
    
    private void doStyleExt(int t) {
        switch (t) {
            case BOLD:
                for (Cell cell : extCells.keySet()) {
                    customTable.getRow(cell.getAddress().getRow()).getWidget().getColumn(cell.getAddress().getColumn() + 1).setFontWeight(extCells.get(cell).getFontWeight());
                }   break;
            case ITALIC:
                for (Cell cell : extCells.keySet()) {
                    customTable.getRow(cell.getAddress().getRow()).getWidget().getColumn(cell.getAddress().getColumn() + 1).getElement().getStyle().setFontStyle(extCells.get(cell).getFontStyle());
                }   break;
            case ALIGN_LEFT:
                for(Cell cell : extCells.keySet()){
                    customTable.getRow(cell.getAddress().getRow()).getWidget().getColumn(cell.getAddress().getColumn() + 1).setTextAlign(TextAlign.LEFT);
                }   break;
            case ALIGN_RIGHT:
                for(Cell cell : extCells.keySet()){
                    customTable.getRow(cell.getAddress().getRow()).getWidget().getColumn(cell.getAddress().getColumn() + 1).setTextAlign(TextAlign.RIGHT);
                } break;
            case ALIGN_CENTER:
                for(Cell cell : extCells.keySet()){
                    customTable.getRow(cell.getAddress().getRow()).getWidget().getColumn(cell.getAddress().getColumn() + 1).setTextAlign(TextAlign.CENTER);
                } break;
            case UNDERLINE:
                for(Cell cell : extCells.keySet()){
                    customTable.getRow(cell.getAddress().getRow()).getWidget().getColumn(cell.getAddress().getColumn() + 1).getElement().getStyle().setTextDecoration(extCells.get(cell).getUnderline());
                } break;
            case BG_COLOR:
                for(Cell cell : extCells.keySet()){
                    customTable.getRow(cell.getAddress().getRow()).getWidget().getColumn(cell.getAddress().getColumn() + 1).setBackgroundColor(extCells.get(cell).getBackgroundColor());
                } break;
            case TXT_COLOR:
                for(Cell cell : extCells.keySet()){
                    customTable.getRow(cell.getAddress().getRow()).getWidget().getColumn(cell.getAddress().getColumn() + 1).setTextColor(extCells.get(cell).getTextColor());
                } break;
            default:
                break;
        }
    }
}
