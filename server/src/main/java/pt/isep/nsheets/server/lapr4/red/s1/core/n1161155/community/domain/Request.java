package pt.isep.nsheets.server.lapr4.red.s1.core.n1161155.community.domain;

import eapli.framework.domain.AggregateRoot;
import eapli.framework.domain.ValueObject;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"senderEmail", "recieverEmail"})
})
public class Request implements Serializable, AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    private Email senderEmail;

    private Email recieverEmail;

    protected  Request(){
        this.recieverEmail = null ;
        this.senderEmail = null;
    }

    public Request(Email senderEmail, Email recieverEmail) {
        this.senderEmail = senderEmail;
        this.recieverEmail = recieverEmail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, senderEmail, recieverEmail);
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Request request = (Request) other;
        return Objects.equals(id, request.id) &&
                Objects.equals(senderEmail, request.senderEmail) &&
                Objects.equals(recieverEmail, request.recieverEmail);
    }

    @Override
    public boolean is(Long id) {
        return id == this.id;
    }

    @Override
    public Long id() {
        return id;
    }
}
