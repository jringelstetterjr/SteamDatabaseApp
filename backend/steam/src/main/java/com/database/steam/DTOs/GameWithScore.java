package com.database.steam.DTOs;

import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class GameWithScore {
    @Id
    private int appID;
    private String name;
    private String dlcCount;
    private String genres;
    private Date releaseDate;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private int scoreRank;
    private int positive;
    private int negative;

    /**
     * Constructors
     */
    public GameWithScore(){}
    
    public GameWithScore(int appID, String name, String dlcCount, String genres, Date releaseDate, boolean windows, boolean mac, boolean linux, int scoreRank, int positive, int negative) {
    this.appID = appID;
    this.name = name;
    this.dlcCount = dlcCount;
    this.genres = genres;
    this.releaseDate = releaseDate;
    this.windows = windows;
    this.mac = mac;
    this.linux = linux;
    this.scoreRank = scoreRank;
    this.positive = positive;
    this.negative = negative;
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
    public int getScoreRank() {
        return scoreRank;
    }

    public void setScoreRank(int scoreRank) {
        this.scoreRank = scoreRank;
    }

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }
}