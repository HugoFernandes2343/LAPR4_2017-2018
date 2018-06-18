package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;

import java.util.List;

@RemoteServiceRelativePath("usersService")
public interface UsersService extends RemoteService {

    UserDTO getUserByEmail(String email);
    UserDTO getUser(String email, String password);
    UserDTO saveUser(UserDTO user);
    UserDTO updateUser(UserDTO user);
    List<UserDTO> getAllUser();
    List<UserDTO> getUsers();
    Boolean deleteUser(String email);
    Boolean activateUser(UserDTO user);
    Boolean deactivateUser(UserDTO user);

}

