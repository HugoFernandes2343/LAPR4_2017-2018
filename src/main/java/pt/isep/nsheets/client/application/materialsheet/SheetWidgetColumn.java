package pt.isep.nsheets.client.application.materialsheet;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.table.cell.WidgetColumn;
import pt.isep.nsheets.client.application.materialsheet.MaterialSheetView.SheetCell;

public class SheetWidgetColumn extends WidgetColumn<SheetCell, MaterialLabel> {

	/** The lowest character to be used in a column name */
	public static final char LOWEST_CHAR = 'A';

	/** The highest character to be used in a column name */
	public static final char HIGHEST_CHAR = 'Z';
	
	int colNumber=-1;
	
	public String getColumnName() {
		String columnStr;
		int tempColumn = this.colNumber;
			for (columnStr = ""; tempColumn >= 0; tempColumn = tempColumn
					/ (HIGHEST_CHAR - LOWEST_CHAR + 1) - 1)
				columnStr = (char)((char)(tempColumn % (HIGHEST_CHAR
					- LOWEST_CHAR + 1)) + LOWEST_CHAR) + columnStr;
			return columnStr;
	}

	
	// instance initialize
	public SheetWidgetColumn(int column)
	{
		this.colNumber=column;
		this.setName(getColumnName());
	}

	@Override
	public TextAlign textAlign() {
		return TextAlign.CENTER;
	}

	@Override
	public MaterialLabel getValue(SheetCell object) {
		MaterialLabel badge = new MaterialLabel();
		badge.setText(object.getCell(this.colNumber).getValue().toString());
		badge.setBackgroundColor(Color.BLUE);
		badge.setLayoutPosition(Style.Position.RELATIVE);

		return badge;
	}

	@Override
	public MaterialLabel render(Context context, SheetCell object) {
		MaterialLabel widget = getValue(object);

		// Add a click handler...
		widget.addClickHandler(event -> {
			GWT.log("Column D clicked!");
			// Window.alert("Row Double Clicked: " + event..getModel().getId());
			Window.alert("Rendering cell in column number: " + context.getColumn() + " for Person object: "
					/* + object.getFirstName()  */ );
		});

		Cell<MaterialLabel> cell = getCell();
		// ((WidgetCell<Person,MaterialLabel>)getCell()).render(context, object,
		// widget);

		GWT.log("Rendering cell in column number: " + context.getColumn() + " for Person object: "
				/* + object.getFirstName() */ );

		// this.
		// This dimensions should be relative to the parent!!!
		widget.setWidth("100%");
		widget.setHeight("100%");

		GWT.log("Styles: " + widget.toString());

		return widget;
	}
}
