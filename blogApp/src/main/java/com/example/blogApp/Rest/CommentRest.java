package com.example.blogApp.Rest;

import com.example.blogApp.DAO.CommentDao;
import com.example.blogApp.Entity.Comment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentRest {

    CommentDao dao;

    public CommentRest(CommentDao dao) {
        this.dao = dao;
    }

    @GetMapping("blog/comment/all")
    public List<Comment> getAllCommnets(){
        return dao.getAllComments();
    }

    @GetMapping("blog/comment")
    public List<Comment> getAllCommentsByBlog(int blogId){
        return dao.getAllCommentsByBlog(blogId);
    }

    @PostMapping("blog/comment")
    public String addComment(Comment comment){
        return dao.addComment(comment);
    }

    @DeleteMapping("blog/comment")
    public String deleteComment(int commentId){
        return dao.deleteComment(commentId);
    }
}
