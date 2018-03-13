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
package pt.isep.nsheets.client.application.materialsheet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.data.component.CategoryComponent;
import gwt.material.design.client.data.component.RowComponent;
import gwt.material.design.client.ui.MaterialBadge;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.TableSubHeader;
import gwt.material.design.client.ui.table.cell.TextColumn;
import gwt.material.design.client.ui.table.cell.WidgetCell;
import gwt.material.design.client.ui.table.cell.WidgetColumn;
import gwt.material.design.jquery.client.api.JQueryElement;
import pt.isep.nsheets.client.application.table.Person;
import pt.isep.nsheets.client.application.table.factory.CustomCategoryFactory;
import pt.isep.nsheets.client.application.table.factory.PersonRowFactory;
import pt.isep.nsheets.client.application.table.renderer.CustomRenderer;
import pt.isep.nsheets.client.application.table.service.FakePersonService;
import pt.isep.nsheets.client.application.table.service.PersonServiceAsync;
import pt.isep.nsheets.client.ui.NavigatedView;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

import static gwt.material.design.jquery.client.api.JQuery.$;

//public class HomeView extends ViewImpl implements HomePresenter.MyView {
public class MaterialSheetView extends NavigatedView implements MaterialSheetPresenter.MyView {

	public static class CustomCategoryComponent extends CategoryComponent {
		public CustomCategoryComponent(String category) {
			super(category);
		}

		@Override
		protected void render(TableSubHeader subheader) {
			super.render(subheader);

			subheader.setOpenIcon(IconType.FOLDER_OPEN);
			subheader.setCloseIcon(IconType.FOLDER);
		}
	}

	// public Label getFirstLabel() {
	// return firstLabel;
	// }

	public MaterialTextBox getFirstBox() {
		return firstBox;
	}

	public MaterialButton getFirstButton() {
		return firstButton;
	}

	public MaterialLabel getResultLabel() {
		return resultLabel;
	}

	// @UiField Label firstLabel;
	@UiField
	MaterialTextBox firstBox;
	@UiField
	MaterialButton firstButton;
	@UiField
	MaterialLabel resultLabel;

	// Replace this with your actual service interface, like so:
	// private PersonServiceAsync personService = GWT.create(PersonService.class);
	// we are faking the service on the client side to avoid requiring a web server.
	private PersonServiceAsync personService = GWT.create(FakePersonService.class);

	// @UiField(provided = true)
	// MaterialInfiniteDataTable<Person> table;

//	@UiField
//	MaterialDataTable<Person> customTable;
	
	@UiField
	MaterialDataTable<SheetCell> customTable;
	
	@UiField
	MaterialPopupMenu popupMenu;

	interface Binder extends UiBinder<Widget, MaterialSheetView> {
	}

	// @Override
	// public void setInSlot(Object slot, IsWidget content) {
	// if (slot == SecondPresenter.SLOT_Second) {
	// //main.setWidget(content); // Falta actualizar isto!!!
	// } else {
	// super.setInSlot(slot, content);
	// }
	// }
	
	class SheetCell {
		
		private Spreadsheet sheet;
		private int row=-1;
		
		public SheetCell(Spreadsheet sheet, int row) {
			this.row=row;
			this.sheet=sheet;
		}
		
		pt.isep.nsheets.shared.core.Cell getCell(int column) {
			return this.sheet.getCell(column, this.row);
		}
	}

	void initWorkbook() {
		// Test the initialization of an Workbook

		String contents[][][] = { { // first spreadsheet
				{ "10", "9", "8", "7", "a", "b", "c" }, 
				{ "8",  "7", "6", "5", "4", "3", "2" },
				{ "1",  "2", "3", "4", "5", "6", "7" },				
			} };

		Workbook wb = new Workbook(contents);
		Spreadsheet sh = wb.getSpreadsheet(0);

		int columnNumber=0;
		
		// Add the columns...
		for (int i = 0; i < sh.getColumnCount(); ++i) {
			
			// Add a column for the column :-)
			customTable.addColumn(new SheetWidgetColumn(columnNumber));
			
			++columnNumber;
		}
		
		//int rowIndex = 0;
		List<SheetCell> rows = new ArrayList<>();
		for (int k = 0; k < sh.getRowCount(); k++) {
			rows.add(new SheetCell(sh, k));
		}
		customTable.setRowData(0, rows);

	}

	@Inject
	MaterialSheetView(Binder uiBinder) {
		// table = new MaterialInfiniteDataTable<>(20,
		// InfiniteDataView.DYNAMIC_VIEW, new PersonDataSource(personService));

		initWidget(uiBinder.createAndBindUi(this));
		
		initWorkbook();

		// We will define our own person row factory to generate the
		// category name. This can be used to generate your own
		// RowComponent's too, if custom functionality is required.
		// (ATB) customTable.setRowFactory(new PersonRowFactory());

		// If we want to generate all our categories using CustomCategoryComponent
		// We can define our own CategoryComponentFactory. There we can define our
		// own CategoryComponent implementations.
		// (ATB) customTable.setCategoryFactory(new CustomCategoryFactory());

		// It is possible to create your own custom renderer per table
		// When you use the BaseRenderer you can override certain draw
		// methods to create elements the way you would like.
		// (ATB) customTable.setRenderer(new CustomRenderer<>());

		// Now we will add our tables columns.
		// There are a number of methods that can provide custom column configurations.

		// (ATB)
//		customTable.addColumn(new TextColumn<Person>() {
//			@Override
//			public Comparator<? super RowComponent<Person>> sortComparator() {
//				return (o1, o2) -> o1.getData().getFirstName().compareToIgnoreCase(o2.getData().getFirstName());
//			}
//
//			@Override
//			public String getValue(Person object) {
//				return object.getFirstName();
//			}
//		}, "A");

		// (ATB)
//		customTable.addColumn(new TextColumn<Person>() {
//			@Override
//			public Comparator<? super RowComponent<Person>> sortComparator() {
//				return (o1, o2) -> o1.getData().getLastName().compareToIgnoreCase(o2.getData().getLastName());
//			}
//
//			@Override
//			public String getValue(Person object) {
//				return object.getLastName();
//			}
//		}, "B");

		// (ATB)
//		customTable.addColumn(new TextColumn<Person>() {
//			@Override
//			public boolean numeric() {
//				return true;
//			}
//
//			@Override
//			public HideOn hideOn() {
//				return HideOn.HIDE_ON_MED_DOWN;
//			}
//
//			@Override
//			public Comparator<? super RowComponent<Person>> sortComparator() {
//				return (o1, o2) -> o1.getData().getPhone().compareToIgnoreCase(o2.getData().getPhone());
//			}
//
//			@Override
//			public String getValue(Person object) {
//				return object.getPhone();
//			}
//		}, "C");

		// Example of a widget column!
		// You can add any handler to the column cells widget.
		// (ATB)
//		customTable.addColumn(new WidgetColumn<Person, MaterialLabel>() {
//
//			// instance initialize
//			{
//				this.setName("D");
//			}
//
//			@Override
//			public TextAlign textAlign() {
//				return TextAlign.CENTER;
//			}
//
//			@Override
//			public MaterialLabel getValue(Person object) {
//				MaterialLabel badge = new MaterialLabel();
//				badge.setText("badge " + object.getId());
//				badge.setBackgroundColor(Color.BLUE);
//				badge.setLayoutPosition(Style.Position.RELATIVE);
//
//				return badge;
//			}
//
//			@Override
//			public MaterialLabel render(Context context, Person object) {
//				MaterialLabel widget = getValue(object);
//
//				// Add a click handler...
//				widget.addClickHandler(event -> {
//					GWT.log("Column D clicked!");
//					// Window.alert("Row Double Clicked: " + event..getModel().getId());
//					Window.alert("Rendering cell in column number: " + context.getColumn() + " for Person object: "
//							+ object.getFirstName());
//				});
//
//				Cell<MaterialLabel> cell = getCell();
//				// ((WidgetCell<Person,MaterialLabel>)getCell()).render(context, object,
//				// widget);
//
//				GWT.log("Rendering cell in column number: " + context.getColumn() + " for Person object: "
//						+ object.getFirstName());
//
//				// this.
//				// This dimensions should be relative to the parent!!!
//				widget.setWidth("100%");
//				widget.setHeight("100%");
//
//				GWT.log("Styles: " + widget.toString());
//
//				return widget;
//			}
//		});

		// (ATB)
//		for (int i = 0; i < 8; i++) {
//			final int index = i;
//			customTable.addColumn(new TextColumn<Person>() {
//				@Override
//				public Comparator<? super RowComponent<Person>> sortComparator() {
//					return (o1, o2) -> o1.getData().getPhone().compareToIgnoreCase(o2.getData().getPhone());
//				}
//
//				@Override
//				public String getValue(Person object) {
//					return object.getPhone() + " " + index;
//				}
//			}, "Column " + index);
//		}

		// Set the visible range of the table for pager (later)
		customTable.setVisibleRange(0, 2001);

		// (ATB)
		// Generate 20 rows
//		int rowIndex = 0;
//		List<Person> people = new ArrayList<>();
//		for (int k = 1; k <= 2; k++) {
//			// Generate 10 rows
//			for (int i = 1; i <= 10; i++, rowIndex++) {
//				// people.add(new Person(i,
//				// "http://joashpereira.com/templates/material_one_pager/img/avatar1.png",
//				// "Field " + rowIndex, "Field " + i, "Field " + rowIndex, "No " + i,"Category "
//				// + k));
//				people.add(new Person(i, "http://joashpereira.com/templates/material_one_pager/img/avatar1.png",
//						"Field " + rowIndex, "Field " + i, "Field " + rowIndex, "No " + i, "Category " + "1"));
//
//			}
//		}
//		customTable.setRowData(0, people);


		
		// Here we are adding a row expansion handler.
		// This is invoked when a row is expanded.
		// table.addRowExpandingHandler(event -> {
		// JQueryElement section = event.getExpansion().getOverlay();

		// Fake Async Task
		// This is demonstrating a fake asynchronous call to load
		// the data inside the expansion element.
		// new Timer() {
		// @Override
		// public void run() {
		// // Clear the content first.
		// MaterialWidget content = new MaterialWidget(
		// event.getExpansion().getRow().find(".content").empty().asElement());
		//
		// // Add new content.
		// MaterialBadge badge = new MaterialBadge("This content", Color.WHITE,
		// Color.BLUE);
		// badge.getElement().getStyle().setPosition(Style.Position.RELATIVE);
		// badge.getElement().getStyle().setRight(0, Style.Unit.PX);
		// badge.setFontSize(12, Style.Unit.PX);
		// content.add(badge);
		//
		// MaterialButton btn = new MaterialButton("was made", ButtonType.RAISED, new
		// MaterialIcon(IconType.FULLSCREEN));
		// content.add(btn);
		//
		// MaterialTextBox textBox = new MaterialTextBox();
		// textBox.setText(" from an asynchronous");
		// textBox.setGwtDisplay(Style.Display.INLINE_TABLE);
		// textBox.setWidth("200px");
		// content.add(textBox);
		//
		// MaterialIcon icon = new MaterialIcon(IconType.CALL);
		// icon.getElement().getStyle().setPosition(Style.Position.RELATIVE);
		// icon.getElement().getStyle().setTop(12, Style.Unit.PX);
		// content.add(icon);
		//
		// // Hide the expansion elements overlay section.
		// // The overlay is retrieved using EowExpand#getOverlay()
		// section.css("display", "none");
		// }
		// }.schedule(2000);
		// });

		// Add a row select handler, called when a user selects a row.
		customTable.addRowSelectHandler(event -> {
			// GWT.log(event.getModel().getId() + ": " + event.isSelected());
//			GWT.log("Row Selected: " + event.getModel().getId() + ": " + event.isSelected() + ", x:"
//					+ event.getMouseEvent().getPageX() + ", y: " + event.getMouseEvent().getPageY());
		});

		// Add a sort column handler, called when a user sorts a column.
		customTable.addColumnSortHandler(event -> {
//			GWT.log("Sorted: " + event.getSortContext().getSortDir() + ", columnIndex: " + event.getColumnIndex());
//			customTable.getView().refresh();
		});

		// Add category opened handler, called when a category is opened.
		// table.addCategoryOpenedHandler(event -> {
		// GWT.log("Category Opened: " + event.getName());
		// });

		// Add category closed handler, called when a category is closed.
		// table.addCategoryClosedHandler(event -> {
		// GWT.log("Category Closed: " + event.getName());
		// });

		// Add a row double click handler, called when a row is double clicked.
		customTable.addRowDoubleClickHandler(event -> {
			// GWT.log("Row Double Clicked: " + model.getId() + ", x:" +
			// mouseEvent.getPageX() + ", y: " + mouseEvent.getPageY());
//			Window.alert("Row Double Clicked: " + event.getModel().getId());
		});

		// Configure the tables long press duration configuration.
		// The short press is when a click is held less than this duration.
		customTable.setLongPressDuration(400);

		// Add a row long press handler, called when a row is long pressed.
		customTable.addRowLongPressHandler(event -> {
			// GWT.log("Row Long Pressed: " + model.getId() + ", x:" + mouseEvent.getPageX()
			// + ", y: " + mouseEvent.getPageY());
		});

		// Add a row short press handler, called when a row is short pressed.
		customTable.addRowShortPressHandler(event -> {
			// GWT.log("Row Short Pressed: " + model.getId() + ", x:" +
			// mouseEvent.getPageX() + ", y: " + mouseEvent.getPageY());
		});

		popupMenu.addSelectionHandler(selectionEvent -> {
//			JQueryElement span = $(selectionEvent.getSelectedItem()).find("span");
//			for (Person per : customTable.getSelectedRowModels(false)) {
//				MaterialToast.fireToast($(span).asElement().getInnerHTML() + " : " + per.getFirstName());
//			}
		});

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
		MaterialIcon polyIcon = new MaterialIcon(IconType.POLYMER);
		polyIcon.setWaves(WavesType.LIGHT);
		polyIcon.setCircle(true);
		panel.add(polyIcon);

		/*
		 * // Add an image profile on each category rows table.addColumn(new
		 * WidgetColumn<Person, MaterialImage>() {
		 * 
		 * @Override public MaterialImage getValue(Person object) { MaterialImage
		 * profile = new MaterialImage(); profile.setUrl(object.getPicture());
		 * profile.setWidth("40px"); profile.setHeight("40px"); profile.setPadding(4);
		 * profile.setMarginTop(8); profile.setBackgroundColor(Color.GREY_LIGHTEN_2);
		 * profile.setCircle(true); return profile; } });
		 * 
		 * // Add the tables columns table.addColumn(new TextColumn<Person>() {
		 * 
		 * @Override public boolean isSortable() { return true; }
		 * 
		 * @Override public String getValue(Person object) { return
		 * object.getFirstName(); } }, "First Name");
		 * 
		 * table.addColumn(new TextColumn<Person>() {
		 * 
		 * @Override public boolean isSortable() { return true; }
		 * 
		 * @Override public String getValue(Person object) { return
		 * object.getLastName(); } }, "Last Name");
		 * 
		 * table.addColumn(new TextColumn<Person>() {
		 * 
		 * @Override public boolean isSortable() { return true; }
		 * 
		 * @Override public String getValue(Person object) { return object.getPhone(); }
		 * }, "Phone");
		 * 
		 * table.addRowSelectHandler(event -> {
		 * updateSelectedRows(table.getSelectedRowModels(false).size());
		 * GWT.log(event.getModel().getId() + ": " + event.isSelected()); });
		 * 
		 * table.addColumnSortHandler(event -> { GWT.log("Sorted: " +
		 * event.getSortContext().getSortDir() + ", columnIndex: " +
		 * event.getColumnIndex()); table.getView().refresh(); });
		 * 
		 * table.addSelectAllHandler(event -> {
		 * updateSelectedRows(table.getSelectedRowModels(false).size());
		 * GWT.log("Selected["+event.isSelected()+"]: " + event.getModels().size() +
		 * " models"); });
		 * 
		 */

		customTable.getTableTitle().setText("The Future Worksheet!");

		// loadCategories();
	}

	@Override
	protected void onAttach() {
		super.onAttach();

		// table.getTableTitle().setText("The Future Worksheet!");
		//
		// table.clearRowsAndCategories(true);
		//
		// loadCategories();
	}

	protected void loadCategories() {
		// Load the categories from the server
		customTable.getView().setLoadMask(true);

		personService.getCategories(new AsyncCallback<List<String>>() {
			@Override
			public void onSuccess(List<String> categories) {
				for (String category : categories) {
					customTable.addCategory(new CategoryComponent(category));
				}
				customTable.getView().setLoadMask(false);
			}

			@Override
			public void onFailure(Throwable throwable) {
				GWT.log("Getting people categories async call failed.", throwable);
			}
		});
	}

	// private void updateSelectedRows(int size) {
	// String word = " item ";
	// if(size > 1) {
	// word = " items ";
	// }
	// if(size <= 0) {
	// customTable.getTableTitle().setText("Table Title");
	// customTable.getScaffolding().getTopPanel().removeStyleName("active-header");
	// } else {
	// customTable.getScaffolding().getTopPanel().addStyleName("active-header");
	// customTable.getTableTitle().setText(size + word + "selected ");
	// }
	// }
}
