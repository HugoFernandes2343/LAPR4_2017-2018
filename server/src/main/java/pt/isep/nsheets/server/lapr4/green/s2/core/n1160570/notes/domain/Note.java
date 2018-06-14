/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s2.core.n1160570.notes.domain;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.shared.services.NoteDTO;

/**
 *
 * @author Paulo Jorge
 */
@Entity
@Table(name = "NOTE")
public class Note implements AggregateRoot<Long>, Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    private User user;
    private String title;

    protected Note() {
    }

    public Note(User user, String title) {
        this.user = user;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Note " + "id=" + id + ", user=" + user + ", title=" + title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.user);
        hash = 59 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Note other = (Note) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Note)) {
            return false;
        }

        final Note that = (Note) other;
        if (this == that) {
            return true;
        }
        if (!this.user.equals(that.user)) {
            return false;
        }
        if (!this.title.equals(that.title)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean is(Long id) {
        return (this.id.equals(this.id));
    }

    @Override
    public Long id() {
        return this.id;
    }

    public NoteDTO toDTO() {
        return new NoteDTO(user.toDTO(), title);
    }

    public static Note fromDTO(NoteDTO dto) throws IllegalArgumentException {
        return new Note(User.fromDTO(dto.getUser()), dto.getTitle());
    }

}
