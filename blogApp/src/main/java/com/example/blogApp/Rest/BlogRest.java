package com.example.blogApp.Rest;


import com.example.blogApp.DAO.BlogDao;
import com.example.blogApp.DAO.UserDao;
import com.example.blogApp.Entity.Blog;
import com.example.blogApp.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class BlogRest {
    BlogDao blogDao;
    UserDao dao;
    public BlogRest(BlogDao blogDao, UserDao dao) {
        this.blogDao = blogDao;
        this.dao=dao;
    }

    @GetMapping("/user/blog")
    public List<Blog> blog(){
        List<Blog> blogs = blogDao.getAllBlogs();
        return blogs;
    }

    @PostMapping("/user/blog/{id}")
    public String addBlog(@RequestBody Blog blog,
                          @PathVariable int id) {

        Blog newBlog = new Blog();

        newBlog.setTitle(blog.getTitle());
        newBlog.setBlog(blog.getBlog());

        User user = dao.gerUserById(id);
        newBlog.setUser(user);

        newBlog.setCreatedAt(LocalDateTime.now());


        System.out.println("USER = " + user);
        System.out.println("USER ID = " + (user != null ? user.getId() : null));

        newBlog.setUser(user);

        System.out.println("BLOG USER = " + newBlog.getUser());

        return blogDao.addBlog(newBlog);
    }

    @DeleteMapping("/user/blog")
    public String deleteBlog(@RequestParam String title){
        return blogDao.deleteBlog(title);
    }


}
