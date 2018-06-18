package pt.isep.nsheets.client.application.workbook;

import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.CurrentWorkbookDTO;

public class CurrentWorkbook {

    private static Workbook currentWorkbook = null;

    private static Spreadsheet currentSpreadsheet = null;

    public static Workbook getCurrentWorkbook() {
        return currentWorkbook;
    }

    public static void setCurrentWorkbook(Workbook aWb) {
        currentWorkbook = aWb;
        CurrentWorkbookDTO.setCurrentWorkbook(aWb);
    }

    public static Spreadsheet getCurrentSpreadsheet() {
        return currentSpreadsheet;
    }

    public static void setCurrentSpreadsheet(Spreadsheet cs) {
        currentSpreadsheet = cs;
        CurrentWorkbookDTO.setCurrentSpreadsheet(cs);
    }
}
