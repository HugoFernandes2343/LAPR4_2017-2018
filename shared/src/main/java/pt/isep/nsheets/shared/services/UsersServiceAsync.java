package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UsersServiceAsync {

    void getUser(String email,String password, AsyncCallback<UserDTO> callback);
}
