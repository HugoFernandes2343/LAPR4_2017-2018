/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import pt.isep.nsheets.server.lapr4.green.s1.ipc.s1150575.exportToXML.domain.Tags;

/**
 *
 * @author João Vieira
 */
public interface TagsRepository {
    public Tags getTags(String workbookTag, String worksheetTag, String cellTag);
}
