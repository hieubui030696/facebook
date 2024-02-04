package com.example.postservice.dtos;

import java.time.LocalDateTime;

public class UserDTO {
    private Long id;

    private String username;
    private String password;
    private Long gender;

    private LocalDateTime createdTime;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, Long gender, LocalDateTime createdTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.createdTime = createdTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
