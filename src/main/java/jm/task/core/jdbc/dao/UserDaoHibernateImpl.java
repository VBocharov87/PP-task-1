package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private static final String CREATE_SPREADSHEET_QUERY = "CREATE TABLE IF NOT EXISTS spreadsheet (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(25), lastname VARCHAR(25), age INT)";
    private static final String DROP_SPREADSHEET_QUERY = "DROP TABLE IF EXISTS spreadsheet";

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.createSQLQuery(CREATE_SPREADSHEET_QUERY).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.createSQLQuery(DROP_SPREADSHEET_QUERY).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            users = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
