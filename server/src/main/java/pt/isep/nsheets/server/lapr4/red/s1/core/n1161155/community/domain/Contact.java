package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain;


import eapli.framework.domain.AggregateRoot;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"u1", "u2"})
})
public class Contact implements Serializable, AggregateRoot<Long> {

    private static final Long serialVersionUID = 1L;

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;


    private User u1;
    private User u2;

    protected  Contact(){
    }

    public Contact(User u1, User u2) {
        this.u1 = u1;
        this.u2 = u2;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Contact contact = (Contact) other;
        return Objects.equals(pk, contact.pk) &&
                Objects.equals(u1, contact.u1) &&
                Objects.equals(u2, contact.u2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pk, u1, u2);
    }

    @Override
    public boolean is(Long id) {
        return id == pk;
    }

    @Override
    public Long id() {
        return pk;
    }
}
