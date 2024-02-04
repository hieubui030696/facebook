package com.example.postservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="likes")
@IdClass(PrimaryKey.class)
public class Like {
    @Id
    @Column(name = "post_id")
    private Long postId;
    @Id
    @Column(name = "user_id")
    private Long userId;

    public Like() {
    }

    public Like(Long postId, Long userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
