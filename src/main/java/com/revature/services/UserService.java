package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {
    public int addNewUser(User user) throws Exception;

    public boolean editUser(User user) throws Exception;

    public User getUserById(int id);

    public List<User> getAllEmpById(); 

    public List<User> getAllUsers();

    // public User loginUser(String username, String password) throws Exception;
}
