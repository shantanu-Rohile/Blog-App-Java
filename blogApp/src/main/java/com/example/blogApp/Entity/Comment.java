package com.example.blogApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 1000)
    private String comment;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
