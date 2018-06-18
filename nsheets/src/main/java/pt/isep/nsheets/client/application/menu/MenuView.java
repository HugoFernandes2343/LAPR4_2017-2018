package pt.isep.nsheets.client.application.menu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSideNavPush;
import gwt.material.design.client.ui.MaterialToast;

class MenuView extends ViewWithUiHandlers<MenuUiHandlers> implements MenuPresenter.MyView {

    interface Binder extends UiBinder<Widget, MenuView> {
    }

    @UiField
    MaterialNavBar navBar;
    @UiField
    MaterialSideNavPush sideNav;
    @UiField
    MaterialLink btnLogout;
    @UiField
    MaterialLink btnSingUp;
    @UiField
    MaterialLink btnLogin;
    @UiField
    MaterialLabel userName;
    @UiField
    MaterialImage userImage;

    @Override
    public MaterialLabel getUserName() {
        return userName;
    }

    @Override
    public MaterialImage getUserImage() {
        return userImage;
    }

    @Inject
    MenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
//        userImage.addClickHandler((event) -> {
//            MaterialToast.fireToast("dd");
//        });
    }

    @Override
    public MaterialLink getBtnLogin() {
        return btnLogin;
    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        btnLogout.addClickHandler(ch);
    }
    
    @Override
    public void addClicker(ClickHandler ch){
        userImage.addClickHandler(ch);
     
    }

    @Override
    public MaterialLink getBtnLogout() {
        return btnLogout;
    }

    @Override
    public MaterialLink getSingUp() {
        return btnSingUp;
    }

}
