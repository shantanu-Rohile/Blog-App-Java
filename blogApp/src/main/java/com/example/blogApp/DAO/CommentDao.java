package com.example.blogApp.DAO;

import com.example.blogApp.Entity.Comment;

import java.util.List;

public interface CommentDao {
    public String addComment(Comment comment);
    public List<Comment> getAllComments();
    public List<Comment> getAllCommentsByBlog(int blogId);
    public String deleteComment(int commentId);

}
