package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("usersService")
public interface UsersService extends RemoteService {
	ArrayList<UserDTO> getUsers();
	
}
