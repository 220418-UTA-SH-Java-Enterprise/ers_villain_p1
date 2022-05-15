package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimb;
import com.revature.repositories.ReimbDAOImpl;

public class ReimbServiceImpl implements ReimbService {

    private ReimbDAOImpl reimbDAO = new ReimbDAOImpl();

    @Override
    public int addNewReimbRequest(Reimb reimb) {
        return reimbDAO.insert(reimb);
    }

    @Override
    public boolean editReimbRequest(Reimb reimb) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Reimb getReimbRequestById(int reimbId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Reimb> getReimbByAuthorId(int authorId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Reimb> getReimbByStatus(int StatusTypeId) {
        // TODO Auto-generated method stub
        return null;
    }

}
