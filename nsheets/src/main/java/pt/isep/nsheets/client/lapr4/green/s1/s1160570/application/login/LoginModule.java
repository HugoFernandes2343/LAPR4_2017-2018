package pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class LoginModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(LoginPresenter.class, LoginPresenter.MyView.class, LoginView.class, LoginPresenter.MyProxy.class);
    }
}