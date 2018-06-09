/**
 * Date Created: 7/jun/2018
 *
 */
package pt.isep.nsheets.client.application.Tasks;

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
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.TaskDTO;
import pt.isep.nsheets.shared.services.TasksService;
import pt.isep.nsheets.shared.services.TasksServiceAsync;

/**
 *
 * @author dftsf
 */
public class TasksPresenter extends Presenter<TasksPresenter.MyView, TasksPresenter.MyProxy> {
    
    private int nTask;
        
    private MyView view;

    interface MyView extends View {

        void setContents(ArrayList<TaskDTO> contents);

        void addClickHandler(ClickHandler ch);

    }

    @NameToken(NameTokens.tasks)
    @ProxyStandard
    @NoGatekeeper

    interface MyProxy extends ProxyPlace<TasksPresenter> {
    }

    @Inject
    TasksPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.addClickHandler((ClickEvent event) -> {

            TasksServiceAsync tasksServiceAsync = GWT.create(TasksService.class);

            AsyncCallback<TaskDTO> callback = new AsyncCallback<TaskDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error creating Task ");
                }

                @Override
                public void onSuccess(TaskDTO result) {
                    MaterialToast.fireToast("Task created");
                    refreshView();
                }
            };
            TaskDTO newTask = new TaskDTO("New Task "+nTask, "Insert a Description", 1, 0);
            tasksServiceAsync.addTask(newTask, callback);
            nTask++;
        });
    }

    public void refreshView() {
        TasksServiceAsync tasksServiceAsync = GWT.create(TasksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<TaskDTO>> callback = new AsyncCallback<ArrayList<TaskDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<TaskDTO> result) {
                nTask = result.size();
                view.setContents(result);
            }
        };

        tasksServiceAsync.get_all_tasks(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Tasks", "Create, edit and delete your tasks here", "", "", this);
        refreshView();
    }

}
