package pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.settings;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import pt.isep.nsheets.client.lapr4.red.s1.s1160777.application.extensionmanager.ExtensionManagerModule;

public class SettingsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

        //1160777
        install(new ExtensionManagerModule());

        bindPresenter(SettingsPresenter.class, SettingsPresenter.MyView.class, SettingsView.class, SettingsPresenter.MyProxy.class);
    }
}