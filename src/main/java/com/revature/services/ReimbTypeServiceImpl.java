package com.revature.services;

import com.revature.models.ReimbType;
import com.revature.repositories.ReimbTypeDAOImpl;

public class ReimbTypeServiceImpl implements ReimbTypeService {

    private static ReimbTypeDAOImpl reimbTypeDAO = new ReimbTypeDAOImpl();

    @Override
    public ReimbType getById(int id) {
        return reimbTypeDAO.findById(id);
    }

}
