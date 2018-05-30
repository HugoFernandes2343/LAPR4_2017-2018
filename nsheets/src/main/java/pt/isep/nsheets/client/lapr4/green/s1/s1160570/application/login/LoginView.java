package pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login;

import com.google.gwt.event.dom.client.ClickEvent;
import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.List;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.application.LoginController;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;

class LoginView extends ViewImpl implements LoginPresenter.MyView {

    LoginController controller = new LoginController();
    List<User> userList = controller.allUsers();

    interface Binder extends UiBinder<Widget, LoginView> {
    }
    @UiField
    MaterialButton btnLogin;

    @UiField
    MaterialTextBox textEmail, textPassword;

    @Inject
    LoginView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btnLogin")
    void onClick(ClickEvent e) {
        MaterialToast.fireToast("Click Triggered");
        
    }

}
