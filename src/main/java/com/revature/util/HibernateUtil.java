package com.revature.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Utility to connect to the Hibernate API and set configuraiton
 */
public class HibernateUtil {
    /**
     * Configuration file version (lcaol DB only)
     */
    private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    /**
     * Attemting to use env variables for AWS
     */
    // private static SessionFactory sf = new Configuration()
    /*
     * Connection Properties
     */
    // .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")

    /**
     * AWS
     */
    // .setProperty("hibernate.connection.username",
    // System.getenv("villain_DB_USER"))
    // .setProperty("hibernate.connection.url", System.getenv("villain_DB_URL"))
    // .setProperty("hibernate.connection.password",
    // System.getenv("villain_DB_PASS"))

    /**
     * Localhost
     */
    // .setProperty("hibernate.connection.url",
    // "jdbc:postgresql://localhost:5432/JuCaLe")
    // .setProperty("hibernate.connection.username", "dev")
    // .setProperty("hibernate.connection.password", "password")

    /**
     * Other stuff
     */
    // .setProperty("hibernate.dialect",
    // "org.hibernate.dialect.PostgreSQLDialect")
    // .setProperty("show_sql", "true")

    /**
     * POOLING
     */
    // .setProperty("hibernate.connection.pool_size", "10")

    /**
     * create, update, validate...
     */
    // .setProperty("hibernate.hbm2ddl.auto", "create")

    /**
     * annotated entity classes
     */
    // .addAnnotatedClass(User.class).addAnnotatedClass(UserRole.class).addAnnotatedClass(Reimb.class)
    // .addAnnotatedClass(ReimbStatus.class).addAnnotatedClass(ReimbType.class).buildSessionFactory();

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
