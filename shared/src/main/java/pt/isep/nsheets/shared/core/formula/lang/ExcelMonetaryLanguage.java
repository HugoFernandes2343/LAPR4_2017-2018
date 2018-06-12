/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.lang;


/**
 *
 * @author Paulo Jorge
 */
public class ExcelMonetaryLanguage extends Language {

    @Override
    protected void initBinaryOperators() {
        binaryOperators.add(new Adder());
        binaryOperators.add(new Subtracter());
        binaryOperators.add(new Divider());
        binaryOperators.add(new Multiplier());

    }

    @Override
    protected void initUnaryOperators() {
        unaryOperators.add(new Formatter("e"));
        unaryOperators.add(new Formatter("$"));
        unaryOperators.add(new Formatter("£"));
        
    }

    public ExcelMonetaryLanguage(String name) {
        super(name);
    }
}
