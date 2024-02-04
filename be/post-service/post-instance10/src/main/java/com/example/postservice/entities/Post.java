package com.example.postservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "privacy")
    private Long privacy;
    @Column(name = "content")
    private String content;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    public Post() {
    }

    public Post(Long id, Long userId, Long privacy, String content, LocalDateTime createdTime) {
        this.id = id;
        this.userId = userId;
        this.privacy = privacy;
        this.content = content;
        this.createdTime = createdTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Long privacy) {
        this.privacy = privacy;
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
