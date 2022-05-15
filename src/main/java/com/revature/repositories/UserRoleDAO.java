package com.revature.repositories;

import com.revature.models.UserRole;

public interface UserRoleDAO {
    
    public UserRole findByRoleId(int id); 
}
