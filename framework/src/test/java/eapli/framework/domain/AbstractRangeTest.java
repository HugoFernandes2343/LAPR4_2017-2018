/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.framework.domain;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class AbstractRangeTest {

    protected static final int START_VALUE = 5;
    protected static final int DELTA_VALUE = 5;
    protected static final int END_VALUE = START_VALUE + DELTA_VALUE;
    protected static final Long START = new Long(START_VALUE);
    protected static final Long END = new Long(END_VALUE);
    protected static Range<Long> instance;

    protected AbstractRangeTest() {
    }
}
