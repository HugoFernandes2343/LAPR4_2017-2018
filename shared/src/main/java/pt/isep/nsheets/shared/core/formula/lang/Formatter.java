/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lang;

import java.math.BigDecimal;
import java.math.RoundingMode;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.UnaryOperator;

/**
 *
 * @author Paulo Jorge
 */
public class Formatter implements UnaryOperator {

    private String i;

    public Formatter(String i) {
        this.i = i;
    }

    /**
     * Returns the negation of the operand's value.
     *
     * @return the negation of the operand's value
     * @throws IllegalValueTypeException if the value of the operand is not
     * numeric
     */
    @Override
    public Value applyTo(Expression operand) throws IllegalValueTypeException {
        double num = operand.evaluate().toNumber().doubleValue();
        num = round(num, 3);
        return new Value(num);

    }

    @Override
    public String getIdentifier() {
        return this.i;
    }

    @Override
    public boolean isPrefix() {
        return true;
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.NUMERIC;
    }

    @Override
    public String toString() {
        return getIdentifier();
    }

    /**
     * Rounds a double
     *
     * @param value double to round
     * @param places number of decimal places
     * @return the rounded double
     */
    private static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
