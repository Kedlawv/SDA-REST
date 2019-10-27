package pl.sdacademy.database.hibernate.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdacademy.database.hibernate.dao.MemberDao;
import pl.sdacademy.database.hibernate.entity.RunMember;
import pl.sdacademy.database.hibernate.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;


public class MemberDaoImpl implements MemberDao {

    public void save(RunMember runMember) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.saveOrUpdate(runMember);
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
                .createQuery("delete Member where id=:id")
                .setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();

        session.close();
    }

    public RunMember getById(Long id) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        try {
            RunMember runMember = (RunMember) session
                    .createQuery("from Member where id=:id")
                    .setParameter("id", id)
                    .getSingleResult();
            return runMember;
        } catch (NoResultException ex) {
            return null;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public List<RunMember> getAll() {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        List<RunMember> runMembers = session
                .createQuery("from Member")
                .list();
        session.getTransaction().commit();
        session.close();
        return runMembers;


    }
}
