package com.revature.services;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.User;

public interface ReimbService {
    // add, edit, patch, remove

    // Add reimbursement request
    public int addNewReimbRequest(Reimb reimb);

    public boolean editReimbRequest(Reimb reimb);

    public Reimb getReimbRequestById(int reimbId);

    public List<Reimb> getAllReimbs();

    public List<Reimb> getReimbByAuthorId(User auth);

    public List<Reimb> getAllPendingReimbs();

    public List<Reimb> getAllResolvedReimbs();

    public List<Reimb> getResolvedReimbsByUserId(User user);

    public List<Reimb> getPendingReimbsByUserId(User user);

    public List<Reimb> getReimbByStatus(int StatusTypeId);
}
