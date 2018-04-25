package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public interface WorkbooksServiceAsync {

	void getWorkbooks(AsyncCallback<ArrayList<WorkbookDescriptionDTO>> callback);

}
