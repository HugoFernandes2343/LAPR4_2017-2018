package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.*;

/**
 * @author <1160777>Marco Carneiro</1160777>
 */
@RemoteServiceRelativePath("downloadToCLSService")
public interface DownloadToCLSService extends RemoteService {

    WorkbookDTO exportToDownload(WorkbookDTO toExport) throws DataException;

}
