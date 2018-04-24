/**
 *
 */
package eapli.framework.domain;

import javax.persistence.Embeddable;
import java.util.Calendar;

/**
 * A specific range for time intervals.
 *
 * @author Paulo Gandra Sousa
 */
@Embeddable
public class TimePeriod extends Range<Calendar> {

    private static final long serialVersionUID = 1L;

    /**
     * creates an open time interval on both ends
     *
     * @param begin
     * @param end
     */
    public TimePeriod(Calendar begin, Calendar end) {
        super(begin, end, true, true);
    }

    /**
     * Creates a time interval from begin until "infinity".
     *
     * @param begin
     */
    public TimePeriod(Calendar begin) {
        super(begin, false, RangeInfinityType.TO_INFINITY);
    }

    protected TimePeriod() {
    }
}
