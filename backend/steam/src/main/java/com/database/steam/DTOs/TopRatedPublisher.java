package com.database.steam.DTOs;

public class TopRatedPublisher {
    private String publishers;
    private int reviews;

    public TopRatedPublisher(String publishers, int reviews) {
        this.publishers = publishers;
        this.reviews = reviews;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
}
