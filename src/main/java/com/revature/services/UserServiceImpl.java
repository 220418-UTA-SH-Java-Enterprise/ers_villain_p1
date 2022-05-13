package com.revature.services;

import java.util.ArrayList;

import com.revature.models.User;
import com.revature.repositories.UserDAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private static UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public boolean addNewUser(User user) throws Exception {
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
    public User editUser(User user) throws Exception {
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
    public ArrayList<User> getAllUsers() {
        return userDAO.findAllUsers();
    }



    @Override
    public User loginUser(String username, String password) throws Exception {

        User user = userDAO.login(username, password);

        if (user == null) {
            throw new Exception("Invalid username or password");
        }

        return user;
    }


}
