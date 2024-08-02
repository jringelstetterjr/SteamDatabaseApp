package com.database.steam.DTOs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserFavorites {
    @Id
    private String username;
    @Id
    private int appId;

    /**
     * Constructors
     */
    public UserFavorites() {}

    public UserFavorites(String username, int appId) {
        this.username = username;
        this.appId = appId;
    }

    /**
     * Getters and Setters
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }
}
