/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import javax.persistence.EntityManager;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.*;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    private PersistenceSettings settings = null;

    @Override
    public PersistenceSettings setSettings(PersistenceSettings settings) {
        return this.settings = settings;
    }

    @Override
    public WorkbookDescriptionRepository workbookDescriptions() {
        return new JpaWorkbookDescriptionRepository(this.settings);
    }

    @Override
    public WorkbookRepository workbooks() {
        return new JpaWorkbookRepository(this.settings);
    }

    @Override
    public UserRepository user() {
        return new JpaLoginRepository(this.settings);
    }

    @Override
    public EventRepository events() {
        return new JpaEventRepository(this.settings);
    }

    @Override
    public RequestRepository requests() {
        return new JpaRequestRepository(this.settings);
    }

    @Override
    public ContactRepository contacts() {
        return new JpaContactRepository(this.settings);
    }
}
