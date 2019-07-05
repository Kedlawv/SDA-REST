package pl.sdacademy.database.hibernate.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdacademy.database.hibernate.dao.NfcChipDao;
import pl.sdacademy.database.hibernate.entity.NfcChip;
import pl.sdacademy.database.hibernate.utils.HibernateUtils;

import java.util.List;

public class NfcChipDaoImpl implements NfcChipDao {
    public void save(NfcChip chip) {
        SessionFactory factory = HibernateUtils
                .getInstance()
                .getSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.saveOrUpdate(chip);
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
                .createQuery("delete NfcChip where id=:id")
                .setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();

        session.close();
    }

    public NfcChip getById(Long id) {
        return null;
    }

    public List<NfcChip> getAll() {
        return null;
    }
}
