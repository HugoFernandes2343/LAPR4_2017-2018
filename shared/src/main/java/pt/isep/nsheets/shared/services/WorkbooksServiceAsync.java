package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface WorkbooksServiceAsync {

	void getWorkbooks(AsyncCallback<ArrayList<WorkbookDescriptionDTO>> callback);

	void addWorkbookDescription(WorkbookDescriptionDTO wdDto, AsyncCallback<WorkbookDescriptionDTO> callback);

}
