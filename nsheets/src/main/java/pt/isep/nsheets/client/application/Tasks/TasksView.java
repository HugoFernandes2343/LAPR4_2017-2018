/**
 * Date Created: 7/jun/2018
 *
 */
package pt.isep.nsheets.client.application.Tasks;

import com.google.gwt.event.dom.client.ClickHandler;
import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
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
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialSearch;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.TaskDTO;

/**
 *
 * @author dftsf
 */
public class TasksView extends ViewImpl implements TasksPresenter.MyView {


    interface Binder extends UiBinder<Widget, TasksView> {
    }

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialSearch txtSearch;

    @UiField
    MaterialNavBar navBar, navBarSearch;

    @UiField
    MaterialButton newTaskButton;

    @UiField
    MaterialLink renameLink, deleteLink;

    @UiField
    MaterialCardTitle taskTitle;

    @UiField
    MaterialLabel taskDescription;

    @UiField
    MaterialCard card;

    @Inject
    TasksView(Binder uiBinder) {
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

    private MaterialCard createCard(TaskDTO task) {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_1);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialCardTitle cardTitle = new MaterialCardTitle();
        cardTitle.setText(task.getTitle());
        cardTitle.setIconType(IconType.INSERT_DRIVE_FILE);
        cardTitle.setIconPosition(IconPosition.RIGHT);

        MaterialLabel label = new MaterialLabel();
        label.setText(task.getDescription());

        MaterialCardAction cardAction = new MaterialCardAction();

        MaterialLink renameLink = new MaterialLink();
        renameLink.setText("Rename");
        renameLink.setIconType(IconType.EDIT);
        renameLink.setIconColor(Color.INDIGO);
        renameLink.setTextColor(Color.WHITE);
        renameLink.addClickHandler(event -> {
            MaterialToast.fireToast("rename " + task.getTitle());
        });

        MaterialLink deleteLink = new MaterialLink();
        deleteLink.setText("Delete");
        deleteLink.setIconType(IconType.DELETE);
        deleteLink.setIconColor(Color.GREY);
        deleteLink.setTextColor(Color.WHITE);
        deleteLink.addClickHandler(event -> {
            MaterialToast.fireToast("delete " + task.getTitle());
        });

        cardContent.add(cardTitle);
        cardContent.add(label);

        cardAction.add(renameLink);
        cardAction.add(deleteLink);

        card.add(cardContent);
        card.add(cardAction);

        return card;
    }

    @Override
    public void setContents(ArrayList<TaskDTO> contents) {
        int colCount = 1;

        MaterialRow row = null;

        htmlPanel.clear();

        for (TaskDTO task : contents) {
            MaterialCard card = createCard(task);

//            workbookTitle.setText(wb.getName());
//            workbookDescription.setText(wb.getDescription());
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
      newTaskButton.addClickHandler(ch);
    }

}
