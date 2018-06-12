package pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.persistenc.CalendarRepository;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1161248.calendar.domain.Calendar;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.NSheetsJpaRepositoryBase;
import pt.isep.nsheets.shared.services.CalendarDTO;

import javax.persistence.Query;


public class JPACalendarRepository extends NSheetsJpaRepositoryBase<Calendar, Long> implements CalendarRepository {

    public JPACalendarRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public void deleteCalendar(String calendar) {
        final Query q = entityManager().createQuery("DELETE FROM Calendar c WHERE c.name=:t", this.entityClass);
        q.setParameter("t", calendar);
        entityManager().getTransaction().begin();
        q.executeUpdate();
        entityManager().getTransaction().commit();
    }

    @Override
    public Calendar findCalendarByName(String name) {
        final Query q;
        q = entityManager().createQuery("SELECT c FROM Calendar c "
                + "WHERE c.name = :name");
        q.setParameter("name", name);
        return (Calendar) q.getSingleResult();
    }

}
