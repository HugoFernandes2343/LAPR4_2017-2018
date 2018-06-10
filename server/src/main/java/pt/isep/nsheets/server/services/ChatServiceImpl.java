package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161569.application.PublishMessageController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.ChatService;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.MessageDTO;

import java.util.ArrayList;
import java.util.Properties;

public class ChatServiceImpl extends RemoteServiceServlet implements ChatService {
    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url",
        // "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // props.put("javax.persistence.jdbc.password", "");
        // props.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // props.put("javax.persistence.jdbc.user", "");
        // props.put("javax.persistence.schema-generation.database.action", "create");
        // props.put("eclipselink.logging.level", "FINE");
        return new PersistenceSettings(props);
    }

    @Override
    public ArrayList<MessageDTO> getMessages() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        PublishMessageController ctrl = new PublishMessageController();
        return ctrl.getMessages();
    }

    @Override
    public MessageDTO addMessage(MessageDTO mDto) throws DataException {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        PublishMessageController ctrl = new PublishMessageController();

        try {
            return ctrl.addMessage(mDto);
        } catch (DataConcurrencyException ex) {
            throw new DataException((Throwable) ex);
        } catch (DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }

    }
}
