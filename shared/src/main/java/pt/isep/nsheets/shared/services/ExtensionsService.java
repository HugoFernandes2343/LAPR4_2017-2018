package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pt.isep.nsheets.shared.ext.Extension;

import java.util.ArrayList;

@RemoteServiceRelativePath("extensionsService")
public interface ExtensionsService extends RemoteService {
    ArrayList<Extension> getExtensions();
}
