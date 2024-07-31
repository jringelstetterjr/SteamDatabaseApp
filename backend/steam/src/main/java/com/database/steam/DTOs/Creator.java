package com.database.steam.DTOs;

public class Creator {
    private int creatorID;
    private int appId;
    private String supportEmail;
    private String publishers;
    private String developers;
    private String supportUrl;


    /**
     * Constructors
     */
    public Creator() {}

    public Creator(int creatorID, int appId, String supportEmail, String publishers, String developers, String supportUrl) {
        this.creatorID = creatorID;
        this.appId = appId;
        this.supportEmail = supportEmail;
        this.publishers = publishers;
        this.developers = developers;
        this.supportUrl = supportUrl;
    }

    /**
     * Getters and Setters
     */
    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getSupportEmail() {
        return supportEmail;
    }

    public void setSupportEmail(String supportEmail) {
        this.supportEmail = supportEmail;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public String getSupportUrl() {
        return supportUrl;
    }

    public void setSupportUrl(String supportUrl) {
        this.supportUrl = supportUrl;
    }
}
