package pt.isep.nsheets.client.application.workbook;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;

import java.util.ArrayList;
import java.util.SortedSet;

public class SearchView extends ViewImpl {

    @UiField
    public static MaterialWindow searchWindow;

    @UiField
    MaterialNavBar navBar, navBarSearch;

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialSearch txtSearch;

    ////  MaterialLabel lblAddress, lblContent;


    private static pt.isep.nsheets.client.application.workbook.SearchView.SearchViewUiBinder uiBinder = GWT.create(pt.isep.nsheets.client.application.workbook.SearchView.SearchViewUiBinder.class);

    interface SearchViewUiBinder extends UiBinder<Widget, pt.isep.nsheets.client.application.workbook.SearchView> {

    }

    public SearchView() {
        initWidget(uiBinder.createAndBindUi(this));
        searchWindow.open();

        txtSearch.addOpenHandler(openEvent -> {
            navBar.setVisible(false);
            navBarSearch.setVisible(true);
        });

        // Add Close Handler
        txtSearch.addCloseHandler(event -> {
            navBar.setVisible(true);
            navBarSearch.setVisible(false);
            refreshView();
            ;
        });

        txtSearch.addValueChangeHandler((ValueChangeEvent<String> event) -> {
            try {
                refreshViewSearch(event.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @UiHandler("btnSearch")
    void onSearch(ClickEvent e) {
        txtSearch.open();
    }

    private void refreshView() {
        htmlPanel.clear();
    }

    private void refreshViewSearch(String pattern) throws Exception {
        searchWB(pattern);
    }

    private void searchWB(String parameter) throws Exception {



        //Supposedly it should be this code that would be inplemented, but since the current workbook is not currently set in anyway while running the program i used the hard coded default content matrix.
       /* ArrayList<Spreadsheet> spreads = (ArrayList<Spreadsheet>) CurrentWorkbook.getCurrentWorkbook().iterator();
        ArrayList<SpreadsheetDTO> dtos = new ArrayList<>();

        for (Spreadsheet s : spreads) {
            dtos.add(s.toDTO());
        }
         for (SpreadsheetDTO d : dtos) {
            String[][] matrix = d.getContent();
        */

        //  String contents[][] = { // first spreadsheet
        //                {"10", "9", "8", "7", "a", "b", "c"}, {"8", "=1+7", "6", "5", "4", "3", "2"},
        //                {"1", "2", "3", "4", "5", "6", "7"}};
        // is the matrix

        htmlPanel.clear();


        Workbook wb = new Workbook();
        String[][] matrix = WorkbookView.getDefaultContent();
        wb.addSpreadsheet(matrix);


        int colCount = 1;

        MaterialRow row = null;

        ArrayList<Spreadsheet> sheets = (ArrayList<Spreadsheet>) wb.getSpreadsheets();
        for (Spreadsheet s:sheets) {
            Address add1 = new Address(0,0);
            Address add2 = new Address(s.getColumnCount()-1,s.getRowCount()-1);
            SortedSet<Cell> cells = s.getCells(add1,add2);
            for (Cell c:cells) {
                if(c.getValue().toString().contains(parameter) || c.getContent().contains(parameter)){

                    MaterialCard card = createCard(c.getAddress(),c.getContent(),c.getValue().toString());

                    if (colCount == 1) {
                        row = new MaterialRow();
                        htmlPanel.add(row);
                        ++colCount;
                        if (colCount >= 3) {
                            colCount = 1;
                        }
                    }

                    MaterialColumn col = new MaterialColumn();
                    col.setGrid("l4");
                    row.add(col);

                    col.add(card);
                }
            }
        }
/*
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {

                if (matrix[i][j].contains(parameter)) {
                    MaterialCard card = createCard(i, j, matrix[i][j]);

                    if (colCount == 1) {
                        row = new MaterialRow();
                        htmlPanel.add(row);
                        ++colCount;
                        if (colCount >= 2) {
                            colCount = 1;
                        }
                    }

                    MaterialColumn col = new MaterialColumn();
                    row.add(col);
                    col.setGrid("l5");
                    col.add(card);

                }

            }
        }*/
        // }

    }

    private MaterialCard createCard(Address address,String content, String value) {
        MaterialCard card = new MaterialCard();

        MaterialCardContent cardContent = new MaterialCardContent();

        MaterialCardTitle cardTitle = new MaterialCardTitle();

        MaterialLabel label = new MaterialLabel();
        MaterialLabel label2 = new MaterialLabel();

        cardContent.setTextColor(Color.BLUE);

        cardTitle.setText(content);
        cardTitle.setIconPosition(IconPosition.RIGHT);

        label.setText("Row " + (address.getRow()+1) + " Column " + (address.getColumn()+1));
        label2.setText("Value: "+ value);

        cardContent.add(cardTitle);
        cardContent.add(label);
        cardContent.add(label2);

        card.add(cardContent);

        return card;

    }
}

