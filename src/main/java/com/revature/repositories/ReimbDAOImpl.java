package com.revature.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
            stmt.setInt(8, reimb.getStatusId());
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

            // This will update the reimb model with the auto generated id
            reimb.setReimbId(genKey);

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
            stmt.setInt(8, reimb.getStatusId());
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
        logger.info("In DAO Layer: getting reimbursement request with id: " + id);

        try (Connection conn = ConnectionUtil.getConnection()) {
            // Create Query string to find the reimbursement request
            String sql = "SELECT * FROM ers_reimbursements WHERE id = " + id + ";";

            // Set the query to a statement
            Statement stmt = conn.createStatement();

            // Execute and capture the data from the query
            ResultSet rs = stmt.executeQuery(sql);

            // Check to see what was returned
            if (rs.next()) {
                // Create new Reimbursement object
                Reimb reimb = new Reimb();

                // Need a date formatter for a couple of the fields
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String submittedDate = rs.getDate("submitted").toString();
                String resolvedDate = rs.getDate("resolved").toString();

                // Update the object with the results of the query
                reimb.setReimbId(rs.getInt("reimbId"));
                reimb.setAmount(rs.getDouble("amount"));
                reimb.setSubmitted(LocalDate.parse(submittedDate, formatter));
                reimb.setResolved(LocalDate.parse(resolvedDate, formatter));
                reimb.setDescription(rs.getString("description"));
                reimb.setReceipt(rs.getString("receipt"));
                reimb.setAuthorId(rs.getInt("authorId"));
                reimb.setResolverId(rs.getInt("resolverId"));
                reimb.setStatusId(rs.getInt("statusId"));
                reimb.setTypeId(rs.getInt("typeId"));

                // Return the completed object
                return reimb;
            }

        } catch (SQLException e) {
            logger.warn("Unable to execute SQL statement: " + e.getMessage(), e);
        }
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
