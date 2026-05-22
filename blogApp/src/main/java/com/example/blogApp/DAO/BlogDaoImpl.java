package com.example.blogApp.DAO;

import com.example.blogApp.Entity.Blog;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDaoImpl implements BlogDao {

    EntityManager em;
    public BlogDaoImpl(EntityManager em) {
        this.em=em;
    }

    @Override
    public List<Blog> getAllBlogs() {
       List<Blog> blogs = em.createQuery("FROM Blog", Blog.class).getResultList();
        return blogs;
    }

    @Override
    @Transactional
    public String addBlog(Blog blog) {
        em.persist(blog);
        return "Blog is saved successfully";
    }

    @Override
    @Transactional
    public String deleteBlog(String title) {
        Blog blog=em.find(Blog.class, title);
        em.remove(blog);
        return "The Blog has been deleted successfully";
    }

    @Override
    public String updateBlog(Blog blog) {
        return "";
    }
}
