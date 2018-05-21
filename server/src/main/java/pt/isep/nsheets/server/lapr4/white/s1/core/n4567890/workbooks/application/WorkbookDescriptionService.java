package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;

public class WorkbookDescriptionService {

    public Iterable<WorkbookDescription> allWorkbookDescriptions() {

        final WorkbookDescriptionRepository workbookDescriptionRepository = PersistenceContext.repositories().workbookDescriptions();
        return workbookDescriptionRepository.findAll();
    }

    public WorkbookDescription addWorkbookDescription(String name, String description) throws DataConcurrencyException, DataIntegrityViolationException {

        final WorkbookDescriptionRepository workbookDescriptionRepository = PersistenceContext.repositories().workbookDescriptions();
        
        WorkbookDescription wb=new WorkbookDescription(name, description);
        workbookDescriptionRepository.save(wb);
        
        return wb;
    }
}
