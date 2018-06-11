package pt.isep.nsheets.client.application.workbook;

import pt.isep.nsheets.shared.core.Workbook;

public class CurrentWorkbook {

    private static Workbook currentWorkbook = null;

    public static Workbook getCurrentWorkbook() {
        return currentWorkbook;
    }

    public static void setCurrentWorkbook(Workbook aWb) {
        currentWorkbook = aWb;
    }
}
