package pt.isep.nsheets.client.application.Contacts;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ContactsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ContactsPresenter.class, ContactsPresenter.MyView.class, ContactsView.class, ContactsPresenter.MyProxy.class);
    }
}
