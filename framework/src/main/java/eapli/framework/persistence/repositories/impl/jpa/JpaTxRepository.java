/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.persistence.repositories.impl.jpa;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;

/**
 * An utility class for implementing JPA repositories. This class' methods
 * initiate an explicit transaction and commit in the end of the method. check
 * JpaTxlessRepository if you want to have transaction control outside of the
 * base class (for instance, when using a JPA container)
 *
 * <p>
 * based on <a href=
 * "http://stackoverflow.com/questions/3888575/single-dao-generic-crud-methods-jpa-hibernate-spring"
 * > stackoverflow</a> and on
 * <a href="https://burtbeckwith.com/blog/?p=40">burtbeckwith</a>.
 * <p>
 * also have a look at
 * <a href="http://blog.xebia.com/tag/jpa-implementation-patterns/">JPA
 * implementation patterns</a>
 *
 * @author Paulo Gandra Sousa
 * @param <T> the entity type that we want to build a repository for
 * @param <K> the key type of the entity
 */
public abstract class JpaTxRepository<T, K extends Serializable> extends JpaTxlessRepository<T, K> {

    public JpaTxRepository(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    /**
     * removes the object from the persistence storage. the object reference is
     * still valid but the persisted entity is/will be deleted
     *
     * @param entity
     */
    @Override
    public void delete(T entity) {
        final EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        super.delete(entity);
        tx.commit();
    }

    /**
     * Removes the entity with the specified ID from the repository.
     *
     * @param entityId
     * sense for this repository
     */
    @Override
    public void deleteByPK(K entityId) {
        final EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        super.deleteByPK(entityId);
        tx.commit();
    }

    /**
     * adds <b>and commits</b> a new entity to the persistence store
     *
     * TODO it is controversial if the repository class should have explicit
     * knowledge of when to start a transaction and end it as well as to know
     * when to open a connection and close it. this is the kind of stuff that
     * the container (e.g., web server) should handle declaratively
     *
     * the following methods open and commit a transaction: add() save()
     * replace() remove()
     *
     * note that other methods in this class just work with the JPA unit of work
     * and expect the container to begin/commit transactions. they are: create()
     * update() delete()
     *
     * @param entity
     * @return the newly created persistent object
     * @throws DataIntegrityViolationException
     */
    @Override
    public boolean add(T entity) throws DataIntegrityViolationException {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        final EntityManager em = entityManager();
        try {
            final EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (final PersistenceException ex) {

            // if (ex.getCause() instanceof
            // org.hibernate.exception.ConstraintViolationException) {
            //
            // }
            // TODO need to check and make sure we only throw
            // DataIntegrityViolationException if we get sql state 23505
            throw new DataIntegrityViolationException(ex);
        } finally {
            em.close();
        }
        return true;
    }

    /**
     * Inserts or updates an entity <b>and commits</b>.
     *
     * note that you should reference the return value to use the persisted
     * entity, as the original object passed as argument might be copied to a
     * new object
     *
     * check <a href=
     * "http://blog.xebia.com/2009/03/23/jpa-implementation-patterns-saving-detached-entities/"
     * > JPA implementation patterns</a> for a discussion on saveOrUpdate()
     * behavior and merge()
     *
     * @param entity
     * @return the persisted entity - might be a different object than the
     * parameter
     * @throws eapli.framework.persistence.DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    @Override
    public T save(T entity) throws DataConcurrencyException, DataIntegrityViolationException {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        // the following code attempts to do a save or update
        // this could be made more efficient if we check if the entity has an
        // autogenerated id
        final EntityManager em = entityManager();
        assert em != null;
        try {
            final EntityTransaction tx = em.getTransaction();
            tx.begin();
            entity = em.merge(entity);
            tx.commit();
        } catch (final OptimisticLockException ex) {
            throw new DataConcurrencyException(ex);
        } catch (final PersistenceException ex) {

            // if (ex.getCause() instanceof
            // org.hibernate.exception.ConstraintViolationException) {
            //
            // }
            // TODO need to check and make sure we only throw
            // DataIntegrityViolationException if we get sql state 23505
            throw new DataIntegrityViolationException(ex);
        } finally {
            // we are closing the entity manager here because this code is
            // running in a non-container managed way. if it was the case to be
            // running under an application server with a JPA container and
            // managed transactions/sessions, one should not be doing this
            em.close();
        }

        return entity;
    }
}
