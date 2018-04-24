/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.presentation.console;

import eapli.framework.visitor.Visitor;
import java.util.EnumSet;

/**
 * A simple widget that lists the items of a enum and allows the user to select
 * an item.
 *
 * @author Paulo Gandra Sousa
 * @param <T>
 *            the type of enum in the collection
 */
public class EnumSelectWidget<T extends Enum<T>> extends SelectWidget<T> {

    public EnumSelectWidget(Class<T> source) {
        super(EnumSet.allOf(source));
    }

    public EnumSelectWidget(Class<T> source, Visitor<T> visitor) {
        super(EnumSet.allOf(source), visitor);
    }
}
