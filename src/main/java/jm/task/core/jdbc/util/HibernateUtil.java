package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements AutoCloseable {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final Session session = getSession();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        if (session == null || !session.isOpen()) {
            try {
                return sessionFactory.openSession();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void close() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}