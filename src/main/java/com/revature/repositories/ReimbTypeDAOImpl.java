package com.revature.repositories;

import com.revature.models.ReimbType;
import com.revature.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReimbTypeDAOImpl implements ReimbTypeDAO {

    private static Logger logger = Logger.getLogger(ReimbTypeDAO.class);

    @Override
    public ReimbType findById(int id) {
        logger.info("Finding reimbursement type by id: " + id);
        Transaction transaction = null;
        ReimbType reimbType = null;

        try {
            Session session = HibernateUtil.getSession();
            // Start the transaction
            transaction = session.beginTransaction();

            // Get Reimb Object
            reimbType = session.get(ReimbType.class, id);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            logger.warn("Unable to complete ReimbType transaction.");
        }
        return reimbType;
    }

}
