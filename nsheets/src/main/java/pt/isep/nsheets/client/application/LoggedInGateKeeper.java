/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.DefaultGatekeeper;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

/**
 *
 * @author Paulo Jorge
 */
@DefaultGatekeeper
public class LoggedInGateKeeper implements Gatekeeper {

    private final CurrentUser currentUser;

    @Inject
    public LoggedInGateKeeper(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public boolean canReveal() {
        return true;
    }

}
