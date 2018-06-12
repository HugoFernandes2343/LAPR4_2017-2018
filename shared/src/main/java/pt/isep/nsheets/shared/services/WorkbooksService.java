package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.Workbook;

@RemoteServiceRelativePath("workbooksService")
public interface WorkbooksService extends RemoteService {

    ArrayList<WorkbookDescriptionDTO> getWorkbooks();

    WorkbookDescriptionDTO addWorkbookDescription(WorkbookDescriptionDTO wdDto) throws DataException;

    boolean editWorkbookDescription(WorkbookDescriptionDTO dto, String description);

    boolean editWorkbookName(WorkbookDescriptionDTO dto, String name);

    boolean deleteWorkbook(WorkbookDescriptionDTO dto);
    
    Workbook addWorkbook(WorkbookDescriptionDTO wdDto) throws DataException;
    
    boolean addSpreadsheetToWorkbook(WorkbookDTO wbDTO, SpreadsheetDTO ssDTO);

    boolean activateConditional(CellImplDTO activeCell, String name, String operation, String value);

}
