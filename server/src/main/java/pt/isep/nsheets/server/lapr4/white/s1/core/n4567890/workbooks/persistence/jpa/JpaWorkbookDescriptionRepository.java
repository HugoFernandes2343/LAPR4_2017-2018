package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;

public class JpaWorkbookDescriptionRepository extends NSheetsJpaRepositoryBase<WorkbookDescription, Long> implements WorkbookDescriptionRepository {

    JpaWorkbookDescriptionRepository(PersistenceSettings settings) {
        super(settings);
    }

    public void delete(WorkbookDescription entity) {

        final EntityTransaction tx = entityManager().getTransaction();

        tx.begin();
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        entity = entityManager().merge(entity);
        entityManager().remove(entity);
        tx.commit();
    }

    @Override
    public WorkbookDescription findWorkbookDescriptionByName(String name) {
        final Query q;
        q = entityManager().createQuery("SELECT wb FROM WorkbookDescription wb "
                + "WHERE wb.name = :name");
        q.setParameter("name", name);
        return (WorkbookDescription) q.getSingleResult();
    }

}
