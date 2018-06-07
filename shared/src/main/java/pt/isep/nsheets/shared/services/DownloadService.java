package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.*;
import pt.isep.nsheets.shared.core.Workbook;

/**
 * @author <1160777>Marco Carneiro</1160777>
 */
@RemoteServiceRelativePath("downloadService")
public interface DownloadService extends RemoteService {

    Workbook exportToDownload(Workbook toExport) throws DataException;

}
