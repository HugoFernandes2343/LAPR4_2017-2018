/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

/**
 *
 * @author Andre Rodrigues <1151136@isep.ipp.pt>
 */
public class DeleteWorkbookController {

    private WorkbookDescriptionRepository wdescriptionRepo;

    public DeleteWorkbookController() {
        wdescriptionRepo = PersistenceContext.repositories().workbookDescriptions();
    }

    /**
     * Method that deletes a specific workbook by its description
     *
     * @param dto
     * @return
     */
    public boolean deleteWorkbook(WorkbookDescriptionDTO dto) {
        WorkbookDescription wdescription = wdescriptionRepo.findWorkbookDescriptionByName(dto.getName());
        if (wdescription != null) {
            wdescriptionRepo.delete(wdescription);
            return true;
        }
        return false;
    }

}
