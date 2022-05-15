package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {

  private static Logger logger = Logger.getLogger(UserDAOImpl.class);

  @Override
  public int insert(User user) {

    logger.info("Add reimbursement request to db. reimbursement request: " + user);

    Session session = HibernateUtil.getSession();

    Transaction transaction = null;

    int pk = 0;

    try {
      // Start the transaction
      transaction = session.beginTransaction();

      // Save the user object
      pk = (int) session.save(user);

      // Commit transaction
      transaction.commit();

    } catch (Exception e) {
      logger.warn("Error entering the user.");
      if (transaction != null) {
        transaction.rollback();
      }
    }

    // Return the primary key of the new entry
    return pk;
  }

  @Override
  public boolean update(User user) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSession()) {
      // Start the Transaction
      transaction = session.beginTransaction();

      // Save User object
      session.saveOrUpdate(user);

      // Commit the transaction
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
    return true;
  }

  @Override
  public User findById(int id) {
    logger.info("In DAO Layer: getting user with user_id: " + id);

    // User user = new User();

    // try (Connection conn = ConnectionUtil.getConnection()) {
    // String sql = "SELECT * FROM ers_users WHERE user_id = " + id + ";";

    // Statement stmt = conn.createStatement();
    // ResultSet rs = stmt.executeQuery(sql);

    // if (rs.next()) {

    // // Update the object with the results of the query
    // user.setUserId(rs.getInt("user_id"));
    // user.setUsername(rs.getString("username"));
    // user.setPassword(rs.getString("password"));
    // user.setFirstName(rs.getString("first_name"));
    // user.setLastName(rs.getString("last_name"));
    // user.setEmail(rs.getString("email"));
    // user.setRoleId(rs.getInt("role_id"));
    // }

    // } catch (SQLException e) {
    // logger.warn("Unable to execute SQL statement: " + e.getMessage(), e);
    // return null;
    // }
    // return user;
  }

  @Override
  public ArrayList<User> findAllUsers() {
    logger.info("In DAO Layer: getting all users.");

    // ArrayList<User> userList = new ArrayList<User>();
    // try (Connection conn = ConnectionUtil.getConnection()) {
    // String sql = "SELECT * FROM ers_users; ";

    // Statement stmt = conn.createStatement();

    // ResultSet rs = stmt.executeQuery(sql);

    // while (rs.next()) {
    // User user = new User();

    // user.setUserId(rs.getInt("user_id"));
    // user.setUsername(rs.getString("username"));
    // user.setPassword(rs.getString("password"));
    // user.setFirstName(rs.getString("first_name"));
    // user.setLastName(rs.getString("last_name"));
    // user.setEmail(rs.getString("email"));
    // user.setRoleId(rs.getInt("role_id"));

    // userList.add(user);
    // }

    // } catch (SQLException e) {
    // logger.warn("Unable to execute SQL statement: " + e.getMessage(), e);
    // return null;
    // }
    // return userList;
  }

  @Override
  public User login(String username, String password) {
    logger.info("In DAO Layer: UserDAOImpl() - attemptint to login user.");
    // User user = new User();
    // try (Connection conn = ConnectionUtil.getConnection()) {
    // String sql = "SELECT * from users where username = ? AND password = ?;";

    // PreparedStatement stmt = conn.prepareStatement(sql);
    // stmt.setString(1, username);
    // stmt.setString(2, password);

    // ResultSet rs = stmt.executeQuery();

    // if (rs.next()) {
    // user.setUserId(rs.getInt("id"));
    // user.setUsername(rs.getString("username"));
    // // user.setPassword(rs.getString("password")); // Don't return the
    // password...
    // user.setFirstName(rs.getString("first_name"));
    // user.setLastName(rs.getString("last_name"));
    // user.setEmail(rs.getString("email"));
    // user.setRoleId(rs.getInt("role_id"));
    // }
    // } catch (SQLException e) {
    // logger.warn("Unable to execute query");
    // return null;
    // }
    // return user;
  }

}
