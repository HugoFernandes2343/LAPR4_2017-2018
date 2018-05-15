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
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.ExtensionSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.ContactRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.RepositoryFactory;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    private ExtensionSettings settings=null;
    
    public ExtensionSettings setSettings(ExtensionSettings settings) {
        return this.settings=settings;
    }

    @Override
    public ContactRepository contacts() {
        return new JpaContactRepository(this.settings);
    }

}
