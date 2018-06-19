package pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.CurrentMenu;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> {

//    CurrentUser user;
    interface MyView extends View {

        MaterialTextBox getTextEmail();

        MaterialTextBox getTextPassword();

        void addClickHandler(ClickHandler ch);
    }

    @NameToken(NameTokens.login)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<LoginPresenter> {
    }

    @Inject
    LoginPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager, CurrentUser currentUser) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

//        this.user = currentUser;
        getView().addClickHandler((ClickEvent event) -> {

            UsersServiceAsync usersSvc = GWT.create(UsersService.class);

            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Login Insucess");
                    getView().getTextEmail().setText("");
                    getView().getTextPassword().setText("");
                }

                @Override
                public void onSuccess(UserDTO result) {
//                    user.setCurrentUser(result);
//                    user.setIsLoggedIn(true);
                    if (result.isActivate() == false) {
                        MaterialToast.fireToast("Your Account is Deactivated!");
                    } else {
                        CurrentUser.setCurrentUser(result);
                        CurrentUser.setIsLoggedIn(true);
                        MaterialToast.fireToast("Sucess");

                        PlaceRequest placeRequest = new PlaceRequest.Builder()
                                .nameToken(NameTokens.home)
                                .build();
                        placeManager.revealPlace(placeRequest);

                        CurrentMenu.MenuReload();
                    }
                }
            };

            usersSvc.getUser(getView().getTextEmail().getText(), getView().getTextPassword().getText(), callback);
        });

    }
//
//    public CurrentUser getUser() {
//        return user;
//    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Login", "Insert email and password", "", "", this);
        getView().getTextEmail().setText("");
        getView().getTextPassword().setText("");
    }

}
