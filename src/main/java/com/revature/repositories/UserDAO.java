package com.revature.repositories;

import com.revature.models.User;

public interface UserDAO {
  public boolean insert(User user);
  public boolean update(User user);
  public User findById(int id);
  public User login(String username, String password);
}
