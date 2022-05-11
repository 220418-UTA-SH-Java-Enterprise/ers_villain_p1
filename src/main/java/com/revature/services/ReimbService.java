package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimb;

public interface ReimbService {
    public boolean addNewReimbRequest(Reimb reimb);

    public boolean editReimbRequest(Reimb reimb);

    public Reimb getReimbRequestById(int reimbId);

    public ArrayList<Reimb> getReimbByAuthorId(int authorId);

    public ArrayList<Reimb> getReimbByStatus(int StatusTypeId);
}
