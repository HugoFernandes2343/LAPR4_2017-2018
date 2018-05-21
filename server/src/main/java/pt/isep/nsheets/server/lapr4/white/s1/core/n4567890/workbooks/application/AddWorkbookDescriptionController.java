package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;

public class AddWorkbookDescriptionController implements Controller {

    public WorkbookDescription addWorkbookDescription(String name, String description) throws DataConcurrencyException, DataIntegrityViolationException {
        
    	return new WorkbookDescriptionService().addWorkbookDescription(name, description);
    }
}
