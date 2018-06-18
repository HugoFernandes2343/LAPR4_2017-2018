package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("exportPDFCellRangeService")
public interface ExportPDFCellRangeService extends RemoteService {
    String[][] exportToDownload(String[][] toExport) throws DataException;
}
