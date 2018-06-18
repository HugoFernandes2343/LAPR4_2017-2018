package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author Barbara Csonka 1171715
 */
@RemoteServiceRelativePath("exportXMLSpreadsheetService")
public interface ExportXMLSpreadsheetService extends RemoteService {

    SpreadsheetDTO exportToDownload(SpreadsheetDTO toExport) throws DataException;
}