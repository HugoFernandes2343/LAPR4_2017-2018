/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.DefaultGatekeeper;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
@DefaultGatekeeper
public class LoggedInGateKeeper implements Gatekeeper {

    @Inject
    public LoggedInGateKeeper(UserDTO currentUser) {
        CurrentUser.setCurrentUser(currentUser);
    }

    @Override
    public boolean canReveal() {
        return true;
    }

}
