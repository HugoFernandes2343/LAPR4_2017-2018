/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence;

import eapli.framework.persistence.repositories.Repository;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1150585.tasks.domain.Task;
import pt.isep.nsheets.shared.services.TaskDTO;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public interface TaskRepository extends Repository<Task, Long> {

    public Task get_task_by_title(String title);

    public Iterable <Task> get_task_by_priority(int priority);

    public Iterable <Task> get_task_by_percentage(int percentage);
    
    public void deleteTask (TaskDTO task);

    public void editTask (TaskDTO task,String oldName);
}
