package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.UserRole;
import com.revature.util.ConnectionUtil;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UserRoleDAOImpl implements UserRoleDAO {

    private static Logger logger = LogManager.getLogger(ReimbTypeDAOImpl.class);

    @Override
    public UserRole findByRoleId(int id) {

        logger.info("In UserRoleDAO layer, retriving reimbursement type by id.");

        UserRole userRole = new UserRole();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM ers_user_roles WHERE user_role_id = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userRole.setRoleId(id);
            }

            logger.info("User role search by id was successful. " + userRole);
        } catch (SQLException e) {
            logger.warn("Unable to execute SQL statement", e);
        }

        return userRole;
    }
}
