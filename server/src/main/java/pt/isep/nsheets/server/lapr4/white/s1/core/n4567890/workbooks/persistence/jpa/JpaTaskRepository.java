/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1150585.tasks.domain.Task;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.TaskRepository;
import pt.isep.nsheets.shared.services.TaskDTO;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public class JpaTaskRepository extends NSheetsJpaRepositoryBase<Task, Long> implements TaskRepository {

    JpaTaskRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public Task get_task_by_title(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Task> get_task_by_priority(int priority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Task> get_task_by_percentage(int percentage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTask(TaskDTO task) {
        final Query q = entityManager().createQuery("DELETE FROM Task c WHERE c.title=:t", this.entityClass);
        q.setParameter("t", task.getTitle());
        entityManager().getTransaction().begin();
        q.executeUpdate();
        entityManager().getTransaction().commit();
    }

}
