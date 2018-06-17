/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1150585.ExportCSV.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author dftsf
 */
public class CSVUtils {
    
    public static List<String[][]> exportWorkbook(Workbook workbook) {
        List<String[][]> returnList = new ArrayList<>();
        Iterator<Spreadsheet> spreadsheetIterator = workbook.iterator();

        while (spreadsheetIterator.hasNext()) {
            returnList.add(exportSpreadsheet(spreadsheetIterator.next()));
        }

        return returnList;
    }

    public static List<Address[][]> exportWorkbookSpreadsheetAddress(Workbook workbook) {
        List<Address[][]> addressList = new ArrayList<>();
        Iterator<Spreadsheet> spreadsheetIterator = workbook.iterator();

        while (spreadsheetIterator.hasNext()) {
            addressList.add(exportSpreadsheetAddress(spreadsheetIterator.next()));
        }

        return addressList;
    }

    public static String[][] exportSpreadsheet(Spreadsheet spreadsheet) {
        int spreadsheetColumnCount = spreadsheet.getColumnCount();
        int spreadsheetRowCount = spreadsheet.getRowCount();

        String result[][] = new String[spreadsheetRowCount][spreadsheetColumnCount];

        for (int i = 0; i < spreadsheetRowCount; i++) {
            for (int j = 0; j < spreadsheetColumnCount; j++) {
                result[i][j] = exportCell(spreadsheet, j, i);
            }
        }

        return result;
    }

    public static Address[][] exportSpreadsheetAddress(Spreadsheet spreadsheet) {
        int spreadsheetColumnCount = spreadsheet.getColumnCount();
        int spreadsheetRowCount = spreadsheet.getRowCount();

        Address address[][] = new Address[spreadsheetRowCount][spreadsheetColumnCount];

        for (int i = 0; i < spreadsheetRowCount; i++) {
            for (int j = 0; j < spreadsheetColumnCount; j++) {
                address[i][j] = exportCellAddress(spreadsheet, j, i);
            }
        }

        return address;
    }

    public static String[][] exportPartOfSpreadsheet(Spreadsheet spreadsheet, Address begCell, Address endCell) {
        int beginRow = begCell.getRow(), beginColumn = begCell.getColumn(), endRow = endCell.getRow(), endColumn = endCell.getColumn();

        SortedSet<Cell> cells = spreadsheet.getCells(begCell, endCell);
        Iterator<Cell> it = cells.iterator();

        String result[][] = new String[(endRow - beginRow) + 1][(endColumn - beginColumn) + 1];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = it.next().getContent();
            }
        }

        return result;
    }

    public static Address[][] exportPartOfSpreadsheetAddress(Spreadsheet spreadsheet, Address begCell, Address endCell) {
        int beginRow = begCell.getRow(), beginColumn = begCell.getColumn(), endRow = endCell.getRow(), endColumn = endCell.getColumn();

        SortedSet<Cell> cells = spreadsheet.getCells(begCell, endCell);
        Iterator<Cell> it = cells.iterator();

        Address address[][] = new Address[(endRow - beginRow) + 1][(endColumn - beginColumn) + 1];

        for (int i = 0; i < address.length; i++) {
            for (int j = 0; j < address[0].length; j++) {
                address[i][j] = it.next().getAddress();
                System.out.println(address[i][j]);
            }
        }

        return address;
    }

    public static String exportCell(Spreadsheet spreadsheet, int column, int row) {
        return spreadsheet.getCell(column, row).getContent();
    }

    public static Address exportCellAddress(Spreadsheet spreadsheet, int column, int row) {
        return spreadsheet.getCell(column, row).getAddress();
    }
}
