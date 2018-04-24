/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.persistence.repositories;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;

import java.util.Optional;

/**
 * A generic interface for repositories.
 *
 * @param <T> the class we want to manage in the repository
 * @param <K> the class denoting the primary key of the entity
 * @author Paulo Gandra Sousa
 */
public interface Repository<T, K> {

    /**
     * Saves an entity either by creating it or updating it in the persistence
     * store.
     *
     * @param entity
     * @return
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    T save(T entity) throws DataConcurrencyException, DataIntegrityViolationException;

    /**
     * gets all entities from the repository.
     *
     * @return
     */
    Iterable<T> findAll();

    /**
     * gets the entity with the specified primary key
     *
     * @param id
     * @return
     */
    Optional<T> findOne(K id);

    /**
     * returns the number of entities in the repository.
     *
     * @return
     */
    long count();
}
