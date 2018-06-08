package pt.isep.nsheets.client.application.menu;

import com.google.gwt.event.dom.client.ClickHandler;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import gwt.material.design.client.ui.MaterialLink;

import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSideNavPush;

class MenuView extends ViewWithUiHandlers<MenuUiHandlers> implements MenuPresenter.MyView {

    interface Binder extends UiBinder<Widget, MenuView> {
    }

    @UiField
    MaterialNavBar navBar;
    @UiField
    MaterialSideNavPush sideNav;
    @UiField
    MaterialLink btnLogout;

    @Inject
    MenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        btnLogout.addClickHandler(ch);
    }


}
