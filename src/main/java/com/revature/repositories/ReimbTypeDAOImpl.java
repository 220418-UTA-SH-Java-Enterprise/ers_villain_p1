package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ReimbType;
import com.revature.util.ConnectionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReimbTypeDAOImpl implements ReimbTypeDAO {

    private static Logger logger = LogManager.getLogger(ReimbTypeDAO.class);

    @Override
    public ReimbType findById(int id) {
        logger.info("In ReimbTypeDAO layer, retriving reimbursement type by id.");
        ReimbType type = new ReimbType();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM ers_reimbursement_type WHERE reimb_type_id = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                type.setTypeId(id);
            }

            logger.info("Reimbursement type search by id was successful. " + type);
        } catch (SQLException e) {
            logger.warn("Unable to execute SQL statement", e);
        }

        return type;
    }

}
