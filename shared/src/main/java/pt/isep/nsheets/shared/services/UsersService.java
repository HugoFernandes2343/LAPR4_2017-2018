package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("usersService")
public interface UsersService extends RemoteService {

    UserDTO getUserByEmail(String email);
    UserDTO getUser(String email, String password);
    UserDTO saveUser(UserDTO user);
    //UserDTO saveUserChatList(UserDTO user);
}

