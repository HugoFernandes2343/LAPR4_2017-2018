/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.persistence.activerecord;

import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface Finder<T extends ActiveRecord<T>, ID> {

    T findById(ID id);

    List<T> all();
}
