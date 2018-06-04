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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

import com.google.gwt.user.client.ui.Widget;

import com.gwtplatform.mvp.client.ViewImpl;

import com.google.gwt.user.client.ui.Panel;
import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.ButtonSize;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.client.lapr4.blue.s1161248.BaseJavascriptLanguage.MacrosView;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import static gwt.material.design.jquery.client.api.JQuery.$;
import pt.isep.nsheets.client.lapr4.blue.s1.s1150585.formsEditor.FormEditorView;

// public class HomeView extends ViewImpl implements HomePresenter.MyView {
// public class WorkbookView extends NavigatedView implements WorkbookPresenter.MyView {
public class WorkbookView extends ViewImpl implements WorkbookPresenter.MyView {

    public MaterialTextBox getFirstBox() {
        return firstBox;
    }

    public MaterialIcon getFirstButton() {
        return firstButton;
    }

    @UiField
    MaterialTextBox firstBox;
    @UiField
    MaterialIcon firstButton;
    @UiField
    MaterialButton exportToXMLButton;
    @UiField
    MaterialButton macrosButton;

    @UiField
    MaterialButton exportToCSVButton;

    @UiField
    MaterialDataTable<SheetCell> customTable;

    @UiField
    MaterialPopupMenu popupMenu;

    @UiField
    MaterialIcon formButton;

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

    void initWorkbook() {
        // Test the initialization of an Workbook

        String contents[][] = { // first spreadsheet
                {"10", "9", "8", "7", "a", "b", "c"}, {"8", "=1+7", "6", "5", "4", "3", "2"},
                {"1", "2", "3", "4", "5", "6", "7"}};

        Workbook wb = new Workbook("Workbook", "New Workbook", contents);
        Spreadsheet sh = wb.getSheet();


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
    WorkbookView(Binder uiBinder) {

        initWidget(uiBinder.createAndBindUi(this));

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

        exportToXMLButton.addClickHandler(event -> {
            MaterialWindow window = new MaterialWindow();
            window.setPadding(32);
            window.setHeight("600px");
            window.setTextAlign(TextAlign.LEFT);
            window.setTitle("Export to XML");
            MaterialWindow.setOverlay(true);
            MaterialLabel label1 = new MaterialLabel("Please select what you wish to export.");
            MaterialRadioButton radioButtonWorkbook = new MaterialRadioButton("radioButtonWorkbook", "Export Workbook");
            MaterialRadioButton radioButtonWorksheet = new MaterialRadioButton("radioButtonWorksheet", "Export Worksheet");
            MaterialRadioButton radioButtonPartOfWorksheet = new MaterialRadioButton("radioButtonPartOfWorksheet", "Export Part Of A Worksheet");
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
            MaterialTextBox textBox1 = new MaterialTextBox("Please insert the column you like to start importing");
            MaterialTextBox textBox2 = new MaterialTextBox("Please insert the line you like to start importing");
            MaterialTextBox textBox3 = new MaterialTextBox("Please insert the column you like to finish importing");
            MaterialTextBox textBox4 = new MaterialTextBox("Please insert the line you like to finish importing");
            textBox1.setEnabled(false);
            textBox2.setEnabled(false);
            textBox3.setEnabled(false);
            textBox4.setEnabled(false);
            window.add(textBox1);
            window.add(textBox2);
            window.add(textBox3);
            window.add(textBox4);
            MaterialButton btnPartFields = new MaterialButton("Apply");
            btnPartFields.setWaves(WavesType.LIGHT);
            btnPartFields.setSize(ButtonSize.MEDIUM);
            btnPartFields.setEnabled(false);
            MaterialPanel p3 = new MaterialPanel();
            p3.setTextAlign(TextAlign.LEFT);
            p3.add(btnPartFields);
            window.add(p3);
            MaterialButton btnExport = new MaterialButton("Export");
            btnExport.setWaves(WavesType.LIGHT);
            btnExport.setSize(ButtonSize.MEDIUM);
            MaterialPanel p4 = new MaterialPanel();
            p4.setTextAlign(TextAlign.RIGHT);
            p4.add(btnExport);
            window.add(p4);

            window.open();
        });


        macrosButton.addClickHandler(event -> {
            MacrosView macrosView = new MacrosView();
        });

        formButton.addClickHandler(event -> {
            //Window.alert("Hello");
            new FormEditorView();

        });

        // It is possible to create your own custom renderer per table
        // When you use the BaseRenderer you can override certain draw
        // methods to create elements the way you would like.
        customTable.getView().setRenderer(new SheetRenderer<SheetCell>());

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

        exportToCSVButton.addClickHandler(event -> {
            MaterialWindow window = new MaterialWindow();
            window.setPadding(32);
            window.setHeight("600px");
            window.setTextAlign(TextAlign.LEFT);
            window.setTitle("Export to CSV");
            MaterialWindow.setOverlay(true);
            MaterialLabel label1 = new MaterialLabel("Please select what you wish to export.");
            MaterialRadioButton radioButtonWorkbook = new MaterialRadioButton("radioButtonWorkbook", "Export Workbook");
            MaterialRadioButton radioButtonWorksheet = new MaterialRadioButton("radioButtonWorksheet", "Export Worksheet");
            MaterialRadioButton radioButtonPartOfWorksheet = new MaterialRadioButton("radioButtonPartOfWorksheet", "Export Part Of A Worksheet");
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
            MaterialTextBox textBox1 = new MaterialTextBox("Please insert the column you like to start importing");
            MaterialTextBox textBox2 = new MaterialTextBox("Please insert the line you like to start importing");
            MaterialTextBox textBox3 = new MaterialTextBox("Please insert the column you like to finish importing");
            MaterialTextBox textBox4 = new MaterialTextBox("Please insert the line you like to finish importing");
            textBox1.setEnabled(false);
            textBox2.setEnabled(false);
            textBox3.setEnabled(false);
            textBox4.setEnabled(false);
            window.add(textBox1);
            window.add(textBox2);
            window.add(textBox3);
            window.add(textBox4);
            MaterialButton btnPartFields = new MaterialButton("Apply");
            btnPartFields.setWaves(WavesType.LIGHT);
            btnPartFields.setSize(ButtonSize.MEDIUM);
            btnPartFields.setEnabled(false);
            MaterialPanel p3 = new MaterialPanel();
            p3.setTextAlign(TextAlign.LEFT);
            p3.add(btnPartFields);
            window.add(p3);
            MaterialButton btnExport = new MaterialButton("Export");
            btnExport.setWaves(WavesType.LIGHT);
            btnExport.setSize(ButtonSize.MEDIUM);
            MaterialPanel p4 = new MaterialPanel();
            p4.setTextAlign(TextAlign.RIGHT);
            p4.add(btnExport);
            window.add(p4);
            window.open();
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
}
