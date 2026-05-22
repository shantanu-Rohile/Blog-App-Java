package com.example.blogApp.Rest;


import com.example.blogApp.DAO.UserDao;
import com.example.blogApp.Entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRest {
    UserDao dao;
    EntityManager em;
    public UserRest(UserDao userDao, EntityManager em) {
        dao=userDao;
        this.em=em;
    }
    @GetMapping("/user")
    public List<User> getAllUser(){
        return dao.getAllUsers();
    }

    @GetMapping("/user/email/{email}")
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

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return dao.gerUserById(id);
    }

    @PatchMapping("/user/{id}")
    public User updateUser(@PathVariable int id,
                           @RequestBody User user) {

        User u = em.find(User.class, id);

        if (u == null) {
            throw new RuntimeException("User not found");
        }

        if (user.getUsername() != null) {
            u.setUsername(user.getUsername());
        }

        if (user.getEmail() != null) {
            u.setEmail(user.getEmail());
        }

        if (user.getPassword() != null) {
            u.setPassword(user.getPassword());
        }

        return u;
    }
}
