/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.application;

import eapli.framework.application.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.UserRepository;

/**
 *
 * @author Paulo Jorge
 */
public class LoginController implements Controller {

    List<User> userList = new ArrayList<>();

    public List<User> allUsers() {
        UserRepository userRepository = PersistenceContext.repositories().user();
        userList = (List<User>) userRepository.findAll();
        return userList;
    }

    public boolean checkUser(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
