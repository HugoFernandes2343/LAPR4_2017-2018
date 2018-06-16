package pt.isep.nsheets.client.lapr4.blue.s2.s1171715.filterCellRange;

import gwt.material.design.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;

import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;

import java.util.ArrayList;
import java.util.List;

public class FilterCellRangeView extends Composite{

    @UiField
    MaterialWindow filterCellRangeWindow;

    @UiField
    MaterialTextBox formulaBox, upperCellInfo, lowerCellInfo;

    @UiField
    MaterialButton filterCellsButton;

    private static FilterCellRangeBinder uiBinder = GWT.create(FilterCellRangeBinder.class);

    interface FilterCellRangeBinder extends UiBinder<Widget, FilterCellRangeView> {
    }

    private Cell[][] range;
    private int column;
    private String formula;

    public FilterCellRangeView(Spreadsheet spreadsheet) {
        initWidget(uiBinder.createAndBindUi(this));

        filterCellRangeWindow.open();

        filterCellsButton.addClickHandler(event -> {

            String formula = formulaBox.getValue();
            String upperCell = upperCellInfo.getText();
            String lowerCell = lowerCellInfo.getText();

            Address upperAdd = spreadsheet.findAddress(upperCell);
            Address lowerAdd = spreadsheet.findAddress(lowerCell);

            range = spreadsheet.getCellRangeMatrix(upperAdd, lowerAdd);
            column = upperAdd.getColumn();
        });
    }

    /**
     * Evaluates a Formula in a specified Cell range.
     * Dummy method for now, as it returns rows "1" and "3", always
     * @return the indexes (ints) of the Rows that are to be
     * disabled
     */
    public List<Integer> evaluate (){
        List<Integer> result = new ArrayList<>();

        result.add(1);
        result.add(3);

        return result;
    }
}
