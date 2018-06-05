/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.ipc.s1150575.exportToXML.domain;

import pt.isep.nsheets.shared.services.TagsDTO;

/**
 *
 * @author João Vieira
 */
public class Tags {

    private String workbookTag;
    private String worksheetTag;
    private String cellTag;

    public Tags(String workbookTag, String worksheetTag, String cellTag) {
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

    public TagsDTO toDTO() {
        return new TagsDTO(workbookTag, worksheetTag, cellTag);
    }

    public static Tags fromDTO(TagsDTO t) throws IllegalArgumentException {
        return new Tags(t.getWorkbookTag(), t.getWorksheetTag(), t.getCellTag());
    }
}
