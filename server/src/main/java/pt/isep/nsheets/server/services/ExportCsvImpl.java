/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1150585.ExportCSV.application.ExportCSVController;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.ExportCsvService;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public class ExportCsvImpl extends RemoteServiceServlet implements ExportCsvService{

    @Override
    public boolean exportWorkbookToCSV(Workbook workbook, String delimiter, String pathToSaveFile) {
        ExportCSVController controller = new ExportCSVController();
        return controller.exportWorkbookToCSV(workbook, delimiter, pathToSaveFile);
    }
}
