package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDAOImpl implements UserDAO {

  private Logger logger = LogManager.getLogger(UserDAOImpl.class);

  @Override
  public boolean insert(User user) {
    try (Connection conn = ConnectionUtil.getConnection()) {
      logger.info("In DAO layer: making a new user in database");
      String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES (?, ?, ?, ?, ?, ?)";

      PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, user.getUsername());
      stmt.setString(2, user.getPassword());
      stmt.setString(3, user.getFirstName());
      stmt.setString(4, user.getLastName());
      stmt.setString(5, user.getEmail());
      stmt.setInt(6, user.getRoleId());

      stmt.execute();

      ResultSet rs = stmt.getGeneratedKeys();

      int genKey = 0;
      if (rs.next()) {
        genKey = rs.getInt(1);
      }

      user.setUserId(genKey);

      logger.info("New user has been entered into the database.");

      conn.close();
    } catch (SQLException e) {
      logger.warn("Unable to execute SQL statement:", e);
      return false;
    }
    return true;
  }

  @Override
  public boolean update(User user) {
    logger.info("In DAO layer: Updating user information by id...");

    try (Connection conn = ConnectionUtil.getConnection()) {
      String sql = "UPDATE ers_users SET ers_username = ?, ers_password = ?, user_first_name = ?, user_last_name = ?, user_email = ?, user_role_id = ? WHERE ers_user_id = ?;";

      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, user.getUsername());
      stmt.setString(2, user.getPassword());
      stmt.setString(3, user.getFirstName());
      stmt.setString(4, user.getLastName());
      stmt.setString(5, user.getEmail());
      stmt.setInt(6, user.getRoleId());
      stmt.setInt(7, user.getUserId());

      logger.info("User update by ID " + user.getUserId() + " was successful. ");

    } catch (SQLException e) {
      logger.warn("Unable to execute SQL statement", e);
      return false;
    }

    return true;
  }

  @Override
  public User findById(int id) {
    logger.info("In DAO layer: Getting user by ID...");
    User user = new User();

    try (Connection conn = ConnectionUtil.getConnection()) {
      String sql = "SELECT * FROM ers_users WHERE ers_user_id = ?;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        user.setUserId(rs.getInt("ers_user_id"));
        user.setUsername(rs.getString("ers_username"));
        // user.setPassword(rs.getString("ers_password")); // Don't return the
        // password...
        user.setFirstName(rs.getString("user_first_name"));
        user.setLastName(rs.getString("user_last_name"));
        user.setEmail(rs.getString("user_email"));
        user.setRoleId(rs.getInt("user_role_id"));
      }

      logger.info("User search by id was successful. " + id);
    } catch (SQLException e) {
      logger.warn("Unable to execute SQL statement", e);
    }

    return user;
  }

  @Override
  public User login(String username, String password) {
    logger.info("In DAO Layer: UserDAOImpl() - attempting to login user.");
    User user = new User();
    try (Connection conn = ConnectionUtil.getConnection()) {
      String sql = "SELECT * FROM ers_users where ers_username = ? AND ers_password = ?;";

      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);

      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        user.setUserId(rs.getInt("ers_user_id"));
        user.setUsername(rs.getString("ers_username"));
        // user.setPassword(rs.getString("ers_password")); // Don't return the password...
        user.setFirstName(rs.getString("user_first_name"));
        user.setLastName(rs.getString("user_last_name"));
        user.setEmail(rs.getString("user_email"));
        user.setRoleId(rs.getInt("user_role_id"));
      }
      logger.info("Login user by username and password was successful.");

    } catch (SQLException e) {
      logger.warn("Unable to execute query");
      return null;
    }
    return user;
  }

  public boolean delete(User user) {
    // TODO: discuss delete or set inactive
    return false;
  }

}
