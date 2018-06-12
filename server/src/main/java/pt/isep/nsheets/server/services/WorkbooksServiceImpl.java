package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.AddSpreadsheetToWorkbookController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.AddWorkbookController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.AddWorkbookDescriptionController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.DeleteWorkbookController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.EditWorkbookDescriptionController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.ListWorkbookDescriptionController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1160696.condFunction.ConditionalFunctionController;
import pt.isep.nsheets.shared.services.CellImplDTO;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;

public class WorkbooksServiceImpl extends RemoteServiceServlet implements WorkbooksService {

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
    public ArrayList<WorkbookDescriptionDTO> getWorkbooks() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<WorkbookDescriptionDTO> workbooks = new ArrayList<WorkbookDescriptionDTO>();

        ListWorkbookDescriptionController ctrl = new ListWorkbookDescriptionController();

        Iterable<WorkbookDescription> wbs = ctrl.listWorkbookDescriptions();

        wbs.forEach(wb -> workbooks.add(wb.toDTO()));

        return workbooks;
    }

    @Override
    public WorkbookDescriptionDTO addWorkbookDescription(WorkbookDescriptionDTO wdDto) throws DataException {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        AddWorkbookDescriptionController ctrl = new AddWorkbookDescriptionController();

        WorkbookDescription wd = null;

        try {
            wd = ctrl.addWorkbookDescription(wdDto);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }

        return wd.toDTO();
    }

    @Override
    public boolean editWorkbookDescription(WorkbookDescriptionDTO dto, String description) {
        EditWorkbookDescriptionController controller = new EditWorkbookDescriptionController();
        boolean newDescription = false;

        try {
            newDescription = controller.editWorkbookDescription(dto, description);
        } catch (DataConcurrencyException ex) {
            return false;
        } catch (DataIntegrityViolationException ex) {
            return false;
        }

        if (!newDescription) {
            return false;
        }

        return true;
    }

    @Override
    public boolean editWorkbookName(WorkbookDescriptionDTO dto, String name) {
        EditWorkbookDescriptionController controller = new EditWorkbookDescriptionController();
        WorkbookDescription wdescription = WorkbookDescription.fromDTO(dto);
        boolean newName = false;

        try {
            newName = controller.editWorkbookName(dto, name);
        } catch (DataConcurrencyException ex) {
            return false;
        } catch (DataIntegrityViolationException ex) {
            return false;
        }

        if (!newName) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteWorkbook(WorkbookDescriptionDTO dto) {
        DeleteWorkbookController controller = new DeleteWorkbookController();
        boolean success = controller.deleteWorkbook(dto);

        if (success) {
            return true;
        }
        return false;
    }

    @Override
    public Workbook addWorkbook(WorkbookDescriptionDTO wdDto) throws DataException {
        final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();

        WorkbookDescription wbd = WorkbookDescription.fromDTO(wdDto);
        Workbook wb = wbd.getWorkbook();

        try {
            workbookRepository.save(wb);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(WorkbooksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return wb;

    }

    @Override
    public boolean activateConditional(CellImplDTO activeCell, String name, String operation, String value) {
        ConditionalFunctionController cfc = new ConditionalFunctionController();
        try {
            return cfc.activateExtension(activeCell, name, operation, value);
        } catch (FormulaCompilationException | IllegalValueTypeException ex) {
            Logger.getLogger(WorkbooksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean addSpreadsheetToWorkbook(WorkbookDTO wbDTO, SpreadsheetDTO ssDTO) {
        final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();
        wbDTO.spreadsheets.add(ssDTO);
        Workbook wd = new Workbook(wbDTO);
        try {
            workbookRepository.save(wd);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(WorkbooksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(WorkbooksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
