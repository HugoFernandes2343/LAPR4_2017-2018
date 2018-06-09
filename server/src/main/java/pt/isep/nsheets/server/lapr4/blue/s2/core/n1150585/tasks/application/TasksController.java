/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s2.core.n1150585.tasks.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1150585.tasks.domain.Task;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.TaskRepository;
import pt.isep.nsheets.shared.services.TaskDTO;
import pt.isep.nsheets.shared.services.TasksService;

/**
 *
 * @author Daniel Fernandes
 */
public class TasksController implements Controller {

    public Iterable<Task> get_all_tasks() {
        TaskRepository taskRepository = PersistenceContext.repositories().task();
        return taskRepository.findAll();
    }

    public Task get_task_by_title(String title) {
        TaskRepository taskRepository = PersistenceContext.repositories().task();
        return taskRepository.get_task_by_title(title);
    }

    public Iterable<Task> get_task_by_priority(int priority) {
        TaskRepository taskRepository = PersistenceContext.repositories().task();
        return taskRepository.get_task_by_priority(priority);
    }

    public Iterable<Task> get_task_by_percentage(int percentage) {
        TaskRepository taskRepository = PersistenceContext.repositories().task();
        return taskRepository.get_task_by_percentage(percentage);
    }

    public TaskDTO addTask(TaskDTO taskDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        TaskRepository taskRepository = PersistenceContext.repositories().task();
        
        taskRepository.save(Task.fromDTO(taskDTO));
        return taskDTO;
        
      
    }
}
