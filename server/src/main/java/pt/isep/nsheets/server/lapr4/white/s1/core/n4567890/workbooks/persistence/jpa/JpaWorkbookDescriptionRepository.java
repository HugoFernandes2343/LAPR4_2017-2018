package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.ExtensionSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;

public class JpaWorkbookDescriptionRepository extends CrmJpaRepositoryBase<WorkbookDescription, Long> implements WorkbookDescriptionRepository {

	JpaWorkbookDescriptionRepository(ExtensionSettings settings) {
        super(settings);
    }

}
