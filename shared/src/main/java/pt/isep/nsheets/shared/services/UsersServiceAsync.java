package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;

public interface UsersServiceAsync {

    void getUser(String email, String password, AsyncCallback<UserDTO> callback);

    void getUsers(AsyncCallback<List<UserDTO>> callback);

    void saveUser(UserDTO user, AsyncCallback<UserDTO> callback);

    void updateUser(UserDTO user, AsyncCallback<UserDTO> callback);

    void deleteUser(String email, AsyncCallback<Boolean> callback);

    void activateUser(UserDTO user, AsyncCallback<Boolean> callback);

    void deactivateUser(UserDTO user, AsyncCallback<Boolean> callback);
}
