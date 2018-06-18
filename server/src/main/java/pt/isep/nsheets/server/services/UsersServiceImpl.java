package pt.isep.nsheets.server.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.application.LoginController;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Password;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import static pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.UserType.ADMIN;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161109.register.application.RegisterController;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.EmailDTO;
import pt.isep.nsheets.shared.services.NameDTO;
import pt.isep.nsheets.shared.services.NicknameDTO;
import pt.isep.nsheets.shared.services.PasswordDTO;

import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UserTypeDTO;

import pt.isep.nsheets.shared.services.UsersService;

public class UsersServiceImpl extends RemoteServiceServlet implements UsersService, Serializable {

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
    public UserDTO getUserByEmail(String email) {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        LoginController ctrl = new LoginController();

        User user = null;

        user = ctrl.getUserByEmail(email);

        return user.toDTO();
    }

    @Override
    public List<UserDTO> getAllUser(){
        List<UserDTO> result = new ArrayList<>();

        PersistenceContext.setSettings(this.getPersistenceSettings());
        LoginController ctrl = new LoginController();
        Iterable<User> list = ctrl.allUsers();
        Iterator<User> it = list.iterator();
        while(it.hasNext()){
            result.add(it.next().toDTO());
        }
        return result;
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
    public UserDTO getUser(String email, String password) {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        LoginController ctrl = new LoginController();
        User user = ctrl.getUser(new Email(email), new Password(password));

        if (user.getUserType() == ADMIN) {
            UserTypeDTO usertype = UserTypeDTO.ADMIN;
            return ctrl.getUser(new Email(email), new Password(password)).toDTOAdmin(usertype);
        } else {

            return ctrl.getUser(new Email(email), new Password(password)).toDTO();
        }

    }

    @Override
    public UserDTO saveUser(UserDTO user) {

        PersistenceContext.setSettings(this.getPersistenceSettings());

        RegisterController ctrl = new RegisterController();

        try {
            return ctrl.saveUser(user).toDTO();
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        LoginController controller = new LoginController();
        return controller.updateUser(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        LoginController controller = new LoginController();
        Iterable<User> itr = controller.allUsers();
        List<UserDTO> lstDTO = new ArrayList<UserDTO>();
        for (User user : itr) {
            UserDTO dto = user.toDTO();
            lstDTO.add(dto);
        }
        return lstDTO;
    }

    @Override
    public Boolean deleteUser(String email) {
        LoginController controller = new LoginController();
        controller.deleteUser(email);
        return true;
    }

    @Override
    public Boolean activateUser(UserDTO user) {
        LoginController controller = new LoginController();
        controller.activateUser(user);
        return true;
    }

    @Override
    public Boolean deactivateUser(UserDTO user) {
        LoginController controller = new LoginController();
        controller.deactivateUser(user);
        return true;
    }

}
