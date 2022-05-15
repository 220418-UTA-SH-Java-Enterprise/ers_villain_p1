package com.revature.services;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserService {
    public boolean addNewUser(User user) throws Exception;

    public User editUser(User user) throws Exception;

    public User getUserById(int id);

    public ArrayList<User> getAllUsers();

    public User loginUser(String username, String password) throws Exception;
}
