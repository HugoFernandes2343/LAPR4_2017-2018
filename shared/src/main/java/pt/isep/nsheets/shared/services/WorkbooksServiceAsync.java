package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.core.Workbook;

public interface WorkbooksServiceAsync {

//	void getWorkbooks(AsyncCallback<ArrayList<WorkbookDescriptionDTO>> callback);
    void getWorkbooks(AsyncCallback<ArrayList<WorkbookDescriptionDTO>> callback);

    void addWorkbookDescription(WorkbookDescriptionDTO wdDto, AsyncCallback<WorkbookDescriptionDTO> callback);

    void editWorkbookDescription(WorkbookDescriptionDTO dto, String description, AsyncCallback<Boolean> callback);

    void editWorkbookName(WorkbookDescriptionDTO dto, String name, AsyncCallback<Boolean> callback);

    void deleteWorkbook(WorkbookDescriptionDTO dto, AsyncCallback callback);

    void addWorkbook(WorkbookDescriptionDTO wdDto, AsyncCallback<Workbook> async);
    
    void addSpreadsheetToWorkbook(WorkbookDTO wbDTO, SpreadsheetDTO ssDTO, AsyncCallback<Boolean> callback);

//    void addWorkbook(WorkbookDescriptionDTO wdDto, AsyncCallback<WorkbookDTO> async);

//	void addWorkbookDescription(WorkbookDescriptionDTO wdDto, AsyncCallback<WorkbookDescriptionDTO> async);
}
