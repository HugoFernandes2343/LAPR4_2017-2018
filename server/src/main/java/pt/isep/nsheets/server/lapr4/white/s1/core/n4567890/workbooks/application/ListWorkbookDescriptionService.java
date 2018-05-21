package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;

public class ListWorkbookDescriptionService {

    public Iterable<WorkbookDescription> allWorkbookDescriptions() {

        final WorkbookDescriptionRepository workbookDescriptionRepository = PersistenceContext.repositories().workbookDescriptions();
        return workbookDescriptionRepository.findAll();
    }
}
