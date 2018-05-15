/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.Contact;
import eapli.framework.persistence.repositories.Repository;

/**
 * Created by nuno on 21/03/16.
 */
public interface ContactRepository extends Repository<Contact, Long> {

    boolean removeContact(Contact c) throws DataIntegrityViolationException;
    
}
