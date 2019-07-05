package pl.sdacademy.database.hibernate.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdacademy.database.hibernate.dao.MemberDao;
import pl.sdacademy.database.hibernate.entity.Member;
import pl.sdacademy.database.hibernate.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;


public class MemberDaoImpl implements MemberDao {

    public void save(Member member) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.saveOrUpdate(member);
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

    public Member getById(Long id) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        try {
            Member member = (Member) session
                    .createQuery("from Member where id=:id")
                    .setParameter("id", id)
                    .getSingleResult();
            return member;
        } catch (NoResultException ex) {
            return null;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public List<Member> getAll() {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        List<Member> members = session
                .createQuery("from Member")
                .list();
        session.getTransaction().commit();
        session.close();
        return members;


    }
}
