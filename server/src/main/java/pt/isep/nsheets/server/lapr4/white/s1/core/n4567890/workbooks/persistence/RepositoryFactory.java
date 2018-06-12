/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;


import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.persistenc.CalendarRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    PersistenceSettings setSettings(PersistenceSettings settings);
    
    WorkbookDescriptionRepository workbookDescriptions();

    WorkbookRepository workbooks();
    
    UserRepository user();

    EventRepository events();
    
    TagsRepository tags();

    RequestRepository requests();

    ContactRepository contacts();

    TaskRepository task();

    MessageRepository messages();

    CalendarRepository calendares();
}
