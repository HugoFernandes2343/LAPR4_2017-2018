package pt.isep.nsheets.client.application.smartsheet;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class SmartSheetViewModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(SmartSheetViewPresenter.class, SmartSheetViewPresenter.MyView.class, SmartSheetViewView.class, SmartSheetViewPresenter.MyProxy.class);
    }
}