package pt.isep.nsheets.client.lapr4.green.s2.s1160570.application.exchange;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ExchangeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ExchangePresenter.class, ExchangePresenter.MyView.class, ExchangeView.class, ExchangePresenter.MyProxy.class);
    }
}