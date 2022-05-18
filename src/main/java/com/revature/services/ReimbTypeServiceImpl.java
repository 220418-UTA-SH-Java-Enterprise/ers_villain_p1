package com.revature.services;

import com.revature.models.ReimbType;
import com.revature.repositories.ReimbTypeDAOImpl;

import org.apache.log4j.Logger;

public class ReimbTypeServiceImpl implements ReimbTypeService {

    private static Logger logger = Logger.getLogger(ReimbTypeServiceImpl.class);
    private static ReimbTypeDAOImpl reimbTypeDAO = new ReimbTypeDAOImpl();

    public ReimbTypeServiceImpl() {
    }

    public ReimbTypeServiceImpl(ReimbTypeDAOImpl mockdao) {
    }

    @Override
    public ReimbType getById(int id) {
        return reimbTypeDAO.findById(id);
    }

}
