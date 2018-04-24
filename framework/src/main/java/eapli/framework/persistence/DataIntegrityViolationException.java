/**
 *
 */
package eapli.framework.persistence;

/**
 * An exception that violates a data integrity constraint like a duplicate key
 *
 * @author Paulo Gandra Sousa
 *
 */
public class DataIntegrityViolationException extends Exception {

    /**
     *
     */
    public DataIntegrityViolationException() {
    }

    /**
     * @param arg0
     */
    public DataIntegrityViolationException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public DataIntegrityViolationException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public DataIntegrityViolationException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}
