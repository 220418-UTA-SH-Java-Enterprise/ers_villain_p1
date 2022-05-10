package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionUtil {
    private static Logger logger = LogManager.getLogger(ConnectionUtil.class);

    public static Connection getConnection() {
        Connection conn = null;

        try {
            logger.debug(String.format("",
                    System.getenv("db_url"),
                    System.getenv("db_username"),
                    System.getenv("db_password")));

            conn = DriverManager.getConnection(
                    System.getenv("db_url"),
                    System.getenv("db_username"),
                    System.getenv("db_password"));
            logger.debug("Connection has successfully been established.");
        } catch (SQLException e) {
            logger.warn("Unable to connect to the DB.");
        }
        return conn;
    }
}
