package com.revature.repositories;

import com.revature.models.ReimbStatus;
import com.revature.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReimbStatusDAOImpl implements ReimbStatusDAO {
  private static Logger logger = Logger.getLogger(ReimbStatusDAOImpl.class);
  ReimbStatus reimbStatus = new ReimbStatus();

  @Override
  public ReimbStatus findReimbStatusById(int id) {
    logger.info("In DAO Layer: ReimbStatuDAOeImpl.findReimbStatusById()");
    Transaction transaction = null;
    ReimbStatus reimbStatus = null;

    try (Session session = HibernateUtil.getSession()) {
      // Starts the transaction
      transaction = session.beginTransaction();

      // get Reimbursement Status using id property
      reimbStatus = session.get(ReimbStatus.class, id);

      // Commit Transaction
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return reimbStatus;
  }

}
