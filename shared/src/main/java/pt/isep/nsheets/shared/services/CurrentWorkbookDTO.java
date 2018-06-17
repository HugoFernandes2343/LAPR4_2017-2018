package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

public class CurrentWorkbookDTO {

    private static Workbook currentWorkbook = null;

    private static Spreadsheet currentSpreadsheet = null;

    public static Workbook getCurrentWorkbook() {
        return currentWorkbook;
    }

    public static void setCurrentWorkbook(Workbook aWb) {
        currentWorkbook = aWb;
    }

    public static Spreadsheet getCurrentSpreadsheet() {
        return currentSpreadsheet;
    }

    public static void setCurrentSpreadsheet(Spreadsheet cs) {
        currentSpreadsheet = cs;
    }
}