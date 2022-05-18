package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.User;
import com.revature.repositories.ReimbDAOImpl;

public class ReimbServiceImpl implements ReimbService {

    private ReimbDAOImpl reimbDAO = new ReimbDAOImpl();

    @Override
    public int addNewReimbRequest(Reimb reimb) {
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
    public List<Reimb> getAllReimbs() {
        return reimbDAO.findAllReimbs();
    }

    @Override
    public List<Reimb> getReimbByAuthorId(User auth) {
        return reimbDAO.findAllByAuthId(auth);
    }

    @Override
    public List<Reimb> getReimbByStatus(int statusTypeId) {
        return reimbDAO.findAllByStatusType(statusTypeId);
    }

    public List<Reimb> getResolvedReimbsByUserId(User user) {
        List<Reimb> reimbs = new ArrayList<Reimb>();
        reimbs = reimbDAO.findAllResolvedByAuthId(user);
        return reimbs;
    }

}
