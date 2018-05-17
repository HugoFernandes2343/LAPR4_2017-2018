package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.ExtensionSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.Contact;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.ContactRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;


public class WorkbooksServiceImpl extends RemoteServiceServlet implements WorkbooksService {

	@Override
	public ArrayList<WorkbookDescriptionDTO> getWorkbooks() {
		// TODO Auto-generated method stub
		
		// This is only for testing...
	    ArrayList<WorkbookDescriptionDTO> workbooks = new ArrayList<WorkbookDescriptionDTO>();
	    
	    Iterable<WorkbookDescription> wbs=getWorkbooksFromJPA();
	    
	    wbs.forEach( wb -> workbooks.add(wb.toDTO()) );
	    
		return workbooks;
	}
	
    private static void setupProperties(Properties appProps) {
        appProps.put("persistence.repositoryFactory", "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        appProps.put("persistence.persistenceUnit", "lapr4.NSheetsPU");
        
        // Other JPA properties that one might want to override from the ones in persistence.xml 
        // appProps.put("javax.persistence.jdbc.url", "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // appProps.put("javax.persistence.jdbc.password", "");
        // appProps.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // appProps.put("javax.persistence.jdbc.user", "");
        // appProps.put("javax.persistence.schema-generation.database.action", "create");
        // appProps.put("eclipselink.logging.level", "FINE");
    }
    
	/**
	 * This method is to test getting workbooks from the database
	 * @return
	 */
	private Iterable<WorkbookDescription> getWorkbooksFromJPA() {
		Iterable<WorkbookDescription> wb=null;
		
		// We should get properties from a file!!!
		Properties props=new Properties();
		setupProperties(props);

		ExtensionSettings extensionSettings=new ExtensionSettings(props);

		final PersistenceContext persistenceContext=new PersistenceContext(extensionSettings);
		final WorkbookDescriptionRepository workbookDescriptionsRepository=persistenceContext.repositories().workbookDescriptions();  
		
		WorkbookDescription c=new WorkbookDescription("Trabalho", "Workbbok de Trabalho de ATB");
		
		try {
			workbookDescriptionsRepository.save(c);
			
			//Long id=c.id();
			
			wb=workbookDescriptionsRepository.findAll();			
		} catch (DataConcurrencyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataIntegrityViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wb;
	}

}
