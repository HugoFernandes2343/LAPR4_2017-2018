/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.persistence.repositories;

/**
 * @author Paulo Gandra Sousa
 */
public interface DeleteableRepository<T, K> extends Repository<T, K> {

    /**
     * removes the specified entity from the repository.
     *
     * @param entity
     */

    void delete(T entity);

    /**
     * Removes the entity with the specified primary key from the repository.
     *
     * @param entityId
     */
    void deleteByPK(K entityId);
}
