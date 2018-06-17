package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("usersService")
public interface UsersService extends RemoteService {

    UserDTO getUserByEmail(String email);
    UserDTO getUser(String email, String password);
    UserDTO saveUser(UserDTO user);
    List<UserDTO> getAllUser();
}

