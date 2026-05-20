package com.example.blogApp.Rest;


import com.example.blogApp.DAO.UserDao;
import com.example.blogApp.Entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRest {
    UserDao dao;
    public UserRest(UserDao userDao) {
        dao=userDao;
    }
    @GetMapping("/user")
    public List<User> getAllUser(){
        return dao.getAllUsers();
    }

    @GetMapping("/user/{email}")
    public User getUser(@RequestParam String email){
        User user=dao.getUser(email);
        return user;
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestParam String email){
        return dao.deleteUser(email);
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        return dao.createUser(user.getUsername(),user.getEmail(),user.getPassword());
    }
}
