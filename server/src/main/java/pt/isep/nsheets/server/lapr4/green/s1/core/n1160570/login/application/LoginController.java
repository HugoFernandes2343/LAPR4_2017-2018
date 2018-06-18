/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Password;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.UserRepository;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
public class LoginController implements Controller {

    public Iterable<User> allUsers() {
        UserRepository userRepository = PersistenceContext.repositories().user();
        return userRepository.getAllUsers();
    }

    public User getUser(Email email, Password password) {
        UserRepository userRepository = PersistenceContext.repositories().user();
        return userRepository.getUser_Email(email, password);
    }
    
    public UserDTO updateUser(UserDTO user){
        UserRepository userRepository = PersistenceContext.repositories().user();
        return userRepository.updateUser(user).toDTOAdmin(user.getUserType());
    }
    
    public Boolean deleteUser(String email){
        UserRepository userRepository = PersistenceContext.repositories().user();
        return userRepository.deleteUser(email);
    }
    
    public Boolean activateUser(UserDTO user){
        UserRepository userRepository = PersistenceContext.repositories().user();
        return userRepository.activateUser(user);
    }
    
    public Boolean deactivateUser(UserDTO user){
        UserRepository userRepository = PersistenceContext.repositories().user();
        return userRepository.deactivateUser(user);
    }

    public User getUserByEmail(String email){
        UserRepository userRepository = PersistenceContext.repositories().user();
        return userRepository.getUserByEmail(email);
    }
}
