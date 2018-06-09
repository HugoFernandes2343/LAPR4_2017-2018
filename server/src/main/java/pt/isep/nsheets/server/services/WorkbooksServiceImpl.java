package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.*;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDTO;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1160696.condFunction.ConditionalFunctionController;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public class
WorkbooksServiceImpl extends RemoteServiceServlet implements WorkbooksService {

    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url",
        // "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // props.put("javax.persistence.jdbc.password", "");
        // props.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // props.put("javax.persistence.jdbc.user", "");
        // props.put("javax.persistence.schema-generation.database.action", "create");
        // props.put("eclipselink.logging.level", "FINE");
        return new PersistenceSettings(props);
    }

    @Override
    public ArrayList<Workbook> getWorkbooks() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ListWorkbookController ctrl = new ListWorkbookController();
        return (ArrayList<Workbook>) ctrl.listWorkbooks();
    }

    @Override
    public Workbook addWorkbook(Workbook wd) throws DataException {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        AddWorkbookController ctrl = new AddWorkbookController();

        try {
            return ctrl.addWorkbook(wd);
        } catch (DataConcurrencyException ex) {
            throw new DataException((Throwable) ex);
        } catch (DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }

    }



//    @Override
//    public ArrayList<WorkbookDescriptionDTO> getWorkbooks() {
//        // Setup the persistence settings
//        PersistenceContext.setSettings(this.getPersistenceSettings());
//
//        ArrayList<WorkbookDescriptionDTO> workbooks = new ArrayList<WorkbookDescriptionDTO>();
//
//        ListWorkbookDescriptionController ctrl = new ListWorkbookDescriptionController();
//
//        Iterable<WorkbookDescription> wbs = ctrl.listWorkbookDescriptions();
//
//        wbs.forEach(wb -> workbooks.add(wb.toDTO()));
//
//        return workbooks;
//    }
//        @Override
//        public WorkbookDescriptionDTO addWorkbookDescription (WorkbookDescriptionDTO wdDto)
//			throws DataException {
//            // Setup the persistence settings
//            PersistenceContext.setSettings(this.getPersistenceSettings());
//
//            AddWorkbookDescriptionController ctrl = new AddWorkbookDescriptionController();
//
//            WorkbookDescription wd = null;
//
//            try {
//                wd = ctrl.addWorkbookDescription(wdDto);
//            } catch (DataConcurrencyException ex) {
//                throw new DataException((Throwable) ex);
//            } catch (DataIntegrityViolationException ex) {
//                throw new DataException((Throwable) ex);
//            }
//
//            return wd.toDTO();
//        } 

    

    public void deleteWorkbook(Workbook wdto) throws DataException {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        DeleteWorkbookController ctrl = new DeleteWorkbookController();

        try {
            ctrl.deleteWorkbook(wdto);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }

    } 
    
    @Override
    public boolean activateConditional(CellImpl activeCell, String name, String operation, String value) {
        ConditionalFunctionController cfc = new ConditionalFunctionController();
        try {
            return cfc.activateExtension(activeCell, name, operation, value);
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(WorkbooksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(WorkbooksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
