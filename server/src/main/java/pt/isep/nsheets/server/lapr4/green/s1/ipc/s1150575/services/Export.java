/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.ipc.s1150575.services;

import pt.isep.nsheets.shared.services.WorkbookDTO;


/**
 *
 * @author João Vieira
 */
public class Export {

    private static String workbookTag;
    private static String worksheetTag;
    private static String cellTag;

    public static void workbookToXML(WorkbookDTO workbook) {

    }

    public static void worksheetToXML(WorkbookDTO workbook) {

    }

    public static void partOfWorksheetToXML(WorkbookDTO workbook) {

    }

    public static void setTags(TagsDTO tags) {
        Export.workbookTag = tags.getWorkbookTag();
        Export.worksheetTag = tags.getWorksheetTag();
        Export.cellTag = tags.getCellTag();
    }

}
