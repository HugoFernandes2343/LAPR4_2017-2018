package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.ext.Extension;

import java.util.ArrayList;



public interface ExtensionsServiceAsync {

    void getExtensions(AsyncCallback<ArrayList<Extension>> callback);

}
