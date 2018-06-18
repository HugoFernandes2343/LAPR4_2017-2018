package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DownloadToPDFServiceAsync {

    void exportToDownload(WorkbookDTO toExport, AsyncCallback<WorkbookDTO> async);

}
