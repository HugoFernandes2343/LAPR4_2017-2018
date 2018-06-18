package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("exportPDFSpreadsheetService")
public interface ExportPDFSpreadsheetService extends RemoteService {
    SpreadsheetDTO exportToDownload(SpreadsheetDTO toExport) throws DataException;
}
