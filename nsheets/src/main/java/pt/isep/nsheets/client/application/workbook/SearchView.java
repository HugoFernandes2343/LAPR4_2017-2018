package pt.isep.nsheets.client.application.workbook;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.*;

public class SearchView extends ViewImpl {

    @UiField
    public static MaterialWindow searchWindow;

    @UiField
    MaterialNavBar navBar, navBarSearch;

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialCard card;

    @UiField
    MaterialSearch txtSearch;

    ////  MaterialLabel lblAddress, lblContent;



    private static pt.isep.nsheets.client.application.workbook.SearchView.SearchViewUiBinder uiBinder = GWT.create(pt.isep.nsheets.client.application.workbook.SearchView.SearchViewUiBinder.class);

    interface SearchViewUiBinder extends UiBinder<Widget, pt.isep.nsheets.client.application.workbook.SearchView> {

    }

    public SearchView() {
        initWidget(uiBinder.createAndBindUi(this));
        searchWindow.open();

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


}

