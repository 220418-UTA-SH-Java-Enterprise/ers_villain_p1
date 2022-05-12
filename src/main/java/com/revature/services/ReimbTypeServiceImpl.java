package com.revature.services;

import com.revature.models.ReimbType;
import com.revature.repositories.ReimbTypeDAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReimbTypeServiceImpl implements ReimbTypeService{

    private static Logger logger = LogManager.getLogger(ReimbTypeServiceImpl.class);
    private static ReimbTypeDAOImpl reimbTypeDAO = new ReimbTypeDAOImpl();

    @Override
    public ReimbType getTypeById(int id) {
        return reimbTypeDAO.findTypeById(id);
    }
    
}
