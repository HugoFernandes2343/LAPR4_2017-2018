package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.Extension;

import java.util.ArrayList;

@RemoteServiceRelativePath("extensionmanager")
public interface ExtensionsService extends RemoteService {

    ArrayList<Extension> getExtensions();
}
