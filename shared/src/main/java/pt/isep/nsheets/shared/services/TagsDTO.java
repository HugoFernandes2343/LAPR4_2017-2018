/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.lapr4.green.s1.ipc.s1150575.services.Tags;

/**
 *
 * @author João Vieira
 */
public class TagsDTO {

    private String workbookTag;
    private String worksheetTag;
    private String cellTag;

    public TagsDTO(String workbookTag, String worksheetTag, String cellTag) {
        this.workbookTag = workbookTag;
        this.worksheetTag = worksheetTag;
        this.cellTag = cellTag;
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
