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
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import static gwt.material.design.jquery.client.api.JQuery.$;

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
	MaterialDataTable<SheetCell> customTable;

	@UiField
	MaterialPopupMenu popupMenu;

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

		String contents[][][] = { { // first spreadsheet
				{ "10", "9", "8", "7", "a", "b", "c" }, { "8", "=1+7", "6", "5", "4", "3", "2" },
				{ "1", "2", "3", "4", "5", "6", "7" }, } };

		Workbook wb = new Workbook(contents);
		Spreadsheet sh = wb.getSpreadsheet(0);

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
