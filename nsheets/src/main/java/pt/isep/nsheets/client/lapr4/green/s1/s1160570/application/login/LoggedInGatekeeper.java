/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.DefaultGatekeeper;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.CurrentUser;

/**
 *
 * @author Paulo Jorge
 */
@DefaultGatekeeper
public class LoggedInGatekeeper implements Gatekeeper {

    private CurrentUser currentUser;

    @Inject
    public LoggedInGatekeeper(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public boolean canReveal() {
        return currentUser.isLoggedIn();
    }

}
