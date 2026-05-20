package com.example.blogApp.DAO;

import com.example.blogApp.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    EntityManager em;
    public UserDaoImpl(EntityManager entityManager) {
            em= entityManager;
    }

    @Override
    @Transactional
    public String createUser(String username, String email, String password) {
        User user=new User(username,email,password);
        em.persist(user);
        return "User created successfully";
    }

    @Override
    @Transactional
    public String deleteUser(String email) {
        User user=em.find(User.class,email);
        em.remove(user);
        return "User has been deleted successfully";
    }

    @Override
    public String updateUser(String email) {
        return "";
    }

    @Override
    public User getUser(String email) {
        User user= em.find(User.class, email);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("FROM User",User.class).getResultList();
    }
}
