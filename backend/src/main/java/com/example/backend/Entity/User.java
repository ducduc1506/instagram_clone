package com.example.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEnity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String avatar_url;
    private String bio;


    public User() {
    }

    public User(String username, String email, String password, String avatar_url, String bio) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar_url =avatar_url;
        this.bio = bio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAvatarUrl() { return avatar_url; }
    public void setAvatarUrl(String avatar_url) { this.avatar_url = avatar_url; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
}
