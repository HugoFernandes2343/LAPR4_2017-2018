/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.persistence.repositories;

import java.util.Iterator;

/**
 * A Repository which can be efficiently iterated.
 *
 * the implementation class must provide for an efficient iterator over all
 * entities in the repository. this is particular the case for database-backed
 * up persistence stores where one expects a cursor like behaviour. it is the
 * responsibility of the implementation class to handle disconnected scenarios
 * or not.
 *
 * @author Paulo Gandra Sousa
 */
public interface IterableRepository<T, K> extends Repository<T, K>, Iterable<T> {

    Iterator<T> iterator(int pagesize);

    /**
     * returns the first entity according to its "natural" order
     *
     * @return
     */
    T first();

    /**
     * returns the first n entities according to its "natural" order
     *
     * @param n
     * @return
     */
    Iterable<T> first(int n);
}
