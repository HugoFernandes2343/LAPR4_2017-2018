package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import eapli.framework.persistence.repositories.impl.jpa.*;
import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDTO;
import pt.isep.nsheets.shared.core.Workbook;

import javax.persistence.*;
import java.util.Optional;

public interface WorkbookRepository extends Repository<WorkbookDTO, Long> {

    public WorkbookDTO findByName(String name);

}
