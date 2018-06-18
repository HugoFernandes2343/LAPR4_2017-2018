package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface ExportXMLCellRangeServiceAsync {
    void exportToDownload(String[][] toExport, AsyncCallback<String[][]> async);
}
