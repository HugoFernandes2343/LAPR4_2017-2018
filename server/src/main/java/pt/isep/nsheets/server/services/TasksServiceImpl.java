/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1150585.tasks.application.TasksController;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1150585.tasks.domain.Task;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.TaskRepository;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.TaskDTO;
import pt.isep.nsheets.shared.services.TasksService;

/**
 *
 * @author Daniel Fernandes
 */
public class TasksServiceImpl extends RemoteServiceServlet implements TasksService {

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

//    @Override
//    public boolean checkUser(String email, String password) {
//        // Setup the persistence settings
//        PersistenceContext.setSettings(this.getPersistenceSettings());
//
//        boolean check = false;
//        ArrayList<UserDTO> workbooks = new ArrayList<UserDTO>();
//
//        LoginController ctrl = new LoginController();
//
//        Iterable<User> wbs = ctrl.allUsers();
//
//        for (User wb : wbs) {
//            workbooks.add(wb.toDTO());
//        }
//
//        for (UserDTO workbook : workbooks) {
//            if (workbook.getEmail().equals(email) && workbook.getPassword().equals(password)) {
//                check = true;
//            }
//        }
//
//        return check;
//    }


    @Override
    public Iterable<TaskDTO> get_all_tasks() {
        TasksController controller = new TasksController();
        Iterable<Task> listTask = controller.get_all_tasks();

        List<TaskDTO> listDTO = new ArrayList<>();

        Iterator it = listTask.iterator();

        while (it.hasNext()) {
            Task t = (Task) it.next();
            TaskDTO dto = t.toDTO();
            listDTO.add(dto);
        }
        return listDTO;
    }

    @Override
    public TaskDTO addTask(TaskDTO task) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        TasksController ctr=new TasksController();
        try {
            ctr.addTask(task);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return task;
    }

    @Override
    public void deleteTask(TaskDTO taskDTO) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        TasksController ctr = new TasksController();
        try {
            ctr.deleteTask(taskDTO);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editTask(TaskDTO task, String oldName) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        TasksController ctr = new TasksController();
        
        try {
            ctr.editTask(task,oldName);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(TasksServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
