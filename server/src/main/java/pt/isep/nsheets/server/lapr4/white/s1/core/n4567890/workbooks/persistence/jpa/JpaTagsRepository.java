/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.TagsRepository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.s1150575.exportToXML.domain.Tags;

/**
 *
 * @author João Vieira
 */
public class JpaTagsRepository extends NSheetsJpaRepositoryBase<Tags, Long> implements TagsRepository {

    public JpaTagsRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public Tags getTags(String workbookTag, String worksheetTag, String cellTag) {
        Tags t = matchOne("t.workbookTag=:workbookTag and t.worksheetTag=:worksheetTag and t.cellTag=:cellTag",
                "workbookTag", workbookTag, "worksheetTag", worksheetTag, "cellTag", cellTag);
        return t;
    }

}
