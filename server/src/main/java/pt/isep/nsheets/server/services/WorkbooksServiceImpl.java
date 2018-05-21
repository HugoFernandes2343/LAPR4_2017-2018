package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.ListWorkbookDescriptionController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;


public class WorkbooksServiceImpl extends RemoteServiceServlet implements WorkbooksService {

	@Override
	public ArrayList<WorkbookDescriptionDTO> getWorkbooks() {
		// Setup the persistence settings
		PersistenceContext.setSettings(this.getPersistenceSettings());
		
		// This is only for testing...
	    ArrayList<WorkbookDescriptionDTO> workbooks = new ArrayList<WorkbookDescriptionDTO>();
	    
	    ListWorkbookDescriptionController ctrl=new ListWorkbookDescriptionController();
	    
	    Iterable<WorkbookDescription> wbs=ctrl.listWorkbookDescriptions();
	    		
	    wbs.forEach( wb -> workbooks.add(wb.toDTO()) );
	    
		return workbooks;
	}
	
    private PersistenceSettings getPersistenceSettings() {
    	
    	Properties props=new Properties();
    	
        props.put("persistence.repositoryFactory", "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");
        
        // Other JPA properties that one might want to override from the ones in persistence.xml 
        // props.put("javax.persistence.jdbc.url", "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // props.put("javax.persistence.jdbc.password", "");
        // props.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // props.put("javax.persistence.jdbc.user", "");
        // props.put("javax.persistence.schema-generation.database.action", "create");
        // props.put("eclipselink.logging.level", "FINE");
        
		return new PersistenceSettings(props); 
    }
    
	/**
	 * This method is to test getting workbooks from the database
	 * @return
	 */
//	private Iterable<WorkbookDescription> getWorkbooksFromJPA() {
//		Iterable<WorkbookDescription> wb=null;
//		
//		// We should get properties from a file!!!
//		//Properties props=new Properties();
//		// setupPersistenceProperties();
//
//		// PersistenceSettings extensionSettings=new PersistenceSettings(props);
//
//		final PersistenceContext persistenceContext=new PersistenceContext(this.getPersistenceSettings());
//		final WorkbookDescriptionRepository workbookDescriptionsRepository=persistenceContext.repositories().workbookDescriptions();  
//		
//		WorkbookDescription c=new WorkbookDescription("Trabalho", "Workbbok de Trabalho de ATB");
//		
//		try {
//			workbookDescriptionsRepository.save(c);
//			
//			//Long id=c.id();
//			
//			wb=workbookDescriptionsRepository.findAll();			
//		} catch (DataConcurrencyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DataIntegrityViolationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return wb;
//	}

}
