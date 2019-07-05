package pl.sdacademy.database.hibernate.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdacademy.database.hibernate.dao.RunDao;
import pl.sdacademy.database.hibernate.entity.Run;
import pl.sdacademy.database.hibernate.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;


public class RunDaoImpl implements RunDao {

    public void save(Run run) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.saveOrUpdate(run);
        session.getTransaction().commit();

        session.close();
    }

    public void delete(Long id) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session
                .createQuery("delete Run where id=:id")
                .setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();

        session.close();
    }

    public Run getById(Long id) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        try {
            Run run = (Run) session
                    .createQuery("from Run where id=:id")
                    .setParameter("id", id)
                    .getSingleResult();
            return run;
        } catch (NoResultException ex) {
            return null;
        } finally {
            session.getTransaction().commit();

            session.close();
        }
    }


    public List<Run> getAll() {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        List<Run> runs = session
                .createQuery("from Run")
                .list();
        session.getTransaction().commit();
        session.close();
        return runs;
    }

    public List<Run> getAll(int seek, int count) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        List<Run> runs = session
                .createQuery("from Run")
                .setMaxResults(count)
                .setFirstResult(seek)
                .list();
        session.getTransaction().commit();
        session.close();
        return runs;
    }

    @Override
    public List<Run> findByDate(Date dateFrom, Date dateTo, int seek, int count) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        List<Run> runs = session
                .createQuery("from Run where startDate > :dateFrom and startDate < :dateTo")
                .setParameter("dateFrom", dateFrom)
                .setParameter("dateTo", dateTo)
                .setMaxResults(count)
                .setFirstResult(seek)
                .list();
        session.getTransaction().commit();
        session.close();
        return runs;
    }
}
