package pt.isep.nsheets.client.application.Requests;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import commonj.sdo.helper.DataHelper;
import gwt.material.design.client.base.SearchObject;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


class RequestsView extends ViewImpl implements RequestsPresenter.MyView {


    interface Binder extends UiBinder<Widget, RequestsView> {
    }

    @UiField
    HTMLPanel htmlPanel;

    @Inject
    RequestsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

      /*   // add open handler
        txtSearch.addOpenHandler(openEvent -> {
            navBar.setVisible(false);
            navBarSearch.setVisible(true);
        });

        // Add Close Handler
        txtSearch.addCloseHandler(event -> {
            navBar.setVisible(true);
            navBarSearch.setVisible(false);
        });

       // Populate the search keyword into search component
        List<SearchObject> objects = new ArrayList<>();

        User u1 = new User(1 + "@isep.ipp.pt","teste","nick1","aluno1");
        User u2 = new User(2 + "@isep.ipp.pt","teste","nick2","aluno2");
        User u3 = new User(3 + "@isep.ipp.pt","teste","nick3","aluno3");
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        //for para teste
        for (User u : list){
            objects.add(u);
        }
        txtSearch.setListSearches(objects);

        // Add Finish Handler
        txtSearch.addSearchFinishHandler(event -> {
            // Get the selected search object
            User u = (User)txtSearch.getSelectedObject();
            lblName.setText(u.getNickname());
            lblEmail.setText(u.getEmail());
            MaterialToast.fireToast("Search Finish Event was fired");
        });*/

    }

    private MaterialCard createCard() {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_1);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialCardTitle cardTitle = new MaterialCardTitle();
        cardTitle.setText("Request");

        MaterialLabel label = new MaterialLabel();
        label.setText("Place name and email here");

        MaterialCardAction cardAction = new MaterialCardAction();

        MaterialLink acceptLink = new MaterialLink();
        acceptLink.setText("Accept");
        acceptLink.setIconType(IconType.CHECK);
        acceptLink.setIconColor(Color.GREEN_ACCENT_3);
        acceptLink.setTextColor(Color.WHITE);

        MaterialLink deleteLink = new MaterialLink();
        deleteLink.setText("Decline");
        deleteLink.setIconType(IconType.CLEAR);
        deleteLink.setIconColor(Color.RED_ACCENT_3);
        deleteLink.setTextColor(Color.WHITE);

        cardContent.add(cardTitle);
        cardContent.add(label);

        cardAction.add(acceptLink);
        cardAction.add(deleteLink);

        card.add(cardContent);
        card.add(cardAction);

        return card;
    }

    @Override
    public void setContents() {
        int colCount = 1;

        MaterialRow row = null;

        htmlPanel.clear();

        for (int i =0; i<1; i++) {
            MaterialCard card = createCard();

            if (colCount == 1) {
                row = new MaterialRow();
                htmlPanel.add(row);
                ++colCount;
                if (colCount >= 4) {
                    colCount = 1;
                }
            }

            MaterialColumn col = new MaterialColumn();
            col.setGrid("l4");
            row.add(col);

            col.add(card);
        }

    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        // TODO Auto-generated method stub
    }


}
