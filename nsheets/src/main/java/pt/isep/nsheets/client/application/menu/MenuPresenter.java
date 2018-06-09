package pt.isep.nsheets.client.application.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import pt.isep.nsheets.client.event.ContentPushEvent;

import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.sun.glass.ui.Application;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Email;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Name;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Nickname;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.Password;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161109.register.application.RegisterController;
import pt.isep.nsheets.shared.services.EmailDTO;
import pt.isep.nsheets.shared.services.NameDTO;
import pt.isep.nsheets.shared.services.NicknameDTO;
import pt.isep.nsheets.shared.services.PasswordDTO;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

public class MenuPresenter extends PresenterWidget<MenuPresenter.MyView> implements MenuUiHandlers {
    
    
    @NameToken(NameTokens.menu)
    interface MyView extends View, HasUiHandlers<MenuUiHandlers> {

        void addClickHandler(ClickHandler ch);

        MaterialLink getBtnLogout();

        MaterialLink getBtnLogin();

        MaterialImage getUserImage();

        MaterialLabel getUserName();

    }

    @Inject
    MenuPresenter(EventBus eventBus, MyView view) {
        super(eventBus, view);

        getView().setUiHandlers(this);

        if (!CurrentUser.isIsLoggedIn()) {

            getView().getBtnLogout().setVisible(false);
            getView().getUserImage().setVisible(false);
            getView().getUserName().setVisible(false);

        } else {
            getView().getBtnLogin().setVisible(false);
            getView().getBtnLogout().setVisible(true);
            getView().getUserImage().setVisible(true);
            getView().getUserName().setVisible(true);
        }

        getView().addClickHandler((event) -> {
            
          getView().getBtnLogout().setVisible(false);
          CurrentUser.logout();
          getView().getBtnLogin().setVisible(true);
            

        });

    }

    protected void onBind() {
        super.onBind();
    }

    @Override
    public void setContentPush() {
        ContentPushEvent.fire(this);
    }
}
