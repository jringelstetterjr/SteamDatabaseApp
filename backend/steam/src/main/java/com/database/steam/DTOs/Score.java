package com.database.steam.DTOs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Score {
    @Id
    private int scoreID;
    private int appId;
    private int scoreRank;
    private int positive;
    private int negative;
    private int metacriticScore;
    private int userScore;
    private String metacriticUrl;

    /**
     * Constructors
     */
    public Score() {}

    public Score(int scoreID, int appId, int scoreRank, int positive, int negative, int metacriticScore, int userScore, String metacriticUrl) {
        this.scoreID = scoreID;
        this.appId = appId;
        this.scoreRank = scoreRank;
        this.positive = positive;
        this.negative = negative;
        this.metacriticScore = metacriticScore;
        this.userScore = userScore;
        this.metacriticUrl = metacriticUrl;
    }

    /**
     * Getters and Setters
     */
    public int getScoreID() {
        return scoreID;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
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

    public int getMetacriticScore() {
        return metacriticScore;
    }

    public void setMetacriticScore(int metacriticScore) {
        this.metacriticScore = metacriticScore;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public String getMetacriticUrl() {
        return metacriticUrl;
    }

    public void setMetacriticUrl(String metacriticUrl) {
        this.metacriticUrl = metacriticUrl;
    }   
}
