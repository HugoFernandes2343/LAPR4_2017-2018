package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDTO;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Workbook;

import java.util.ArrayList;

public class WorkbookService {
    public Iterable<Workbook> allWorkbooks() {

        ArrayList<Workbook> ret = new ArrayList<>();
        final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();
        for(WorkbookDTO wb : workbookRepository.findAll()){
            ret.add(wb.toWorkbook());
        }

        return ret;
    }

    public Workbook addWorkbook(Workbook wb) throws DataConcurrencyException, DataIntegrityViolationException {

        final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();

        workbookRepository.save(WorkbookDTO.fromWorkbook(wb));

        return wb;
    }


}
