package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

/**
 *
 * @author Barbara Csonka 1171715
 */
@RemoteServiceRelativePath("exportXMLCellRangeService")
public interface ExportXMLCellRangeService extends RemoteService {

    String[][] exportToDownload(String[][] toExport) throws DataException;
}
