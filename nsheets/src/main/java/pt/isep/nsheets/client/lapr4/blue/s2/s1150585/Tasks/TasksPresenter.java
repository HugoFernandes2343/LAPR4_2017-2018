/**
 * Date Created: 7/jun/2018
 *
 */
package pt.isep.nsheets.client.lapr4.blue.s2.s1150585.Tasks;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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
import java.util.List;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.TaskDTO;
import pt.isep.nsheets.shared.services.TasksService;
import pt.isep.nsheets.shared.services.TasksServiceAsync;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public class TasksPresenter extends Presenter<TasksPresenter.MyView, TasksPresenter.MyProxy> {

    private int nTask;
    ArrayList<TaskDTO> allTasks;

    private MyView view;

    interface MyView extends View {

        void setContents(ArrayList<TaskDTO> contents);

        void clearView();

        void addClickHandler(ClickHandler ch);

        void addEventChangeHandler(ValueChangeHandler<String> vc);

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

        this.view.addEventChangeHandler((ValueChangeEvent<String> event) -> {
            refresh();
            if (event.getValue().equalsIgnoreCase("Show Only Complete Tasks")) {
                
                ArrayList<TaskDTO> completedTasks = new ArrayList<>();

                for (TaskDTO t : allTasks) {
                    if (t.getPercentage() == 100) {
                        completedTasks.add(t);
                    }
                }
                view.setContents(completedTasks);

            } else if (event.getValue().equalsIgnoreCase("Show Only Incomplete Tasks")) {
               refresh();
                ArrayList<TaskDTO> incompletedTasks = new ArrayList<>();

                for (TaskDTO t : allTasks) {
                    if (t.getPercentage() != 100) {
                        incompletedTasks.add(t);
                    }
                }
                view.setContents(incompletedTasks);

            } else if (event.getValue().equalsIgnoreCase("Show Only Tasks with priority 1")) {
                refresh();
                ArrayList<TaskDTO> priority1 = new ArrayList<>();

                for (TaskDTO t : allTasks) {
                    if (t.getPriority() == 1) {
                        priority1.add(t);
                    }
                }
                view.setContents(priority1);
            } else if (event.getValue().equalsIgnoreCase("Show Only Tasks with priority 2")) {
                refresh();
                ArrayList<TaskDTO> priority2 = new ArrayList<>();

                for (TaskDTO t : allTasks) {
                    if (t.getPriority() == 2) {
                        priority2.add(t);
                    }
                }
                view.setContents(priority2);

            } else if (event.getValue().equalsIgnoreCase("Show Only Tasks with priority 3")) {
                refresh();
                ArrayList<TaskDTO> priority3 = new ArrayList<>();

                for (TaskDTO t : allTasks) {
                    if (t.getPriority() == 3) {
                        priority3.add(t);
                    }
                }
                view.setContents(priority3);
            } else if (event.getValue().equalsIgnoreCase("Show Only Tasks with priority 4")) {
                refresh();
                ArrayList<TaskDTO> priority4 = new ArrayList<>();

                for (TaskDTO t : allTasks) {
                    if (t.getPriority() == 4) {
                        priority4.add(t);
                    }
                }
                view.setContents(priority4);
            } else if (event.getValue().equalsIgnoreCase("Show Only Tasks with priority 5")) {
                refresh();
                ArrayList<TaskDTO> priority5 = new ArrayList<>();

                for (TaskDTO t : allTasks) {
                    if (t.getPriority() == 5) {
                        priority5.add(t);
                    }
                }
                view.setContents(priority5);
            } else {
                refreshView();
            }

        });

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
            TaskDTO newTask = new TaskDTO("New Task " + nTask++, "Insert a Description", 1, 0);
            tasksServiceAsync.addTask(newTask, callback);

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
                allTasks = result;
                nTask = result.size();
                view.setContents(result);
            }
        };

        tasksServiceAsync.get_all_tasks(callback);
    }

    public void refresh() {
        TasksServiceAsync tasksServiceAsync = GWT.create(TasksService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<TaskDTO>> callback = new AsyncCallback<ArrayList<TaskDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
              MaterialToast.fireToast("Error " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<TaskDTO> result) {
                allTasks = result;
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
