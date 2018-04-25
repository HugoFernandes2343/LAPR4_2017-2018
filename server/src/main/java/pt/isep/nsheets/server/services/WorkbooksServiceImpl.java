package pt.isep.nsheets.server.services;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;


public class WorkbooksServiceImpl extends RemoteServiceServlet implements WorkbooksService {

	@Override
	public ArrayList<WorkbookDescriptionDTO> getWorkbooks() {
		// TODO Auto-generated method stub
		
		// This is only for testing...
	    ArrayList<WorkbookDescriptionDTO> workbooks = new ArrayList<WorkbookDescriptionDTO>();

	    WorkbookDescriptionDTO wb=new WorkbookDescriptionDTO("workbook1", "Este workbook contem uma lista...");
	    workbooks.add(wb);
	    
	    WorkbookDescriptionDTO wb2=new WorkbookDescriptionDTO("workbook notas", "Este workbook contem notas de disciplinas...");
	    workbooks.add(wb2);
	    
		return workbooks;
	}

}
