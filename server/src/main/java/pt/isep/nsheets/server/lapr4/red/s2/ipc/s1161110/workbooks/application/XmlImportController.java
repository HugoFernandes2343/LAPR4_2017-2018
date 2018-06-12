package pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161110.workbooks.application;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.AddWorkbookController;
import pt.isep.nsheets.server.services.FileUploadServlet;
import pt.isep.nsheets.shared.services.UploadService;

/**
 * Author David Maia 1161110
 */
public class XmlImportController extends RemoteServiceServlet implements Controller {
    /**
     * Only if need to persist the workbook
     */
    AddWorkbookController wbCTRL;

    public XmlImportController() {
        this.wbCTRL= new AddWorkbookController();

    }


}
