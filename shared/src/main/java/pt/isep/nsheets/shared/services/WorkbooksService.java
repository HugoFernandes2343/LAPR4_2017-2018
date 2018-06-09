package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.Workbook;

@RemoteServiceRelativePath("workbooksService")
public interface WorkbooksService extends RemoteService {

    ArrayList<Workbook> getWorkbooks();

    Workbook addWorkbook(Workbook wd) throws DataException;

//    void deleteWorkbook(Workbook wdto)throws DataException;
    
    boolean activateConditional(CellImpl activeCell, String name, String operation, String value);

}
