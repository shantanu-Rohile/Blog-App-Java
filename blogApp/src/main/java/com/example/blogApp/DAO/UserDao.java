package com.example.blogApp.DAO;

import com.example.blogApp.Entity.User;

import java.util.List;


public interface UserDao {
    String createUser(String username, String email, String password);
    String deleteUser(String email);
    String updateUser(String email);
    User getUser(String email);
    List<User> getAllUsers();
}
