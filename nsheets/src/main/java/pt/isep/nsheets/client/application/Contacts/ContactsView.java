package pt.isep.nsheets.client.application.Contacts;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.base.SearchObject;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

class ContactsView extends ViewImpl implements ContactsPresenter.MyView {
    interface Binder extends UiBinder<Widget, ContactsView> {
    }

    @UiField
    MaterialNavBar navBar, navBarSearch;

    @UiField
    MaterialSearch txtSearch;

    @UiField
    MaterialButton removeButton;

    @UiField
    MaterialLabel lblName, lblEmail,lblNickname;

    @Inject
    ContactsView(ContactsView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        removeButton.setVisible(true);
        // add open handler
        txtSearch.addOpenHandler(openEvent -> {
            navBar.setVisible(false);
            navBarSearch.setVisible(true);
        });

        // Add Close Handler
        txtSearch.addCloseHandler(event -> {
            navBar.setVisible(true);
            navBarSearch.setVisible(false);
        });

        /*
        // Populate the search keyword into search component
        List<SearchObject> objects = new ArrayList<>();
        for(Hero hero : DataHelper.getAllHeroes()){
            objects.add(hero);
        }
        txtSearch.setListSearches(objects);

        // Add Finish Handler
        txtSearch.addSearchFinishHandler(event -> {
            // Get the selected search object
            Hero hero = (Hero)txtSearch.getSelectedObject();
            new MaterialAnimation().transition(Transition.ZOOMIN).animate(imgHero);
            imgHero.setResource(hero.getResource());
            lblName.setText(hero.getName());
            lblDescription.setText(hero.getDescription());
            MaterialToast.fireToast("Search Finish Event was fired");
        });*/

    }

    @UiHandler("btnSearch")
    void onSearch(ClickEvent e) {
        txtSearch.open();
    }

    @Override
    public void setContents() {

    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        // TODO Auto-generated method stub
    }
}
