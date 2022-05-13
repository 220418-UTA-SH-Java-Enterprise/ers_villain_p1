package com.revature.repositories;

import org.hibernate.Transaction;

import com.revature.models.ReimbStatus;
import com.revature.util.HibernateUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class ReimbStatusDAOImpl implements ReimbStatusDAO {
  private static Logger logger = LogManager.getLogger(ReimbStatusDAOImpl.class);
  ReimbStatus reimbStatus = new ReimbStatus();

  @Override
  public ReimbStatus findReimbStatusById(int id) {
    Transaction transaction = null;
    ReimbStatus reimbStatus = null;
    
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      // Starts the transaction
      transaction = session.beginTransaction();
      
      // get Reimbursement Status using id property
      reimbStatus = session.get(ReimbStatus.class, id);

      // Commit Transaction
      transaction.commit();
    } catch (Exception e) {
        if(transaction != null) { 
          transaction.rollback();
        }
      e.printStackTrace();
    }
    return reimbStatus;
  }
  
}
