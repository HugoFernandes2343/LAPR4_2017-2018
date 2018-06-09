/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.services.WorkbooksServiceImpl;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

/**
 *
 * @author Pedro Tedim
 */
public class AddWorkbookController implements Controller {
    
    public Workbook addWorkbook(WorkbookDescriptionDTO dto) throws DataConcurrencyException, DataIntegrityViolationException, DataException {

        return new WorkbooksServiceImpl().addWorkbook(dto);
    }
    
}
