/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Properties;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.s1150575.exportToXML.application.ExportToXMLController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.TagsDTO;
import pt.isep.nsheets.shared.services.TagsService;

/**
 *
 * @author João Vieira
 */
public class TagsServiceImpl extends RemoteServiceServlet implements TagsService {

    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        return new PersistenceSettings(props);
    }

    @Override
    public TagsDTO getTags(String workbookTag, String worksheetTag, String cellTag) {
                PersistenceContext.setSettings(this.getPersistenceSettings());

        ExportToXMLController ctrl = new ExportToXMLController();

        return ctrl.tags(workbookTag, worksheetTag, cellTag).toDTO();
    }
    
    
}
