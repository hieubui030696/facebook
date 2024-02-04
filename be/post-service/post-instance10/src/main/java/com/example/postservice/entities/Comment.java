package com.example.postservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="comments")
@IdClass(PrimaryKey.class)
public class Comment {
    @Id
    @Column(name = "post_id")
    private Long postId;

    @Id
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "content")
    private String content;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    public Comment() {
    }

    public Comment(Long postId, Long userId, String content, LocalDateTime createdTime) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.createdTime = createdTime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
