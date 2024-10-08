package com.database.steam.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.steam.DAOs.GameDao;
import com.database.steam.DTOs.Game;
import com.database.steam.DTOs.GameWithScore;
import com.database.steam.DTOs.MostFavoritedGame;

@Service
public class GameService {

    @Autowired
    GameDao gameDao;

    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    public List<Game> getMostFavorited() {
        return gameDao.getMostFavorited();
    }

    public Game getGameInfo(String name) {
        return gameDao.getGameInfo(name);
    }

    public List<Game> getRecommendations(String name) {
        return gameDao.getRecommendations(name);
    }

    public List<GameWithScore> getGamesWithScore(List<String> appIds) {
        return gameDao.getGamesWithScore(appIds);
    }

    public List<Game> getRecentGames(String creatorId) {
        return gameDao.getRecentGames(creatorId);
    }
    public List<MostFavoritedGame> getLeaderboard() {
        return gameDao.getLeaderboard();
    }

    public List<Game> getRecommendationsByDevelopers(String name) {
        return gameDao.getRecommendationsByDevelopers(name);
    }
}
