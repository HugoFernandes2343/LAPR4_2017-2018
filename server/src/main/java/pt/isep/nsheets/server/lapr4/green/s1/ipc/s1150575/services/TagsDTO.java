/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.ipc.s1150575.services;

import pt.isep.nsheets.shared.lapr4.green.s1.ipc.s1150575.services.Tags;
import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author João Vieira
 */
public class TagsDTO implements AggregateRoot<Long>, Serializable {

    @Id
    @GeneratedValue
    private Long pk = null;
    private String workbookTag;
    private String worksheetTag;
    private String cellTag;

    public TagsDTO() {
    }

    public TagsDTO(String workbookTag, String worksheetTag, String cellTag) {
        this.workbookTag = workbookTag;
        this.worksheetTag = worksheetTag;
        this.cellTag = cellTag;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof TagsDTO)) {
            return false;
        }

        final TagsDTO that = (TagsDTO) other;
        if (this == that) {
            return true;
        }
        if (!this.workbookTag.equals(that.workbookTag)) {
            return false;
        }
        if (!this.worksheetTag.equals(that.worksheetTag)) {
            return false;
        }
        if (!this.cellTag.equals(that.cellTag)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.pk;
    }

    public String getWorkbookTag() {
        return workbookTag;
    }

    public String getWorksheetTag() {
        return worksheetTag;
    }

    public String getCellTag() {
        return cellTag;
    }

    public Tags toTags() {
        return new Tags(this.workbookTag, this.worksheetTag, this.cellTag);
    }

    public static TagsDTO fromTags(Tags t) throws IllegalArgumentException {
        return new TagsDTO(t.getWorkbookTag(), t.getWorksheetTag(), t.getCellTag());
    }

}
