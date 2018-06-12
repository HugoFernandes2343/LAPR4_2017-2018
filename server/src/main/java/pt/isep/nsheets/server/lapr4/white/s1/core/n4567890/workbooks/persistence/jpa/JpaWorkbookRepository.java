/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Pedro Tedim
 */
public class JpaWorkbookRepository extends NSheetsJpaRepositoryBase<Workbook, Long> implements WorkbookRepository {

    JpaWorkbookRepository(PersistenceSettings settings) {
        super(settings);
    }
}
