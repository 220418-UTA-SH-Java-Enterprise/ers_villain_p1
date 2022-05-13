package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.User;

public interface UsersDAO {
    // Save User
    // Get all Users
    // Get User by id
    // Update User
    // Delete User

    public void insert(User user);

    public ArrayList<User> getAllUsers();

    public User getUserById(int id);

    public boolean update(User user);

    public boolean delete(int id);

    public User login(String username, String password);
}
