package com.revature.util;

import java.util.Properties;

import com.revature.models.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/**
 * Utility to connect to the Hibernate API and set configuraiton
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public HibernateUtil() {
        super();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, System.getenv("villain_DB_URL"));
                settings.put(Environment.USER, System.getenv("villain_DB_USER"));
                settings.put(Environment.PASS, System.getenv("villain_DB_PASS"));
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                // settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Reimb.class);

                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private static Logger log = Logger.getLogger(HibernateUtil.class);

    private static Session ses; // save(), get(), load(), delete()

    /**
     * Returns the Hibernate Session
     * 
     * @return session
     */
    public static Session getSession() {
        log.info("starting hibernate connection session...");
        if (ses == null) {
            ses = sf.openSession();
        }
        return ses;
    }
}
