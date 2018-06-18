package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExportXMLWorkbookServiceAsync {

    void exportToDownload(WorkbookDTO toExport, AsyncCallback<WorkbookDTO> async);

}
