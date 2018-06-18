/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Password;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.UserRepository;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UserTypeDTO;

/**
 *
 * @author Paulo Jorge
 */
public class JpaLoginRepository extends NSheetsJpaRepositoryBase<User, Long> implements UserRepository {

    JpaLoginRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public User getUser_Email(Email email, Password password) {
        User u = matchOne("e.email=:email and e.password=:password", "email", email, "password", password);
        return u;
    }

    @Override
    public User getUserByEmail(String email) {
        Email mail = new Email(email);
        User u = matchOne("e.email=:mail ", "email", mail);
        return u;
    }

    @Override
    public User updateUser(UserDTO user) {

        UserRepository userRepository = PersistenceContext.repositories().user();
        User userEntity = null;

        if (user.getUserType() == UserTypeDTO.ADMIN) {
            String admin = "admin";
            userEntity = User.fromDTOAdmin(user, admin);
        }else{
            userEntity = User.fromDTO(user);
        }

        this.deleteUser(user.getEmail().getEmail());

        try {
            userRepository.save(userEntity);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(JpaLoginRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Query q = entityManager().createQuery("UPDATE User u "
//                + "SET u.nickname=:newNickname "
//                + "WHERE u.email=:oldemail");
//
//
//        q.setParameter("oldemail", Email.fromDTO(email));
////        q.setParameter("newName", name);
//        q.setParameter("newNickname", Nickname.fromDTO(nickname));
//
////
//        entityManager().getTransaction().begin();
//        q.executeUpdate();
//        entityManager().getTransaction().commit();

//        Query q = entityManager().createQuery("UPDATE User u "
//                + "SET u.nickname=:newNickname " 
//                + "WHERE u.email=:oldemail");
//
//
//        q.setParameter("oldemail", Email.fromDTO(email));
////        q.setParameter("newName", name);
//        q.setParameter("newNickname", Nickname.fromDTO(nickname));
//
////
//        entityManager().getTransaction().begin();
//        q.executeUpdate();
//        entityManager().getTransaction().commit();
        return userEntity;
    }

    @Override
    public Boolean deleteUser(String email) {
        Email mail = new Email(email);
        final Query q = entityManager().createQuery("DELETE FROM User u WHERE u.email=:mail", this.entityClass);
        q.setParameter("mail", mail);
        entityManager().getTransaction().begin();
        q.executeUpdate();
        entityManager().getTransaction().commit();
        return true;
    }

    @Override
    public Boolean activateUser(UserDTO user) {
        Email email = new Email(user.getEmail().getEmail());
        
        Query q = entityManager().createQuery(
                "UPDATE User u "
                + "SET u.activate=:newactivate "
                + "WHERE u.email =:email");

        q.setParameter("email", email);
        q.setParameter("newactivate", true);

        entityManager().getTransaction().begin();
        q.executeUpdate();
        entityManager().getTransaction().commit();
        
        return true;
    }

    @Override
    public Boolean deactivateUser(UserDTO user) {
        Email email = new Email(user.getEmail().getEmail());
        
        Query q = entityManager().createQuery(
                "UPDATE User u "
                + "SET u.activate=:newactivate "
                + "WHERE u.email =:email");

        q.setParameter("email", email);
        q.setParameter("newactivate", false);

        entityManager().getTransaction().begin();
        q.executeUpdate();
        entityManager().getTransaction().commit();
        
        return true;
    }

}
