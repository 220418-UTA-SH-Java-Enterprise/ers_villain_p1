package com.revature.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        logger.info("Find reimbursement by id: " + id);
        Transaction transaction = null;
        Reimb reimb = null;
        try (Session session = HibernateUtil.getSession()) {
            // Start the transaction
            transaction = session.beginTransaction();

            // Get Reimb Object
            reimb = session.get(Reimb.class, id);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return reimb;
    }

    @Override
    public List<Reimb> findAllReimbs() {
        logger.info("Find all reimbursements");

        List<Reimb> reimbs;
        Session session = HibernateUtil.getSession();

        // Get Reimb Object
        reimbs = session.createNativeQuery("SELECT * FROM ers_reimbursements",
                Reimb.class).list();

        for (Reimb reimb : reimbs) {
            logger.info(reimb);
        }
        logger.info(reimbs);
        return reimbs;
    }

    @Override
    public List<Reimb> findAllByAuthId(User auth) {
        logger.info("Find all reimbursements");

        List<Reimb> reimbs;
        Session session = HibernateUtil.getSession();

        // Get Reimb Object
        reimbs = session.createNativeQuery("SELECT * FROM ers_reimbursements where author_id = " + auth.getUserId(),
                Reimb.class).list();

        logger.info(reimbs);

        // Return list of reimbursements
        return reimbs;
    }

    // @Override
    // public List<Reimb> findAllResolvedByAuthId(User auth) {
    // logger.info("Find all reimbursements");

    // Session session = HibernateUtil.getSession();

    // // 1. Create Criteria Builder
    // CriteriaBuilder cb = session.getCriteriaBuilder();

    // // 2. Create Query Criteria
    // CriteriaQuery<Reimb> cq = cb.createQuery(Reimb.class);

    // // 3. Set the root
    // Root<Reimb> reimb = cq.from(Reimb.class);

    // // 4. Create the join
    // Join<Reimb, ReimbStatus> reimbStatus = reimb.join("status"); // Root's
    // joinColumn variable
    // Join<Reimb, ReimbStatus> reimbAuth = reimb.join("author"); // Root's
    // joinColumn variable

    // // 5. What does this do?
    // cq.select(reimb);
    // cq.where(cb.and(
    // cb.notEqual(reimbStatus.get("reimbStatusId"), 1),
    // cb.notEqual(reimbStatus.get("reimbStatusId"), 2),
    // cb.equal(reimbAuth.get("id"), auth.getUserId())));

    // // 6. Execute Query
    // Query<Reimb> query = session.createQuery(cq);

    // // 7. Save results to a variable (list in this case)
    // List<Reimb> reimbs = query.getResultList();

    // // 8. return the results
    // return reimbs;
    // }

    public List<Reimb> findAllPendingByAuthId(User auth) {
        logger.info("Find all reimbursements");

        Session session = HibernateUtil.getSession();

        // 1. Create Criteria Builder
        CriteriaBuilder cb = session.getCriteriaBuilder();

        // 2. Create Query Criteria
        CriteriaQuery<Reimb> cq = cb.createQuery(Reimb.class);

        // 3. Set the root
        Root<Reimb> reimb = cq.from(Reimb.class);

        // 4. Create the join
        Join<Reimb, ReimbStatus> reimbStatus = reimb.join("status"); // Root's joinColumn variable
        Join<Reimb, ReimbStatus> reimbAuth = reimb.join("author"); // Root's joinColumn variable

        // 5. What does this do?
        cq.select(reimb);
        cq.where(cb.and(
                cb.notEqual(reimbStatus.get("reimbStatusId"), 3),
                cb.notEqual(reimbStatus.get("reimbStatusId"), 4),
                cb.equal(reimbAuth.get("id"), auth.getUserId())));

        // 6. Execute Query
        Query<Reimb> query = session.createQuery(cq);

        // 7. Save results to a variable (list in this case)
        List<Reimb> reimbs = query.getResultList();

        // 8. return the results
        return reimbs;
    }

    @Override
    public List<Reimb> findAllPending() {
        logger.info("Find all reimbursements");

        Session session = HibernateUtil.getSession();

        // 1. Create Criteria Builder
        CriteriaBuilder cb = session.getCriteriaBuilder();

        // 2. Create Query Criteria
        CriteriaQuery<Reimb> cq = cb.createQuery(Reimb.class);

        // 3. Set the root
        Root<Reimb> reimb = cq.from(Reimb.class);

        // 4. Create the join
        Join<Reimb, ReimbStatus> reimbStatus = reimb.join("status"); // Root's joinColumn variable

        // 5. What does this do?
        cq.select(reimb);
        cq.where(cb.and(
                cb.notEqual(reimbStatus.get("reimbStatusId"), 3),
                cb.notEqual(reimbStatus.get("reimbStatusId"), 4)));

        // 6. Execute Query
        Query<Reimb> query = session.createQuery(cq);

        // 7. Save results to a variable (list in this case)
        List<Reimb> reimbs = query.getResultList();

        // 8. return the results
        return reimbs;
    }

    public List<Reimb> findAllResolved() {
        logger.info("Find all reimbursements");

        Session session = HibernateUtil.getSession();

        // 1. Create Criteria Builder
        CriteriaBuilder cb = session.getCriteriaBuilder();

        // 2. Create Query Criteria
        CriteriaQuery<Reimb> cq = cb.createQuery(Reimb.class);

        // 3. Set the root
        Root<Reimb> reimb = cq.from(Reimb.class);

        // 4. Create the join
        Join<Reimb, ReimbStatus> reimbStatus = reimb.join("status"); // Root's joinColumn variable

        // 5. What does this do?
        cq.select(reimb);
        cq.where(cb.and(
                cb.notEqual(reimbStatus.get("reimbStatusId"), 1),
                cb.notEqual(reimbStatus.get("reimbStatusId"), 2)));

        // 6. Execute Query
        Query<Reimb> query = session.createQuery(cq);

        // 7. Save results to a variable (list in this case)
        List<Reimb> reimbs = query.getResultList();

        // 8. return the results
        return reimbs;
    }

    @Override
    public List<Reimb> findAllResolvedByAuthId(User auth) {
        logger.info("Find all reimbursements");

        Session session = HibernateUtil.getSession();

        // 1. Create Criteria Builder
        CriteriaBuilder cb = session.getCriteriaBuilder();

        // 2. Create Query Criteria
        CriteriaQuery<Reimb> cq = cb.createQuery(Reimb.class);

        // 3. Set the root
        Root<Reimb> reimb = cq.from(Reimb.class);

        // 4. Create the join
        Join<Reimb, ReimbStatus> reimbStatus = reimb.join("status"); // Root's joinColumn variable
        Join<Reimb, ReimbStatus> reimbAuth = reimb.join("author"); // Root's joinColumn variable

        // 5. What does this do?
        cq.select(reimb);
        cq.where(cb.and(
                cb.notEqual(reimbStatus.get("reimbStatusId"), 1),
                cb.notEqual(reimbStatus.get("reimbStatusId"), 2),
                cb.equal(reimbAuth.get("id"), auth.getUserId())));

        // 6. Execute Query
        Query<Reimb> query = session.createQuery(cq);

        // 7. Save results to a variable (list in this case)
        List<Reimb> reimbs = query.getResultList();

        // 8. return the results
        return reimbs;
    }

    @Override
    public boolean update(Reimb reimb) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            // Start the Transaction
            transaction = session.beginTransaction();

            // Save Reimbursement object
            session.saveOrUpdate(reimb);

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
    public List<Reimb> findAllByStatusType(int statusTypeId) {
        // TODO Auto-generated method stub
        return null;
    }
}
