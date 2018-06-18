package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExportPDFWorkbookServiceAsync {

    void exportToDownload(WorkbookDTO toExport, AsyncCallback<WorkbookDTO> async);

}
