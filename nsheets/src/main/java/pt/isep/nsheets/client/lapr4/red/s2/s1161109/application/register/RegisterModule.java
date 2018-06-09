/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.red.s2.s1161109.application.register;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class RegisterModule extends AbstractPresenterModule{

    @Override
    protected void configure() {
        bindPresenter(RegisterPresenter.class, RegisterPresenter.MyView.class, RegisterView.class, RegisterPresenter.MyProxy.class);
    }
    
}
