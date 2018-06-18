package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface ExportPDFSpreadsheetServiceAsync {
    void exportToDownload(SpreadsheetDTO toExport, AsyncCallback<SpreadsheetDTO> async);
}
