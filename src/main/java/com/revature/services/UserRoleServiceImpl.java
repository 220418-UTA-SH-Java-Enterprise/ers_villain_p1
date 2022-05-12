package com.revature.services;

import com.revature.models.UserRole;
import com.revature.repositories.UserRoleDAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserRoleServiceImpl implements UserRoleService {

    private static Logger logger = LogManager.getLogger(UserRoleServiceImpl.class);
    private static UserRoleDAOImpl userRoleDAO = new UserRoleDAOImpl();

    @Override
    public UserRole findRoleById(int id) {
        return userRoleDAO.findById(id);
    }

}
