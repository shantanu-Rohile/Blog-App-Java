package com.example.blogApp.DAO;


import com.example.blogApp.Entity.Blog;

import java.util.List;

public interface BlogDao {
    public List<Blog> getAllBlogs();
    public String addBlog(Blog blog);
    public String deleteBlog(String title);
    public String updateBlog(Blog blog);
}
