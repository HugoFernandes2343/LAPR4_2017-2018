package pt.isep.nsheets.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;



public interface UsersServiceAsync {

	void getUsers(AsyncCallback<ArrayList<UserDTO>> callback);

	
}
