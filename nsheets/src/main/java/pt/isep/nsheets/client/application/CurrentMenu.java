/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application;

import pt.isep.nsheets.client.application.menu.MenuPresenter;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class CurrentMenu {
    static MenuPresenter mps;

    public static MenuPresenter getMps() {
        return mps;
    }

    public static void setMps(MenuPresenter mps) {
        CurrentMenu.mps = mps;
    }
     
    public static void MenuReload(){
        CurrentMenu.mps.reloadUser();
    }
}
