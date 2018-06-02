package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.application.LoginController;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.UserDTO;

import pt.isep.nsheets.shared.services.UsersService;

public class UsersServiceImpl extends RemoteServiceServlet implements UsersService {

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
    public UserDTO getUser(String email, String password) {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        UserDTO userDTO;
        LoginController ctrl = new LoginController();

        userDTO = ctrl.User(email, password).toDTO();

        return userDTO;
    }

}
