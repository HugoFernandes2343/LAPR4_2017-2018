/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author dftsf
 */
public interface ExportCsvSpreadsheetServiceAsync {
    
     void exportToDownload(SpreadsheetDTO toExport, AsyncCallback<SpreadsheetDTO> async);
}
