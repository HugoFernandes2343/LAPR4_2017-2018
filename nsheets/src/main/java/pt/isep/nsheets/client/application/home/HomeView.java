package pt.isep.nsheets.client.application.home;

import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardAction;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSearch;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

class HomeView extends ViewImpl implements HomePresenter.MyView {

    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialSearch txtSearch;

    @UiField
    MaterialNavBar navBar, navBarSearch;

    @UiField
    MaterialButton newWorkbookButton;
    
    @UiField
    MaterialLink renameLink, deleteLink;
    
    @UiField
    MaterialCardTitle workbookTitle;
    
    @UiField
    MaterialLabel workbookDescription;
    
    @UiField
    MaterialCard card;            

    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

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
    }
    
    @Override
    public void setContents(ArrayList<Workbook> contents) {
        int colCount = 1;

        MaterialRow row = null;

        htmlPanel.clear();

        for (Workbook wb : contents) {
//            MaterialCard card = createCard(wb);
            
            workbookTitle.setText(wb.getName());
            workbookDescription.setText(wb.getDescription());

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

        newWorkbookButton.addClickHandler(ch);
    }
    
    @Override
    public void renameClickHandler(ClickHandler ch) {
        renameLink.addClickHandler(ch);
    }
    
    @Override
    public void deleteClickHandler(ClickHandler ch) {
        deleteLink.addClickHandler(ch);
    }

    @UiHandler("btnSearch")
    void onSearch(ClickEvent e) {
        txtSearch.open();
    }

    @Override
    public MaterialCardTitle getWorkbookTitle() {
        return workbookTitle;
    }

    @Override
    public MaterialLabel getWorkbookDescription() {
        return workbookDescription;
    }   
}
