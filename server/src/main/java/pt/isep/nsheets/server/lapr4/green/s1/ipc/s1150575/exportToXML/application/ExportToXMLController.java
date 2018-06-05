/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.ipc.s1150575.exportToXML.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.TagsRepository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.s1150575.exportToXML.domain.Tags;

/**
 *
 * @author João Vieira
 */
public class ExportToXMLController implements Controller {

    public Tags tags(String workbookTag, String worksheetTag, String cellTag) {
        TagsRepository tagsRepository = PersistenceContext.repositories().tags();
        return tagsRepository.getTags(workbookTag, worksheetTag, cellTag);
    }
}
