package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserDAOImpl;

import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private static UserDAOImpl userDAO = new UserDAOImpl();

    public UserServiceImpl() {

    }

    public UserServiceImpl(UserDAOImpl dao) {
        super();
        this.userDAO = dao;
    }

    @Override
    public int addNewUser(User user) throws Exception {
        logger.info("In service Layer: UserServiceImpl.addNewUser()");
        if (user.getUsername().length() > 3) {
            throw new Exception("Username must be at least 3 characters long.");
        }

        if (Character.isDigit(user.getUsername().charAt(0))) {
            throw new Exception("First character of username must be alphanumeric.");
        }

        return userDAO.insert(user);
    }

    @Override
    public boolean editUser(User user) throws Exception {
        if (user.getUsername().length() > 3) {
            throw new Exception("Username must be at least 3 characters long.");
        }

        if (Character.isDigit(user.getUsername().charAt(0))) {
            throw new Exception("First character of username must be alphanumeric.");
        }

        return userDAO.update(user);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAllUsers();
    }

}
