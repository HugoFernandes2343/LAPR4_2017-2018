package pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void addClickHandler(ClickHandler ch);
    }

    @NameToken(NameTokens.login)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<LoginPresenter> {
    }

    @Inject
    LoginPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        this.view = view;

        this.view.addClickHandler((event) -> {
            UsersServiceAsync usersSvc = GWT.create(UsersService.class);

            AsyncCallback<ArrayList<UserDTO>> callback = new AsyncCallback<ArrayList<UserDTO>>() {

                @Override
                public void onSuccess(ArrayList<UserDTO> result) {
                    MaterialToast.fireToast("Sucess");
                }

                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Insucess");
                }
            };
            usersSvc.getUsers(callback);
        });

    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }
}
