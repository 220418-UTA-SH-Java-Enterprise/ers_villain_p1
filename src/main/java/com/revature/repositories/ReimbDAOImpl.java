package com.revature.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.revature.models.Reimb;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
        Transaction transaction = null;
        Reimb reimb = null;
        try (Session session = HibernateUtil.getSession()) {
            // Start the transaction
            transaction = session.beginTransaction();

            // Get Reimb Object
            reimb = session.get(Reimb.class, id);

            // Commit the transaction
            transaction.commit();
        }
        return reimb;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Reimb> findAllByAuthId(User auth) {
        Transaction transaction = null;
        List<Reimb> reimb = null;
        try (Session session = HibernateUtil.getSession()) {

            // Create Criteria Builder
            CriteriaBuilder builder = session.getCriteriaBuilder();

            // Create CriteriaQuery
            CriteriaQuery<Reimb> criteria = builder.createQuery(Reimb.class);

            // Start the transaction
            transaction = session.beginTransaction();

            // get the reimbursement objects
            // reimb = criteria.where(("author_id", auth.getUserId()))
            // (Restrictions.eq("author_id", auth.getUserId())).list();
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return reimb;
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
