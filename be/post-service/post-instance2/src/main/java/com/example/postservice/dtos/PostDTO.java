package com.example.postservice.dtos;

import java.time.LocalDateTime;

public class PostDTO {
    private Long id;

    private Long userId;
    private Long privacy;
    private String content;

    private LocalDateTime createdTime;

    public PostDTO() {
    }

    public PostDTO(Long id, Long userId, Long privacy, String content, LocalDateTime createdTime) {
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
