package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;

public interface ReimbDAO {
    // Create Reimbursement Request
    public int insert(Reimb reimb);

    // Read Reimbursement by Id
    public Reimb findById(int id);

    // Read Reimbursement by status
    public List<Reimb> findById(ReimbStatus reimb);

    // Read Reimbursement by type
    public List<Reimb> findById(ReimbType reimb);

    // Read Reimbursement by author
    public List<Reimb> findByAuthId(User user);

    // Read Reimbursement by author
    public List<Reimb> findByResolverId(User user);

    // Read Reimbursement by status type
    public List<Reimb> findAllByStatusType(int statusTypeId);

    // Update
    public boolean update(Reimb reimb);

    // Delete
    public boolean delete(Reimb reimb);

}
