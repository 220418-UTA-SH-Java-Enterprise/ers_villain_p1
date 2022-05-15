package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsersDOAImpl implements UsersDAO {

    @Override
    public void insert(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Start the transaction
            transaction = session.beginTransaction();

            // Save User Object
            session.save(user);

            // Commit the transaction
            transaction.commit();
        }
    }

    @Override
    public ArrayList<User> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUserById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public User login(String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

}
