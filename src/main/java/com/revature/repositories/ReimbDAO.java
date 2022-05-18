package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.User;

public interface ReimbDAO {
    // Create Reimbursement Request
    public int insert(Reimb reimb); //

    // Read Reimbursement by Id
    public Reimb findById(int id);

    // Read Reimbursement by author
    public List<Reimb> findAllReimbs(); //

    // Read Reimbursement by author
    public List<Reimb> findAllByAuthId(User user); // Done

    // Read Resolved Reimbursements by Auth
    public List<Reimb> findAllResolvedByAuthId(User user); // Done

    // Read Pending Reimbursements
    public List<Reimb> findAllPending();

    // Read Pending Reimbursements by Auth
    public List<Reimb> findAllPendingByAuthId(User auth); // Done

    // Read Reimbursement by status type
    public List<Reimb> findAllByStatusType(int statusTypeId); // Done

    // Update
    public boolean update(Reimb reimb); //

}
