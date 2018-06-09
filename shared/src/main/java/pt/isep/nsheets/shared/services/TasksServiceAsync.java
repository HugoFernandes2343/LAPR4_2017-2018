/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 *
 * @author dftsf
 */
public interface TasksServiceAsync {

    void get_all_tasks(AsyncCallback<ArrayList<TaskDTO>> callback);

    void get_task_by_title(String title, AsyncCallback<TaskDTO> callback);

    void get_task_by_priority(int priority, AsyncCallback<TaskDTO> callback);

    void get_task_by_percentage(int percentage, AsyncCallback<TaskDTO> callback);
    
    void addTask(TaskDTO task, AsyncCallback<TaskDTO> async);
}
