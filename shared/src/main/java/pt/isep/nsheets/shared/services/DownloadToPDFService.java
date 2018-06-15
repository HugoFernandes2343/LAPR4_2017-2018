package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("downloadToPDFService")
public interface DownloadToPDFService extends RemoteService {

    WorkbookDTO exportToDownload(WorkbookDTO toExport) throws DataException;

}
