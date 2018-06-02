package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDTO;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Workbook;

public class JpaWorkbookRepository extends NSheetsJpaRepositoryBase<WorkbookDTO, Long> implements WorkbookRepository {
    JpaWorkbookRepository(PersistenceSettings settings) {
        super(settings);
    }
}
