package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.core.Workbook;


public interface WorkbooksServiceAsync {

//	void getWorkbooks(AsyncCallback<ArrayList<WorkbookDescriptionDTO>> callback);

	void addWorkbook(Workbook wd, AsyncCallback<Workbook> async);

	void getWorkbooks(AsyncCallback<ArrayList<Workbook>> async);


//	void addWorkbookDescription(WorkbookDescriptionDTO wdDto, AsyncCallback<WorkbookDescriptionDTO> async);
}
