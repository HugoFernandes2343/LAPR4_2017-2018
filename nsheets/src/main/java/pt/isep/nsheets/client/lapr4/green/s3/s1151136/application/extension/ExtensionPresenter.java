package pt.isep.nsheets.client.lapr4.green.s3.s1151136.application.extension;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.html.ListItem;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.application.menu.MenuView;
import pt.isep.nsheets.client.application.workbook.WorkbookView;

public class ExtensionPresenter extends Presenter<ExtensionPresenter.MyView, ExtensionPresenter.MyProxy> {

    interface MyView extends View {

        MaterialTextBox getTxtPopup();

        MaterialTextBox getTxtMenu();

        void popupClickHandler(ClickHandler ch);

        void menuClickHandler(ClickHandler ch);

        void actCommentsClickHandler(ClickHandler ch);

        void disCommentsClickHandler(ClickHandler ch);

        void actImagesClickHandler(ClickHandler ch);

        void disImagesClickHandler(ClickHandler ch);

    }

    @NameToken(NameTokens.extension)
    @ProxyStandard

    interface MyProxy extends ProxyPlace<ExtensionPresenter> {
    }

    @Inject
    ExtensionPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

//        Popup menu option
        getView().popupClickHandler((event) -> {
            String popupName = getView().getTxtPopup().getText();
            MaterialLink newOption = new MaterialLink();
            if (popupName.isEmpty()) {
                MaterialToast.fireToast("Empty text box");
            } else {
                newOption.setText(popupName);
                newOption.setDisplay(Display.BLOCK);
                newOption.setIconType(IconType.POLYMER);
                newOption.setTextColor(Color.BLACK);
                WorkbookView.getPopupMenu().add(newOption);
            }
        });

//        Menu option
        getView().menuClickHandler((event) -> {
            String menuName = getView().getTxtMenu().getText();
            ListItem listItem = new ListItem();
            MaterialLink newMenu = new MaterialLink();
            if (menuName.isEmpty()) {
                MaterialToast.fireToast("Empty text box");
            } else {
                newMenu.setText(menuName);
                newMenu.setWaves(WavesType.DEFAULT);
                newMenu.setIconType(IconType.POLYMER);
                listItem.add(newMenu);
                MenuView.getSideNav().add(listItem);
            }
        });

//        Side bar option -> Comments
        getView().actCommentsClickHandler((event) -> {
            MaterialToast.fireToast("Activated");
        });

        getView().disCommentsClickHandler((event) -> {
            MaterialToast.fireToast("Disactivated");
        });

//        Side bar option -> Images
        getView().actImagesClickHandler((event) -> {
            MaterialToast.fireToast("Activated");
        });

        getView().disImagesClickHandler((event) -> {
            MaterialToast.fireToast("Disactivated");
        });

    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Extension", "", "", "", this);
    }

}
