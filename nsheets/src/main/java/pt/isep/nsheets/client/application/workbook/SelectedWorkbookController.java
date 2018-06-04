package pt.isep.nsheets.client.application.workbook;

import pt.isep.nsheets.shared.core.Workbook;

public class SelectedWorkbookController {

    private static Workbook actualWorkbook = null;

    private SelectedWorkbookController(){}

    public static Workbook getActualWorkbook() {
        return actualWorkbook;
    }

    public static void setActualWorkbook(Workbook aWb) {
        actualWorkbook = aWb;
    }
}
