package com.example.postservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="shares")
@IdClass(PrimaryKey.class)
public class Share {
    @Id
    @Column(name = "post_id")
    private Long postId;
    @Id
    @Column(name = "user_id")
    private Long userId;

    public Share() {
    }

    public Share(Long postId, Long userId) {
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
