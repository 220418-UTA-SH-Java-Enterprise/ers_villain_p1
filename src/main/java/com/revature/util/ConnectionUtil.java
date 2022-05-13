package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * DB Connection Utility
 */
public class ConnectionUtil {
    private static Logger logger = LogManager.getLogger(ConnectionUtil.class);

    private ConnectionUtil() {
    }

    /**
     * 
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            logger.debug(String.format("",
                    System.getenv("villain_DB_URL"),
                    System.getenv("villain_DB_USER"),
                    System.getenv("villain_DB_PASS")));

            conn = DriverManager.getConnection(
                    System.getenv("villain_DB_URL"),
                    System.getenv("villain_DB_USER"),
                    System.getenv("villain_DB_PASS"));
            logger.debug("Connection has successfully been established.");
        } catch (SQLException e) {
            logger.warn("Unable to connect to the DB.");
        }
        return conn;
    }
}
