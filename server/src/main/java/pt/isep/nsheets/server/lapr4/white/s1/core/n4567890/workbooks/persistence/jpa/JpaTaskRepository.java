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
 * @author dftsf
 */
public class JpaTaskRepository extends NSheetsJpaRepositoryBase<Task, Long> implements TaskRepository {

    JpaTaskRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public void deleteTask(TaskDTO task) {
        final Query q = entityManager().createQuery("DELETE FROM Task c WHERE c.title=:t", this.entityClass);
        q.setParameter("t", task.getTitle());
        entityManager().getTransaction().begin();
        q.executeUpdate();
        entityManager().getTransaction().commit();
    }

    @Override
    public void editTask(TaskDTO task, String oldName) {
        Query q = entityManager().createQuery(
                "UPDATE Task t "
                + "SET t.title=:newTitle, t.description=:newDescription , t.priority=:newPriority , t.percentage=:newPercentage "
                + "WHERE t.title =:oldName");

        q.setParameter("newTitle", task.getTitle());
        q.setParameter("newDescription", task.getDescription());
        q.setParameter("newPriority", task.getPriority());
        q.setParameter("newPercentage", task.getPercentage());
        q.setParameter("oldName", oldName);

        entityManager().getTransaction().begin();
        q.executeUpdate();
        entityManager().getTransaction().commit();
    }

    @Override
    public void updatePercentage(String title) {
        Query q = entityManager().createQuery(
                "UPDATE Task t "
                + "SET t.percentage=:newPercentage "
                + "WHERE t.title =:oldName");

        q.setParameter("oldName", title);
        q.setParameter("newPercentage", 100);

        entityManager().getTransaction().begin();
        q.executeUpdate();
        entityManager().getTransaction().commit();
    }

}
