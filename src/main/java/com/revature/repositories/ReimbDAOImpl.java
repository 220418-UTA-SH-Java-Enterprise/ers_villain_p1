package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReimbDAOImpl implements ReimbDAO {

    private static Logger logger = Logger.getLogger(ReimbDAOImpl.class);

    @Override
    public int insert(Reimb reimb) {
        logger.info("Add reimbursement request to db. reimbursement request: " + reimb);

        Session session = HibernateUtil.getSession();

        Transaction transaction = null;

        int pk = 0;

        try {
            // Start the transaction
            transaction = session.beginTransaction();

            // Save the reimbursement object
            pk = (int) session.save(reimb);

            // Commit transaction
            transaction.commit();

        } catch (Exception e) {
            logger.warn("Error entering the reimbursement request");
            if (transaction != null) {
                transaction.rollback();
            }
        }

        // Return the primary key of the new entry
        return pk;
    }

    @Override
    public Reimb findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Reimb> findById(ReimbStatus reimb) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Reimb> findById(ReimbType reimb) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Reimb> findByAuthId(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Reimb> findByResolverId(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Reimb> findAllByStatusType(int statusTypeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Reimb reimb) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Reimb reimb) {
        // TODO Auto-generated method stub
        return false;
    }

}
