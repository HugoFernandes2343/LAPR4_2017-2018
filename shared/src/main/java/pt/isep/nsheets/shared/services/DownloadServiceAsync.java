package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.*;
import pt.isep.nsheets.shared.core.Workbook;

/**
 * @author <1160777>Marco Carneiro</1160777>
 */
public interface DownloadServiceAsync {

    /**Async may need to change from workbook to Void soon*/
    void exportToDownload(Workbook toExport, AsyncCallback<Workbook> async);

}
