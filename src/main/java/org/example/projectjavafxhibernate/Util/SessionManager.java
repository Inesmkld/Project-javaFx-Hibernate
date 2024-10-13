package org.example.projectjavafxhibernate.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SessionManager {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static ThreadLocal<Session> threadLocalSession = new ThreadLocal<>();

    public static Session getSession() {
        Session session = threadLocalSession.get();
        if (session == null) {
            session = sessionFactory.openSession();
            threadLocalSession.set(session);
        }
        return session;
    }

    public static void closeSession() {
        Session session = threadLocalSession.get();
        if (session != null) {
            session.close();
            threadLocalSession.remove();
        }
    }

    public static void executeTransaction(TransactionAction action) {
        Transaction transaction = null;
        try {
            Session session = getSession();
            transaction = session.beginTransaction();
            action.execute(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            closeSession();
        }
    }

    public interface TransactionAction {
        void execute(Session session);
    }
}
