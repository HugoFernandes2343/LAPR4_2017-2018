/**
 * Date Created: 7/jun/2018
 *
 */
package pt.isep.nsheets.client.application.Tasks;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialSearch;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.TaskDTO;
import pt.isep.nsheets.shared.services.TasksService;
import pt.isep.nsheets.shared.services.TasksServiceAsync;

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
    MaterialButton newTaskButton;

    @UiField
    MaterialLink editTask, deleteTask;

    @Inject
    TasksView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

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

        MaterialLabel labelDescritpion = new MaterialLabel();
        labelDescritpion.setText(task.getDescription());

        MaterialLabel labelPriority = new MaterialLabel();
        labelPriority.setText("Priority: " + task.getPriority());

        MaterialLabel labelPercentage = new MaterialLabel();
        labelPercentage.setText("Percentage of completion: " + task.getPercentage() + "%");

        MaterialCardAction cardAction = new MaterialCardAction();

        MaterialLink editLink = new MaterialLink();
        editLink.setText("Edit");
        editLink.setIconType(IconType.EDIT);
        editLink.setIconColor(Color.INDIGO);
        editLink.setTextColor(Color.WHITE);
        editLink.addClickHandler(event -> {
            MaterialWindow window = new MaterialWindow("Task Editor");
            MaterialButton saveEditorButton = new MaterialButton("DONE");
            MaterialTextBox titleEditor = new MaterialTextBox();
            MaterialTextBox descEditor = new MaterialTextBox();
            MaterialTextBox perceEditor = new MaterialTextBox();
            MaterialTextBox priorityEditor = new MaterialTextBox();
            String oldName = task.getTitle();
            titleEditor.setText(task.getTitle());
            descEditor.setText(task.getDescription());
            perceEditor.setText(Integer.toString(task.getPercentage()));
            priorityEditor.setText(Integer.toString(task.getPriority()));

            window.add(saveEditorButton);
            window.add(titleEditor);
            window.add(descEditor);
            window.add(perceEditor);
            window.add(priorityEditor);
            window.open();
            saveEditorButton.addClickHandler(event2 -> {
                TasksServiceAsync tasksServiceAsync = GWT.create(TasksService.class);

                AsyncCallback<TaskDTO> callback = new AsyncCallback<TaskDTO>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error Saving Task ");
                    }

                    @Override
                    public void onSuccess(TaskDTO result) {
                        MaterialToast.fireToast("Task Edited");

                    }
                };

                TaskDTO editedTask = new TaskDTO(titleEditor.getValue(), descEditor.getValue(), Integer.parseInt(perceEditor.getValue()), Integer.parseInt(priorityEditor.getValue()));
                tasksServiceAsync.editTask(editedTask, oldName, callback);
                
                cardTitle.setText(editedTask.getTitle());
                labelDescritpion.setText(editedTask.getDescription());
                labelPriority.setText("Priority:" + editedTask.getPriority());
                labelPercentage.setText("Percentage of completion: " + editedTask.getPercentage() + "%");
            });
        });
        MaterialLink deleteLink = new MaterialLink();
        deleteLink.setText("Delete");
        deleteLink.setIconType(IconType.DELETE);
        deleteLink.setIconColor(Color.GREY);
        deleteLink.setTextColor(Color.WHITE);
        deleteLink.addClickHandler(event -> {

            TasksServiceAsync tasksServiceAsync = GWT.create(TasksService.class);

            AsyncCallback<TaskDTO> callback = new AsyncCallback<TaskDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error deleting Task ");
                }

                @Override
                public void onSuccess(TaskDTO result) {
                    MaterialToast.fireToast(task.getTitle() + " deleted");
                    card.setVisible(false);
                }
            };

            tasksServiceAsync.deleteTask(task, callback);
        });

        cardContent.add(cardTitle);
        cardContent.add(labelDescritpion);
        cardContent.add(labelPriority);
        cardContent.add(labelPercentage);

        cardAction.add(editLink);
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
