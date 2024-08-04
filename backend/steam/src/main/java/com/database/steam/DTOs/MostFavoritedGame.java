package com.database.steam.DTOs;

public class MostFavoritedGame {
    private String name;
    private int favoritedCount;

    public MostFavoritedGame() {
    }

    public MostFavoritedGame(String name, int favoritedCount) {
        this.name = name;
        this.favoritedCount = favoritedCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFavoritedCount() {
        return favoritedCount;
    }

    public void setFavoritedCount(int favoritedCount) {
        this.favoritedCount = favoritedCount;
    }
}
