/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.presentation.console;

import eapli.framework.visitor.Visitor;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple widget to list the items of a collection
 *
 * e.g., create a widget for User
 *
 * {@code 
 * Collection<User> itens = controller.all(); 
 * ListWidget<User> wg = new ListWidget<>(itens, new ShowUserVisitor());
 * }
 *
 *
 * @author Paulo Gandra Sousa
 * @param <T>
 *            the type of element each item in list is
 */
public class ListWidget<T> {

    protected final Collection<T> source;
    private final Visitor<T> visitor;

    public ListWidget(Collection<T> source) {
        this(source, (e) -> {
            System.out.println(e);
        });
    }

    public ListWidget(Iterable<T> source) {
        this(source, (e) -> {
            System.out.println(e);
        });
    }

    public ListWidget(Collection<T> source, Visitor<T> visitor) {
        this.source = source;
        this.visitor = visitor;
    }

    public ListWidget(Iterable<T> source, Visitor<T> visitor) {
        this.source = new ArrayList<>();
        source.forEach(elem -> this.source.add(elem));
        this.visitor = visitor;
    }

    public void show() {
        int position = 0;
        for (final T et : this.source) {
            position++;
            System.out.print(position + ". ");
            this.visitor.visit(et);
        }
    }

    protected int size() {
        return this.source.size();
    }
}
