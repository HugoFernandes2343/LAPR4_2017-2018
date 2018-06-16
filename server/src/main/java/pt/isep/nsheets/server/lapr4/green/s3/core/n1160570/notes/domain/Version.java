/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1160570.notes.domain;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import pt.isep.nsheets.shared.services.VersionDTO;

/**
 *
 * @author Paulo Jorge
 */
@Entity
@Table(name = "NOTE")
public class Version implements AggregateRoot<Long>, Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    private Note note;
    private String text;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    protected Version() {
    }

    public Version(Note note, String text) {
        this.note = note;
        this.text = text;
        this.date = new Date();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.note);
        hash = 61 * hash + Objects.hashCode(this.text);
        hash = 61 * hash + Objects.hashCode(this.date);
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
        final Version other = (Version) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Version)) {
            return false;
        }

        final Version that = (Version) other;
        if (this == that) {
            return true;
        }
        if (!this.date.equals(that.date)) {
            return false;
        }
        if (!this.text.equals(that.text)) {
            return false;
        }
        if (!this.note.equals(that.note)) {
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

    public VersionDTO toDTO() {
        return new VersionDTO(note.toDTO(), text);
    }

    public static Version fromDTO(VersionDTO dto) throws IllegalArgumentException {
        return new Version(Note.fromDTO(dto.getNote()), dto.getText());
    }

}
