package pt.isep.nsheets.client.lapr4.green.s2.s1160570.application.exchange;

import pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login.*;
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
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.CurrentMenu;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.core.ConvertCurrencie;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

public class ExchangePresenter extends Presenter<ExchangePresenter.MyView, ExchangePresenter.MyProxy> {

    interface MyView extends View {

        void addClickHandler(ClickHandler ch);

        MaterialComboBox getComboBox1();

        MaterialComboBox getComboBox2();

        MaterialTextBox getValue();
    }

    @NameToken(NameTokens.exchange)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<ExchangePresenter> {
    }

    @Inject
    ExchangePresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager, CurrentUser currentUser) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        getView().addClickHandler((event) -> {

            if ((getView().getComboBox1().getSelectedValue().toString()).compareTo("[EURO]") == 0
                    && (getView().getComboBox2().getSelectedValue().toString()).compareTo("[EURO]") == 0) {
                MaterialToast.fireToast("Error, the currency is the same");
            }
            if ((getView().getComboBox1().getSelectedValue().toString()).compareTo("[DOLLAR]") == 0
                    && (getView().getComboBox2().getSelectedValue().toString()).compareTo("[DOLLAR]") == 0) {
                MaterialToast.fireToast("Error, the currency is the same");
            }
            if ((getView().getComboBox1().getSelectedValue().toString()).compareTo("[POUND]") == 0
                    && (getView().getComboBox2().getSelectedValue().toString()).compareTo("[POUND]") == 0) {
                MaterialToast.fireToast("Error, the currency is the same");
            }
            if ((getView().getComboBox1().getSelectedValue().toString()).compareTo("[EURO]") == 0
                    && (getView().getComboBox2().getSelectedValue().toString()).compareTo("[POUND]") == 0) {
                ConvertCurrencie.setPound_euro(Double.parseDouble(getView().getValue().getText()));
            }
            if ((getView().getComboBox1().getSelectedValue().toString()).compareTo("[POUND]") == 0
                    && (getView().getComboBox2().getSelectedValue().toString()).compareTo("[EURO]") == 0) {
                ConvertCurrencie.setPound_euro(1 / (Double.parseDouble(getView().getValue().getText())));
            }
            if ((getView().getComboBox1().getSelectedValue().toString()).compareTo("[POUND]") == 0
                    && (getView().getComboBox2().getSelectedValue().toString()).compareTo("[DOLLAR]") == 0) {
                ConvertCurrencie.setPound_dollar(1 / (Double.parseDouble(getView().getValue().getText())));
            }
            if ((getView().getComboBox1().getSelectedValue().toString()).compareTo("[DOLLAR]") == 0
                    && (getView().getComboBox2().getSelectedValue().toString()).compareTo("[POUND]") == 0) {
                ConvertCurrencie.setPound_dollar((Double.parseDouble(getView().getValue().getText())));
            }
            if ((getView().getComboBox1().getSelectedValue().toString()).compareTo("[EURO]") == 0
                    && (getView().getComboBox2().getSelectedValue().toString()).compareTo("[DOLLAR]") == 0) {
                ConvertCurrencie.setEuro_dollar(1 / (Double.parseDouble(getView().getValue().getText())));
            }
            if ((getView().getComboBox1().getSelectedValue().toString()).compareTo("[DOLLAR]") == 0
                    && (getView().getComboBox2().getSelectedValue().toString()).compareTo("[EURO]") == 0) {
                ConvertCurrencie.setEuro_dollar((Double.parseDouble(getView().getValue().getText())));
            }

        });
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Exchange", "", "", "", this);
    }

}
