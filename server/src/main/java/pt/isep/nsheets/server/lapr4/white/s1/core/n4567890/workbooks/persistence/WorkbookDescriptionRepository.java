package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;

public interface WorkbookDescriptionRepository extends Repository<WorkbookDescription, Long> {

    void delete(WorkbookDescription entity);

    WorkbookDescription findWorkbookDescriptionByName(String name);

}
