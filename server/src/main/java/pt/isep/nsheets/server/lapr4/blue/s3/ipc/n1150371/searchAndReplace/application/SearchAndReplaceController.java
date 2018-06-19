/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1150371.searchAndReplace.application;

import eapli.framework.application.Controller;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.WorkbookDTO;

/**
 *
 * @author josea
 */
public class SearchAndReplaceController implements Controller {

    public SearchAndReplaceController() {

    }

    public List<String> searchAndReplace(String input, String replacement, WorkbookDTO wb) {

        List<String> searchResults = new ArrayList<>();

        for (SpreadsheetDTO spreadsheet : wb.getSpreadsheets()) {

            for (int i = 0; i < spreadsheet.getRowCount(); i++) {
                for (int j = 0; j < spreadsheet.getColumnCount(); j++) {
                    if (spreadsheet.getContent()[i][j].equals(input)) {
                        searchResults.add(spreadsheet.getContent()[i][j] + "\tLocation:" + i + "," + j + "\tSpreadsheet:" + spreadsheet.getTitle());
                    }
                }

            }
        }

        return searchResults;
    }

}
