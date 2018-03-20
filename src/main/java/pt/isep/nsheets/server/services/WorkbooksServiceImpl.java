package pt.isep.nsheets.server.services;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import pt.isep.nsheets.client.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;


public class WorkbooksServiceImpl extends RemoteServiceServlet implements WorkbooksService {

	@Override
	public ArrayList<WorkbookDescriptionDTO> getWorkbooks() {
		// TODO Auto-generated method stub
		
		// This is only for testing...
	    ArrayList<WorkbookDescriptionDTO> workbooks = new ArrayList<WorkbookDescriptionDTO>();

	    WorkbookDescriptionDTO wb=new WorkbookDescriptionDTO("teste");
	    workbooks.add(wb);
	    
		return workbooks;
	}

}
