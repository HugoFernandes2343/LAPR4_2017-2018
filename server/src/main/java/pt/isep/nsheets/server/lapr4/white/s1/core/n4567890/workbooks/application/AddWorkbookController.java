package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.shared.core.Workbook;

public class AddWorkbookController implements Controller {
    public Workbook addWorkbook(Workbook wb) throws DataConcurrencyException, DataIntegrityViolationException {

        return new WorkbookService().addWorkbook(wb);
    }
}
