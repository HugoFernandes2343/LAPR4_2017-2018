package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.core.Workbook;


/**
 * Author 116110 David Maia
 */
public interface UploadServiceAsync {

    /**Async may need to change from workbook to Void soon*/
    void importToWorkbook(Workbook wb, AsyncCallback<Workbook> async);
}
