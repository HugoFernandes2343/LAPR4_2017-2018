/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application;

import pt.isep.nsheets.shared.services.UserDTO;

/**
 *
 * @author Paulo Jorge
 */
public class CurrentUser {
    
    static boolean isLoggedIn;
    static UserDTO currentUser;
    static boolean showAll = true;
    
    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }
    
    public static void setIsLoggedIn(boolean isLoggedIn) {
        CurrentUser.isLoggedIn = isLoggedIn;
    }
    
    public static UserDTO getCurrentUser() {
        return currentUser;
    }
    
    public static void setCurrentUser(UserDTO currentUser) {
        CurrentUser.currentUser = currentUser;
    }

    public static boolean isShowAll() {
        return showAll;
    }

    public static void setShowAll(boolean showAll) {
        CurrentUser.showAll = showAll;
    }

    public static void logout() {
        CurrentUser.setCurrentUser(null);
        CurrentUser.setIsLoggedIn(false);
    }
}
