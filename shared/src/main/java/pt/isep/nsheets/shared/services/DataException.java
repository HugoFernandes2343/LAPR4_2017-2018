package pt.isep.nsheets.shared.services;

public class DataException extends Exception {

    /**
     *
     */
    public DataException() {
    }

    /**
     * @param arg0
     */
    public DataException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public DataException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public DataException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}