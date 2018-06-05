/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.s1.ipc.s1150575.services;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author João Vieira
 */
public class Tags implements Serializable {

    @Id
    @GeneratedValue
    private Long pk = null;
    private String workbookTag;
    private String worksheetTag;
    private String cellTag;

    public Tags() {
    }

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

}
