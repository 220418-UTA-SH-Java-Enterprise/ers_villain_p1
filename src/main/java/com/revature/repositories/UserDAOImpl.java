package com.revature.repositories;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    Transaction transaction = null;
    User user = null;
    try (Session session = HibernateUtil.getSession()) {
      // Start the transaction
      transaction = session.beginTransaction();

      // Get User Object
      user = session.get(User.class, id);

      // Commit the transaction
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
    return user;
  }

  @Override
  public List<User> findAllUsers() {
    logger.info("In DAO Layer: getting all users.");

    Transaction transaction = null;
    List<User> user = null;

    try (Session session = HibernateUtil.getSession()) {
      // // Start the transaction
      // transaction = session.beginTransaction();

      // // Get Reimb Object
      // user = session.createQuery("SELECT a FROM User a",
      // User.class).getResultList();

      // // Commit the transaction
      // transaction.commit();

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<User> cq = cb.createQuery(User.class);
      Root<User> rootEntry = cq.from(User.class);
      CriteriaQuery<User> all = cq.select(rootEntry);

      TypedQuery<User> allQuery = session.createQuery(all);
      logger.info(allQuery.toString());
      user = allQuery.getResultList();
    } catch (Exception e) {
      // if (transaction != null) {
      // // transaction.rollback();
      // }
    }
    logger.info("fjak");
    logger.info(user.toString());
    return user;
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

}
