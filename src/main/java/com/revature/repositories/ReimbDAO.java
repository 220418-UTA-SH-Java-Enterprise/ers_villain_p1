package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.Reimb;

public interface ReimbDAO {
    // Submit new reimbursement requests to
    public boolean insert(Reimb reimb);

    // Change anything about Reimbursement
    public boolean update(Reimb reimb);

    // View single Reimbursement request
    public Reimb findById(int id);

    // View all request of single user
    public <List> Reimb findByUserId(int userId);

    // View all requests by status type
    public <List> ArrayList<Reimb> findAllByStatusType(int statusTypeId);
}
