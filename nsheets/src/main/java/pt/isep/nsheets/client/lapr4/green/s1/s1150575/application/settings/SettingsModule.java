package pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.settings;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class SettingsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(SettingsPresenter.class, SettingsPresenter.MyView.class, SettingsView.class, SettingsPresenter.MyProxy.class);
    }
}