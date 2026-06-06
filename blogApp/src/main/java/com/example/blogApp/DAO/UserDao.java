package com.example.blogApp.DAO;

import com.example.blogApp.Entity.User;

import java.util.List;


public interface UserDao {
    String createUser(String username, String email, String password, String Role);
    String deleteUser(String email);
    User getUser(String email);
    List<User> getAllUsers();
    User gerUserById(int id);
}
