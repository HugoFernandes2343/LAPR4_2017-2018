/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

/**
 *
 * @author Pedro Tedim
 */
public class EditWorkbookDescriptionController implements Controller {

    private WorkbookDescriptionRepository wdescriptionRepo;

    public EditWorkbookDescriptionController() {
        wdescriptionRepo = PersistenceContext.repositories().workbookDescriptions();
    }

    public boolean editWorkbookName(WorkbookDescriptionDTO dto, String newName) throws DataConcurrencyException, DataIntegrityViolationException {
        WorkbookDescription workDescription = wdescriptionRepo.findWorkbookDescriptionByName(dto.getName());
        if (workDescription.editName(newName)) {
            wdescriptionRepo.save(workDescription);
            return true;
        }
        return false;
    }

    public boolean editWorkbookDescription(WorkbookDescriptionDTO dto, String newDescription) throws DataConcurrencyException, DataIntegrityViolationException {
        WorkbookDescription workDescription = wdescriptionRepo.findWorkbookDescriptionByName(dto.getName());
        if (workDescription.editDescription(newDescription)) {
            wdescriptionRepo.save(workDescription);
            return true;
        }
        return false;
    }

}
