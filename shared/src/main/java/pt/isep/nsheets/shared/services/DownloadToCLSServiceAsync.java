package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.*;

/**
 * @author <1160777>Marco Carneiro</1160777>
 */
public interface DownloadToCLSServiceAsync {

    void exportToDownload(WorkbookDTO toExport, AsyncCallback<WorkbookDTO> async);

}
