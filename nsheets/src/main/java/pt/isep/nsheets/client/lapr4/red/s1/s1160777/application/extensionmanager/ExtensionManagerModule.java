package pt.isep.nsheets.client.lapr4.red.s1.s1160777.application.extensionmanager;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ExtensionManagerModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bindPresenter(ExtensionManagerPresenter.class,ExtensionManagerPresenter.MyView.class,ExtensionManagerView.class,ExtensionManagerPresenter.MyProxy.class);
    }
}
