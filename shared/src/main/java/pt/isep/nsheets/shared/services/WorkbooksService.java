package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.core.Workbook;

@RemoteServiceRelativePath("workbooksService")
public interface WorkbooksService extends RemoteService {

    ArrayList<Workbook> getWorkbooks();
//	WorkbookDescriptionDTO addWorkbookDescription(WorkbookDescriptionDTO wdDto) throws DataException;

    Workbook addWorkbook(Workbook wd) throws DataException;

    int getNrWorkbooks();

}
