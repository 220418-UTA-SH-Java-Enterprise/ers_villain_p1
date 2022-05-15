package com.revature.services;

import com.revature.models.UserRole;
import com.revature.repositories.UserRoleDAOImpl;

import org.apache.log4j.Logger;

public class UserRoleServiceImpl implements UserRoleService{

    private static Logger logger = Logger.getLogger(UserRoleServiceImpl.class);
    private static UserRoleDAOImpl userRoleDAO = new UserRoleDAOImpl();

    @Override
    public UserRole getByRoleId(int id) {
        logger.info("In Service Layer: UserRoleServiceImpl.getByRoleId()");
        return userRoleDAO.findByRoleId(id);
    }
}
