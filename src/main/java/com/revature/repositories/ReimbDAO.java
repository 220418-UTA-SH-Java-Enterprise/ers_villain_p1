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
    public List<Reimb> findAllByAuthId(User user); //

    // Read Reimbursement by status type
    public List<Reimb> findAllByStatusType(int statusTypeId); //

    // Update
    public boolean update(Reimb reimb); //

}
