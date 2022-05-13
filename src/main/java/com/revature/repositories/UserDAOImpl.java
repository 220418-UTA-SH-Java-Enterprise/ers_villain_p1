package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDAOImpl implements UserDAO {

  private static Logger logger = LogManager.getLogger(UserDAOImpl.class);

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
  public User update(User user) {
    try (Connection conn = ConnectionUtil.getConnection()) {
      logger.info("In DAO layer: updating user: " + user.getUserId());

      String sql = "UPDATE ers_users SET username = ?, password = ?, email = ?, first_name = ?, last_name = ?, role_id =? WHERE user_id = ?;"; 
      PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getFirstName());
        stmt.setString(5, user.getLastName());
        stmt.setInt(6, user.getRoleId());
        stmt.setInt(7, user.getUserId());

        stmt.execute();

        ResultSet rs = stmt.getGeneratedKeys(); 

        if (rs.next()) {
          user.setUserId(rs.getInt(1));
        }

        logger.info("Updated user profile with id: ." + user.getUserId());

    }catch (SQLException e) {
      logger.warn("Unable to execute SQL statement: " + e.getMessage(), e);
      return null; 
    }
    return user; 
  }

  @Override
  public User findById(int id) {
    logger.info("In DAO Layer: getting user with user_id: " + id);

    User user = new User();

    try (Connection conn = ConnectionUtil.getConnection()) {
      String sql = "SELECT * FROM ers_users WHERE user_id = " + id + ";";

      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      if (rs.next()) {
        
        // Update the object with the results of the query
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setRoleId(rs.getInt("role_id"));
    }


    } catch (SQLException e) {
      logger.warn("Unable to execute SQL statement: " + e.getMessage(), e);
      return null;
  }
    return user; 
  }

  @Override
  public ArrayList<User> findAllUsers() {
    logger.info("In DAO Layer: getting all users.");

    ArrayList<User> userList = new ArrayList<User>();
    try (Connection conn = ConnectionUtil.getConnection()) {
      String sql = "SELECT * FROM ers_users; ";

      Statement stmt = conn.createStatement();

      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        User user = new User(); 

        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setRoleId(rs.getInt("role_id"));
       

      userList.add(user);
      }

     } catch (SQLException e) {
      logger.warn("Unable to execute SQL statement: " + e.getMessage(), e);
      return null;
     }
    return userList;
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
        // user.setPassword(rs.getString("password")); // Don't return the password...
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




}
