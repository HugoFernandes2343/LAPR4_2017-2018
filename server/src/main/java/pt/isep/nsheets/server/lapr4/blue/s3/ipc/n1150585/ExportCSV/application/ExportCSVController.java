/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1150585.ExportCSV.application;

import eapli.framework.application.Controller;
import org.apache.commons.lang.NotImplementedException;
import pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1150585.ExportCSV.domain.ExportCsv;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public class ExportCSVController implements Controller {

    private final ExportCsv export = new ExportCsv();

    public boolean exportWorkbookToCSV(Workbook workbook, String delimiter, String pathToSaveFile) {
        return export.exportWorkbookToCSV(CSVUtils.exportWorkbook(workbook), delimiter, pathToSaveFile);
    }

    public boolean exportSpreadsheetToCSV(Spreadsheet spreadsheet, String delimiter, String pathToSaveFile) {
        throw new NotImplementedException("Not Implemented");
    }

    public boolean exportPartOfSpreadsheetToCSV(Spreadsheet spreadsheet, Address begCell, Address endCell, String delimiter, String pathToSaveFile) {
        throw new NotImplementedException("Not Implemented");
    }
}
