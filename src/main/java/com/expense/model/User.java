package com.expense.model;

import java.util.Date;
import java.util.UUID;

public class User {
    private String userId;
    private String email;
    private String passwordHash;
    private boolean isVerified;
    private Date createdAt;

    public User(String email, String passwordHash) {
        this.userId = UUID.randomUUID().toString();
        this.email = email;
        this.passwordHash = passwordHash;
        this.isVerified = false;
        this.createdAt = new Date();
    }

    public String getUserId() { return userId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public boolean isVerified() { return isVerified; }
    public void setVerified(boolean verified) { isVerified = verified; }
    public Date getCreatedAt() { return createdAt; }

    public void register() { this.isVerified = false; System.out.println("User registered: " + email); }
    public void login() { System.out.println("User logged in: " + email); }
    public void updateProfile(String newEmail, String newPasswordHash) { this.email = newEmail; this.passwordHash = newPasswordHash; }
    public void deleteAccount() { System.out.println("Account deleted: " + userId); }
}
