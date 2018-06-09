/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author dftsf
 */
@RemoteServiceRelativePath("tasksService")
public interface TasksService extends RemoteService {

    Iterable<TaskDTO> get_all_tasks();

    TaskDTO get_task_by_title(String title);

    Iterable<TaskDTO> get_task_by_priority(int priority);

    Iterable<TaskDTO> get_task_by_percentage(int percentage);

    TaskDTO addTask(TaskDTO task) throws DataException;
}
