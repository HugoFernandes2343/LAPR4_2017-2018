package pt.isep.nsheets.client.application.workbook;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.dom.client.Style;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.table.cell.WidgetColumn;
import pt.isep.nsheets.client.application.workbook.WorkbookView.SheetCell;

public class SheetWidgetColumn extends WidgetColumn<SheetCell, MaterialLabel> {

	/** The lowest character to be used in a column name */
	public static final char LOWEST_CHAR = 'A';

	/** The highest character to be used in a column name */
	public static final char HIGHEST_CHAR = 'Z';
	
	private WorkbookView view=null;
	
	private int colNumber=-1;
	
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
	public SheetWidgetColumn(int column, WorkbookView view)
	{
		this.view=view;
		this.colNumber=column;
		if (this.colNumber>=0)
			this.setName(getColumnName());
	}

	@Override
	public TextAlign textAlign() {
		return TextAlign.CENTER;
	}

	@Override
	public MaterialLabel getValue(SheetCell object) {
		MaterialLabel badge = new MaterialLabel();
		if (this.colNumber==-1)
			badge.setText(""+(object.getCell(0).getAddress().getRow()+1));
		else
			badge.setText(object.getCell(this.colNumber).getValue().toString());
		//badge.setBackgroundColor(Color.BLUE);
		badge.setLayoutPosition(Style.Position.RELATIVE);

		return badge;
	}

	@Override
	public MaterialLabel render(Context context, SheetCell object) {
		MaterialLabel widget = getValue(object);

		// Add a click handler...
		widget.addClickHandler(event -> {
			if (context.getColumn()>0) {
				this.view.setActiveCell(object.getCell(context.getColumn()-1));
//				this.view.getTable().getTableTitle().setText(object.getCell(context.getColumn()-1).toString()+": "+object.getCell(context.getColumn()-1).getContent().toString());
//				this.view.getFirstBox().setText(object.getCell(context.getColumn()-1).getContent().toString());
			}
		});

		return widget;
	}
}
