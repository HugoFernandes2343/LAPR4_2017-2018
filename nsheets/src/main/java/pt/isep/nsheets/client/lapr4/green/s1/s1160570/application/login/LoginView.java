package pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login;

import com.google.gwt.event.dom.client.ClickHandler;
import javax.inject.Inject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

class LoginView extends ViewImpl implements LoginPresenter.MyView {

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

    @Override
    public MaterialTextBox getTextEmail() {
        return textEmail;
    }

    @Override
    public MaterialTextBox getTextPassword() {
        return textPassword;
    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        btnLogin.addClickHandler(ch);
    }

}
