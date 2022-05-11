package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimb;
import com.revature.repositories.ReimbDAOImpl;

public class ReimbServiceImpl implements ReimbService {

    private ReimbDAOImpl reimbDAO = new ReimbDAOImpl();

    @Override
    public boolean addNewReimbRequest(Reimb reimb) {
        return reimbDAO.insert(reimb);
    }

    @Override
    public boolean editReimbRequest(Reimb reimb) {
        return reimbDAO.update(reimb);
    }

    @Override
    public Reimb getReimbRequestById(int reimbId) {
        return reimbDAO.findById(reimbId);
    }

    @Override
    public ArrayList<Reimb> getReimbByAuthorId(int authorId) {
        return reimbDAO.findByAuthId(authorId);
    }

    @Override
    public ArrayList<Reimb> getReimbByStatus(int StatusTypeId) {
        return reimbDAO.findAllByStatusType(StatusTypeId);
    }

}
