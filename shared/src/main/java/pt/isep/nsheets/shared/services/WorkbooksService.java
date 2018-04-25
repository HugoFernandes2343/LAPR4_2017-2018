package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("workbooksService")
public interface WorkbooksService extends RemoteService {
	ArrayList<WorkbookDescriptionDTO> getWorkbooks();
}
