package pt.isep.nsheets.client.lapr4.green.s3.s1151136.application.extension;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ExtensionModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ExtensionPresenter.class, ExtensionPresenter.MyView.class, ExtensionView.class, ExtensionPresenter.MyProxy.class);
    }
}