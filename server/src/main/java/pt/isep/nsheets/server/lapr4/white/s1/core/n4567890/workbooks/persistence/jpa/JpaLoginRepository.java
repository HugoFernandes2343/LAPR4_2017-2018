/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.s3.ipc.s1161248.PrivateChat.domain.Chat;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Password;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.UserRepository;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
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
        User u = matchOne("e.email=:email ", "email", mail);
        return u;
    }


    @Override
    public Iterable<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        return findAll();
    }


}
