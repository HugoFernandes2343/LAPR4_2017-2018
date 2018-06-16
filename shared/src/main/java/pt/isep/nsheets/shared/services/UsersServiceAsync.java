package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UsersServiceAsync {

    void getUserByEmail(String email, AsyncCallback<UserDTO> callback);
    void getUser(String email, String password, AsyncCallback<UserDTO> callback);
    void saveUser(UserDTO user, AsyncCallback<UserDTO> callback);
   // void saveUserChatList(UserDTO user, AsyncCallback<UserDTO> callback);
}
