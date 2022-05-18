package com.revature.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
    try {
      Session session = HibernateUtil.getSession();
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

    User user = null;

    try {
      Session session = HibernateUtil.getSession();
      // Get Reimb Object
      user = session.createNativeQuery("SELECT * FROM ers_users WHERE user_id = " + id + " ORDER BY user_id",
          User.class).getSingleResult();

      logger.info(user);

    } catch (Exception e) {
      logger.warn("unable to complete findAllByStatusType query");
    }

    logger.info("returning user: " + user);

    return user;
  }


  @Override
  public List<User> findAllEmpByRoleId(int roleId) {
    logger.info("In DAO Layer: getting all employees with role_id: " + roleId);

    List<User> employees = null;

    try {
      Session session = HibernateUtil.getSession();
      // Get Reimb Object
      employees = session.createNativeQuery("SELECT * FROM ers_users WHERE role_id = " + roleId + ";",
          User.class).list();

      for (User e : employees) {
        logger.info(e);
      }
    } catch (Exception e) {
      logger.warn("unable to complete findAllByRoleId query");
    }
    return employees;
  }

  @Override
  public List<User> findAllUsers() {
    logger.info("In DAO Layer: getting all users.");

    List<User> users;
    Session session = HibernateUtil.getSession();

    // Get Reimb Object
    users = session.createNativeQuery("SELECT * FROM ers_users ORDER BY user_id",
        User.class).list();

    for (User user : users) {
      logger.info(user);
    }
    return users;

  }

}

// @Override
// public User login(String username, String password) {
// logger.info("In DAO Layer: UserDAOImpl() - attemptint to login user.");
// // User user = new User();
// // try (Connection conn = ConnectionUtil.getConnection()) {
// // String sql = "SELECT * from users where username = ? AND password = ?;";

// // PreparedStatement stmt = conn.prepareStatement(sql);
// // stmt.setString(1, username);
// // stmt.setString(2, password);

// // ResultSet rs = stmt.executeQuery();

// // if (rs.next()) {
// // user.setUserId(rs.getInt("id"));
// // user.setUsername(rs.getString("username"));
// // // user.setPassword(rs.getString("password")); // Don't return the
// // password...
// // user.setFirstName(rs.getString("first_name"));
// // user.setLastName(rs.getString("last_name"));
// // user.setEmail(rs.getString("email"));
// // user.setRoleId(rs.getInt("role_id"));
// // }
// // } catch (SQLException e) {
// // logger.warn("Unable to execute query");
// // return null;
// // }
// // return user;
// }
