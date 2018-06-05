package pt.isep.nsheets.client.application.Requests;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class RequestsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(RequestsPresenter.class, RequestsPresenter.MyView.class, RequestsView.class, RequestsPresenter.MyProxy.class);
    }
}
