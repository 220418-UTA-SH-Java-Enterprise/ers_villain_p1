package com.revature.services;

import com.revature.models.User;

public interface UserService {
    public boolean addNewUser(User user) throws Exception;

    public boolean editUser(User user) throws Exception;

    public User getUserById(int id);

    public boolean deleteUser(User user);

    public User loginUser(String username, String password) throws Exception;
}
