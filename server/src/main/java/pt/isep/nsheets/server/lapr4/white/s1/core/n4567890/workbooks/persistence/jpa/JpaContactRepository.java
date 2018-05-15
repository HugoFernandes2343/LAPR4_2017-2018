/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

/**
 *
 * @author alexandrebraganca
 */

import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.ExtensionSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.Contact;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.ContactRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
class JpaContactRepository extends CrmJpaRepositoryBase<Contact, Long> implements ContactRepository {

    JpaContactRepository(ExtensionSettings settings) {
        super(settings);
    }

    @Override
    public boolean removeContact(Contact c) throws DataIntegrityViolationException {
        try {
            delete(c);
        }
        catch (Exception ex) {
            throw new DataIntegrityViolationException(ex);
        }
        return true;
    }
}
