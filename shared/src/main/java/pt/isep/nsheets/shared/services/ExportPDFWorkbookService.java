package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("exportPDFWorkbookService")
public interface ExportPDFWorkbookService extends RemoteService {
    WorkbookDTO exportToDownload(WorkbookDTO toExport) throws DataException;
}
