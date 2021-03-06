/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Password;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.shared.services.EmailDTO;
import pt.isep.nsheets.shared.services.NameDTO;
import pt.isep.nsheets.shared.services.NicknameDTO;
import pt.isep.nsheets.shared.services.PasswordDTO;
import pt.isep.nsheets.shared.services.UserDTO;

;import java.util.List;

/**
 *
 * @author Paulo Jorge
 */
public interface UserRepository extends Repository<User, Long> {

    public User getUser_Email(Email email, Password password);

    public User getUserByEmail(String email);
    
    public User updateUser(UserDTO user);
    
    public Boolean deleteUser(String email);
    
    public Boolean activateUser(UserDTO user);
    
    public Boolean deactivateUser(UserDTO user);

    public Iterable<User> getAllUsers();

}
