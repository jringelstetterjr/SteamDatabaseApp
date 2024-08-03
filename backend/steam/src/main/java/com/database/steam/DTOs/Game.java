package com.database.steam.DTOs;

import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Game {
    @Id
    private int appID;
    private String name;
    private String tags;
    private String description;
    private String dlcCount;
    private String genres;
    private Date releaseDate;
    private String categories;
    private boolean windows;
    private boolean mac;
    private boolean linux;

    /**
     * Constructors
     */
    public Game(){}
    
    public Game(int appID, String name, String tags, String description, String dlcCount, String genres, Date releaseDate, String categories, boolean windows, boolean mac, boolean linux) {
    this.appID = appID;
    this.name = name;
    this.tags = tags;
    this.description = description;
    this.dlcCount = dlcCount;
    this.genres = genres;
    this.releaseDate = releaseDate;
    this.categories = categories;
    this.windows = windows;
    this.mac = mac;
    this.linux = linux;
    }

    /*
    * Getters and Setters
    */
    public int getAppID() {
        return appID;
    }

    public void setAppID(int appID) {
        this.appID = appID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDlcCount() {
        return dlcCount;
    }

    public void setDlcCount(String dlcCount) {
        this.dlcCount = dlcCount;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public boolean isWindows() {
        return windows;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public boolean isMac() {
        return mac;
    }

    public void setMac(boolean mac) {
        this.mac = mac;
    }

    public boolean isLinux() {
        return linux;
    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }
}