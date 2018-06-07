/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Andre Rodrigues <1151136@isep.ipp.pt>
 */
public class DeleteWorkbookController {

    public void deleteWorkbook(Workbook wb) throws DataConcurrencyException, DataIntegrityViolationException {

            WorkbookService service=new WorkbookService() ;
            service.deleteWorkbook(wb);
    }
    
}
