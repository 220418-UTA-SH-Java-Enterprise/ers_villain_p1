package com.revature.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Reimb;
import com.revature.util.ConnectionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReimbDAOImpl implements ReimbDAO {

    private static Logger logger = LogManager.getLogger(ReimbDAOImpl.class);

    @Override
    public boolean insert(Reimb reimb) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            logger.info("In DAO layer: making a reimbursement in db...");

            // SQL Statement to be executed for addition to the reimbursement table
            String sql = "INSERT INTO ers_reimbursements (amount, submitted, resolved, description, receipt, author, resolver, status_id, type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            // Create the prepared statment variable
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Update fields with data from the model
            stmt.setDouble(1, reimb.getAmount());
            stmt.setDate(2, Date.valueOf(reimb.getSubmitted()));
            stmt.setDate(3, Date.valueOf(reimb.getResolved()));
            stmt.setString(4, reimb.getDescription());
            stmt.setString(5, reimb.getDescription());
            stmt.setInt(6, reimb.getAuthorId());
            stmt.setInt(7, reimb.getResolverId());
            stmt.setInt(8, reimb.getStatusid());
            stmt.setInt(9, reimb.getTypeId());

            // Execute the statement
            stmt.execute();

            // Retrieve the newly created field
            ResultSet rs = stmt.getGeneratedKeys();

            int genKey = 0;
            if (rs.next()) {
                // If a new user was created this will return the reimb_id column of that field
                genKey = rs.getInt("reimb_id");
            }

            // This will update the reim model with the auto generated id
            reimb.setUserId(genKey);

            logger.info("New reimbursement has been entered into the database.");
        } catch (SQLException e) {
            logger.warn("Unable to execute SQL statement: " + e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Reimb reimb) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            logger.info("In DAO layer: updating reimburement: " + reimb.getReimbId());

            // SQL Statement to be executed for addition to the reimbursement table
            String sql = "UPDATE ers_reimbursements SET amount = ? submitted = ?, resolved = ?, description = ?, receipt = ?, author = ?, resolver = ?, status_id = ?, type_id = ? WHERE id = ?;";

            // Create the prepared statment variable
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Update fields with data from the model
            stmt.setDouble(1, reimb.getAmount());
            stmt.setDate(2, Date.valueOf(reimb.getSubmitted()));
            stmt.setDate(3, Date.valueOf(reimb.getResolved()));
            stmt.setString(4, reimb.getDescription());
            stmt.setString(5, reimb.getDescription());
            stmt.setInt(6, reimb.getAuthorId());
            stmt.setInt(7, reimb.getResolverId());
            stmt.setInt(8, reimb.getStatusid());
            stmt.setInt(9, reimb.getTypeId());
            stmt.setInt(10, reimb.getReimbId());

            // Execute the statement
            stmt.execute();

            logger.info("Updated reimbursement with id: ." + reimb.getReimbId());
        } catch (SQLException e) {
            logger.warn("Unable to execute SQL statement: " + e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public Reimb findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <List> Reimb findByUserId(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <List> Reimb findAll(int statusTypeId) {
        // TODO Auto-generated method stub
        return null;
    }

}
