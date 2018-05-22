package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;

public class ListWorkbookDescriptionController implements Controller {

    public Iterable<WorkbookDescription> listWorkbookDescriptions() {
        return new WorkbookDescriptionService().allWorkbookDescriptions();
    }
}
