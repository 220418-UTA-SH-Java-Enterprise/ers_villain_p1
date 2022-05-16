package com.revature.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Utility to connect to the Hibernate API and set configuraiton
 */
public class HibernateUtil {
    public HibernateUtil() {
        super();
    }

    private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private static Logger loggger = Logger.getLogger(HibernateUtil.class);

    private static Session session;

    /**
     * Returns the Hibernate Session
     * 
     * @return session
     */
    public static Session getSession() {
        loggger.info("starting hibernate connection session...");
        if (session == null) {
            session = sf.openSession();
        }
        return session;
    }
}
