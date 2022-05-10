package com.revature.repositories;

import java.sql.Connection;
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
      logger.info("In DAO layer: making a new user in db...");
      String sql = "INSERT INTO users (username, password, email, first_name, last_name, role_id) VALUES (?, ?, ?, ?, ?, ?)";

      PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, user.getUsername());
      stmt.setString(2, user.getPassword());
      stmt.setString(3, user.getEmail());
      stmt.setString(4, user.getFirstName());
      stmt.setString(5, user.getLastName());
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
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public User findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public User login(String username, String password) {
    logger.info("In DAO Layer: UserDAOImpl() - attemptint to login user.");
    User user = new User();
    try (Connection conn = ConnectionUtil.getConnection()) {
      String sql = "SELECT * from users where username = ? AND password = ?;";

      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);

      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        user.setUserId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        // Don't return the password...
        // user.setPassword(rs.getString("password"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setRoleId(rs.getInt("role_id"));
      }
    } catch (SQLException e) {
      logger.warn("Unable to execute query");
      return null;
    }
    return user;
  }

  public boolean delete() {
    // TODO: discuss delete or set inactive
    return false;
  }

}
