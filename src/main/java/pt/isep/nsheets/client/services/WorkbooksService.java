package pt.isep.nsheets.client.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

@RemoteServiceRelativePath("workbooksService")
public interface WorkbooksService extends RemoteService {
	ArrayList<WorkbookDescriptionDTO> getWorkbooks();
}
