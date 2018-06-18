/**
 * Date Created: 7/jun/2018
 *
 */
package pt.isep.nsheets.client.lapr4.blue.s2.s1150585.Tasks;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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
import gwt.material.design.client.ui.MaterialListBox;
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
 * @author Daniel Fernandes 1150585
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

    @UiField
    MaterialListBox listBox;

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
        cardTitle.setIconType(IconType.DONE);
        cardTitle.setIconPosition(IconPosition.RIGHT);

        MaterialLabel labelDescritpion = new MaterialLabel();
        labelDescritpion.setText(task.getDescription());

        MaterialLabel labelPriority = new MaterialLabel();
        labelPriority.setText("Priority: " + task.getPriority());

        MaterialLabel labelPercentage = new MaterialLabel();
        labelPercentage.setText("Percentage of completion: " + task.getPercentage() + "%");

        MaterialCardAction cardAction = new MaterialCardAction();

        cardTitle.addClickHandler(event -> {

            TasksServiceAsync tasksServiceAsync = GWT.create(TasksService.class);

            AsyncCallback<TaskDTO> callback = new AsyncCallback<TaskDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error ");
                }

                @Override
                public void onSuccess(TaskDTO result) {
                    MaterialToast.fireToast("Task Completed");

                }
            };

            tasksServiceAsync.updatePercentage(task.getTitle(), callback);
            labelPercentage.setText("Percentage of completion: 100 %");

        });

        MaterialLink editLink = new MaterialLink();
        editLink.setText("Edit");
        editLink.setIconType(IconType.EDIT);
        editLink.setIconColor(Color.INDIGO);
        editLink.setTextColor(Color.WHITE);
        editLink.addClickHandler(event -> {
            MaterialWindow window = new MaterialWindow("Task Editor");
            MaterialLabel lblTitle = new MaterialLabel("Title");
            MaterialLabel lblDescription = new MaterialLabel("Description");
            MaterialLabel lblPerce = new MaterialLabel("Percentage of Completion");
            MaterialLabel lblPriority = new MaterialLabel("Priority");
            MaterialButton saveEditorButton = new MaterialButton("DONE");
            MaterialTextBox titleEditor = new MaterialTextBox();
            MaterialTextBox descEditor = new MaterialTextBox();
            MaterialTextBox perceEditor = new MaterialTextBox();
            String oldName = task.getTitle();
            titleEditor.setText(task.getTitle());
            descEditor.setText(task.getDescription());
            perceEditor.setText(Integer.toString(task.getPercentage()));

            MaterialListBox listPriority = new MaterialListBox();
            listPriority.add("1");
            listPriority.add("2");
            listPriority.add("3");
            listPriority.add("4");
            listPriority.add("5");

            lblTitle.setPaddingLeft(100);
            lblTitle.setPaddingRight(100);
            lblTitle.setPaddingTop(50);
            titleEditor.setPaddingLeft(100);
            titleEditor.setPaddingRight(100);
            lblTitle.add(titleEditor);

            lblDescription.setPaddingLeft(100);
            lblDescription.setPaddingRight(100);
            lblDescription.setPaddingTop(50);
            descEditor.setPaddingLeft(100);
            descEditor.setPaddingRight(100);
            lblDescription.add(descEditor);

            lblPriority.setPaddingLeft(100);
            lblPriority.setPaddingRight(100);
            lblPriority.setPaddingTop(50);
            listPriority.setPaddingLeft(100);
            listPriority.setPaddingRight(100);
            lblPriority.add(listPriority);

            lblPerce.setPaddingLeft(100);
            lblPerce.setPaddingRight(100);
            lblPerce.setPaddingTop(50);
            perceEditor.setPaddingLeft(100);
            perceEditor.setPaddingRight(100);
            lblPerce.add(perceEditor);

            saveEditorButton.setFloat(Style.Float.RIGHT);
            saveEditorButton.setMarginRight(150);
            saveEditorButton.setMarginBottom(50);
            saveEditorButton.setMarginTop(20);

            window.add(lblTitle);
            window.add(titleEditor);
            window.add(lblDescription);
            window.add(descEditor);
            window.add(lblPriority);
            window.add(listPriority);
            window.add(lblPerce);
            window.add(perceEditor);
            window.add(saveEditorButton);
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

                TaskDTO editedTask = new TaskDTO(titleEditor.getValue(), descEditor.getValue(), Integer.parseInt(listPriority.getValue()), Integer.parseInt(perceEditor.getValue()));
                tasksServiceAsync.editTask(editedTask, oldName, callback);

                cardTitle.setText(editedTask.getTitle());
                labelDescritpion.setText(editedTask.getDescription());
                labelPriority.setText("Priority:" + editedTask.getPriority());
                labelPercentage.setText("Percentage of completion: " + editedTask.getPercentage() + "%");
                window.close();
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
    public void clearView() {
        htmlPanel.clear();
    }

    @Override
    public void addEventChangeHandler(ValueChangeHandler<String> vc) {
        listBox.addValueChangeHandler(vc);
    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        newTaskButton.addClickHandler(ch);
    }
}
