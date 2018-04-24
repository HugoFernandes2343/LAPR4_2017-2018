/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.persistence.repositories.impl.jpa;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import eapli.framework.persistence.repositories.DeleteableRepository;
import eapli.framework.persistence.repositories.IterableRepository;
import eapli.framework.persistence.repositories.Repository;
import eapli.util.Strings;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

/**
 * An utility class for implementing JPA repositories. This class' methods don't
 * initiate an explicit transaction relying on an outside Transaction-enabled
 * container. check JpaTxRepositoryBase if you want to have transaction control
 * inside the base class
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
public class JpaTxlessRepository<T, K extends Serializable>
        implements Repository<T, K>, IterableRepository<T, K>, DeleteableRepository<T, K> {
    private static final int DEFAULT_PAGESIZE = 20;

    //(ATB)private final String persistenceUnitName;
    protected final String persistenceUnitName;

    protected final Class<T> entityClass;

    // will be injected by Spring
    @PersistenceUnit
    //(ATB)private EntityManagerFactory emFactory;
    protected EntityManagerFactory emFactory;
    private EntityManager entityManager;

    /**
     *
     * @param persistenceUnitName the name of the persistence unit to use if the
     * repository is not running in a container that will inject a dully
     * configured EntityManagerFactory
     */
    @SuppressWarnings("unchecked")
    public JpaTxlessRepository(String persistenceUnitName) {
        if (persistenceUnitName == null) {
            throw new IllegalArgumentException("Must provide the persistence unit name");
        }
        this.persistenceUnitName = persistenceUnitName;
        final ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    protected EntityManagerFactory entityManagerFactory() {
        if (this.emFactory == null) {
            assert !Strings.isNullOrEmpty(this.persistenceUnitName) : "the persistence unit name must be provided";
            Logger.getLogger(this.getClass().getSimpleName())
                    .info("EAPLI-F-PJ001: Not runing in container mode; creating entity manager factory by hand");
            this.emFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
        }
        return this.emFactory;
    }

    protected EntityManager entityManager() {
        if (this.entityManager == null || !this.entityManager.isOpen()) {
            this.entityManager = entityManagerFactory().createEntityManager();
        }
        return this.entityManager;
    }

    /**
     * adds a new entity to the persistence store
     *
     * @param entity
     * @return the newly created persistent object
     */
    public T create(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        this.entityManager().persist(entity);
        return entity;
    }

    /**
     * reads an entity given its K
     *
     * @param id
     * @return
     */
    public Optional<T> read(K id) {
        return Optional.ofNullable(this.entityManager().find(this.entityClass, id));
    }

    /**
     * reads an entity given its K
     *
     * @param id
     * @return
     */
    @Override
    public Optional<T> findOne(K id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        return read(id);
    }

    public T update(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        return entityManager().merge(entity);
    }

    /**
     * removes the object from the persistence storage. the object reference is
     * still valid but the persisted entity is/will be deleted
     *
     * @param entity
     */
    @Override
    public void delete(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        entity = entityManager().merge(entity);
        entityManager().remove(entity);
    }

    /**
     * Removes the entity with the specified ID from the repository.
     *
     * @param entityId
     * sense for this repository
     */
    @Override
    public void deleteByPK(K entityId) {
        if (entityId == null) {
            throw new IllegalArgumentException();
        }

        // TODO this is not efficient...
        final Optional<T> entity = findOne(entityId);
        if (entity.isPresent()) {
            delete(entity.get());
        }
    }

    /**
     * returns the number of entities in the persistence store
     *
     * @return the number of entities in the persistence store
     */
    @Override
    public long count() {
        return (Long) entityManager().createQuery("SELECT COUNT(*) FROM " + this.entityClass.getSimpleName())
                .getSingleResult();
    }

    /**
     * checks for the existence of an entity with the provided K.
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        return findOne(key) != null;
    }

    /**
     * adds <b>and commits</b> a new entity to the persistence store
     *
     * @param entity
     * @return the newly created persistent object
     * @throws DataIntegrityViolationException
     */
    public boolean add(T entity) throws DataIntegrityViolationException {
        create(entity);
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
        // the following code attempts to do a save or update by checking for
        // persistence exceptions while doing persist()
        // this could be made more efficient if we check if the entity has an
        // autogenerated id
        try {
            create(entity);
        } catch (final PersistenceException ex) {
            // if the persist failed due to a locking problem, just throw
            // and exit
            if (ex.getCause().getClass() == OptimisticLockException.class) {
                throw new DataConcurrencyException(ex);
            }

            try {
                update(entity);
            } catch (final OptimisticLockException exMerge) {
                throw new DataConcurrencyException(ex);
            }
            // TODO need to check other exceptions?
        }

        return entity;
    }

    /**
     * helper method to create a type query
     *
     * @return
     */
    protected TypedQuery<T> queryAll() {
        final String className = this.entityClass.getSimpleName();
        return entityManager().createQuery("SELECT e FROM " + className + " e ", this.entityClass);
    }

    private TypedQuery<T> query(String where) {
        assert !Strings.isNullOrEmpty(where) : "query must not be null or empty";

        final String className = this.entityClass.getSimpleName();
        return entityManager().createQuery("SELECT e FROM " + className + " e WHERE " + where, this.entityClass);
    }

    /**
     * helper method to create a typed query with a where clause
     *
     * @param where
     * @param params
     * @return
     */
    protected TypedQuery<T> query(String where, Map<String, Object> params) {
        assert !Strings.isNullOrEmpty(where) : "query must not be null or empty";
        assert params != null && params.size() > 0 : "Params must not be null or empty";

        final TypedQuery<T> q = query(where);
        params.entrySet().stream().forEach((e) -> {
            q.setParameter(e.getKey(), e.getValue());
        });
        return q;
    }

    /**
     * returns the first n entities according to its "natural" order
     *
     * @param n
     * @return
     */
    @Override
    public List<T> first(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        final TypedQuery<T> q = queryAll();
        q.setMaxResults(n);
        return q.getResultList();
    }

    /**
     * returns the first entity according to its "natural" order
     *
     * @return
     */
    @Override
    public T first() {
        final List<T> r = first(1);
        return r.isEmpty() ? null : r.get(0);
    }

    public T last() {
        throw new UnsupportedOperationException();
    }

    public List<T> page(int pageNumber, int pageSize) {
        if (pageNumber <= 0 || pageSize <= 0) {
            throw new IllegalArgumentException();
        }
        final TypedQuery<T> q = queryAll();
        q.setMaxResults(pageSize);
        q.setFirstResult((pageNumber - 1) * pageSize);

        return q.getResultList();
    }


    /**
     * returns a paged iterator
     *
     * @return
     */
    @Override
    public Iterator<T> iterator(int pagesize) {
        return new JpaPagedIterator(this, pagesize);
    }

    @Override
    public Iterator<T> iterator() {
        return new JpaPagedIterator(this, DEFAULT_PAGESIZE);
    }

    @Override
    public Iterable<T> findAll() {
        // TODO check performance impact of this 'where' clause
        return match("1=1");
    }

    /**
     * searches for objects that match the given criteria
     *
     * helper method. not to be exposed as public in any situation. the where
     * clause should use "e" as the query object
     *
     * @param where
     * @return
     */
    protected List<T> match(String where) {
        assert !Strings.isNullOrEmpty(where) : "query must not be null or empty";

        final TypedQuery<T> q = query(where);
        return q.getResultList();
    }

    protected List<T> match(String whereWithParameters, Map<String, Object> params) {
        assert !Strings.isNullOrEmpty(whereWithParameters) : "query must not be null or empty";
        assert params != null && params.size() > 0 : "Params must not be null or empty";

        final TypedQuery<T> q = query(whereWithParameters, params);
        return q.getResultList();
    }

    /**
     * searches for one object that matches the given criteria
     *
     * helper method. not to be exposed as public in any situation. the where
     * clause should use "e" as the query object
     *
     * @param where
     * @return
     */
    protected T matchOne(String where) {
        final TypedQuery<T> q = query(where);
        // TODO should we allow to throw NoResultException? it will expose a JPA
        // specific exception to domain layer. most likely we should return null
        return q.getSingleResult();
    }

    protected T matchOne(String whereWithParameters, Map<String, Object> params) {
        final TypedQuery<T> q = query(whereWithParameters, params);
        // TODO should we allow to throw NoResultException? it will expose a JPA
        // specific exception to domain layer. most likely we should return null
        return q.getSingleResult();
    }

    protected T matchOne(String where, Object... args) {
        final TypedQuery<T> q = query(where);
        boolean isArgName = true;
        String argName = "";
        for (final Object o : args) {
            if (isArgName) {
                argName = (String) o;
            } else {
                q.setParameter(argName, o);
            }
            isArgName = !isArgName;
        }
        // TODO should we allow to throw NoResultException? it will expose a JPA
        // specific exception to domain layer. most likely we should return null
        return q.getSingleResult();
    }
    /**
     * an iterator over JPA
     *
     * @author Paulo Gandra Sousa
     *
     */
    private class JpaPagedIterator implements Iterator<T> {
        
        private final JpaTxlessRepository<T, K> repository;
        private final int pageSize;
        private int currentPageNumber;
        private Iterator<T> currentPage;
        
        private JpaPagedIterator(JpaTxlessRepository<T, K> repository, int pagesize) {
            this.repository = repository;
            this.pageSize = pagesize;
        }
        
        @Override
        public boolean hasNext() {
            if (needsToLoadPage()) {
                loadNextPage();
            }
            return this.currentPage.hasNext();
        }
        
        @Override
        public T next() {
            if (needsToLoadPage()) {
                loadNextPage();
            }
            return this.currentPage.next();
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        private void loadNextPage() {
            final List<T> page = this.repository.page(++this.currentPageNumber, this.pageSize);
            this.currentPage = page.iterator();
        }
        
        private boolean needsToLoadPage() {
            // either we do not have an iterator yet or we have reached the end
            // of the (current) iterator
            return this.currentPage == null || !this.currentPage.hasNext();
        }
    }
}
