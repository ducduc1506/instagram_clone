package com.example.backend.dto;

public class UserRequestDTO {
    private String username;
    private String email;
    private String password;
    private String avatarUrl;
    private String bio;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String username, String email, String password, String avatarUrl, String bio) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
}
