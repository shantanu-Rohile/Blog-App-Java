package com.example.blogApp.DAO;

import com.example.blogApp.Entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    EntityManager em;

    public CommentDaoImpl(EntityManager em){
        this.em=em;
    }

    @Override
    @Transactional
    public String addComment(Comment comment) {
        em.persist(comment);
        return "Comment has been added Successfully";
    }

    @Override
    public List<Comment> getAllComments() {
        List<Comment> result=em.createNativeQuery("SELECT * FROM comment", Comment.class).getResultList();
        return result;
    }

    @Override
    public List getAllCommentsByBlog(int blogId) {
        return em.createNativeQuery(
                "SELECT * FROM comment WHERE blogId = :blogId",
                        Comment.class
                )
                .setParameter("blogId", blogId)
                .getResultList();
    }

    @Override
    @Transactional
    public String deleteComment(int commentId) {
        Comment comment=em.find(Comment.class, commentId);
        em.remove(comment);
        return "Comment has been removed successfully";
    }
}
