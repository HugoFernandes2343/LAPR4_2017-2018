/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161109.register.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.UserRepository;
import pt.isep.nsheets.shared.services.UserDTO;

import java.util.List;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class RegisterService {
    
    UserRepository userRepository = PersistenceContext.repositories().user();
    
    public User saveUser(UserDTO us) throws DataConcurrencyException, DataIntegrityViolationException{
        User usN = User.fromDTO(us);
        return userRepository.save(usN);
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

}
