package pt.isep.nsheets.client.application.extensionmanager;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ExtensionManagerModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bindPresenter(ExtensionManagerPresenter.class,ExtensionManagerPresenter.MyView.class,ExtensionManagerView.class,ExtensionManagerPresenter.MyProxy.class);
    }
}
