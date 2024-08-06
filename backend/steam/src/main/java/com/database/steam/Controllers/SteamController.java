package com.database.steam.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.database.steam.DTOs.Game;
import com.database.steam.DTOs.GameWithScore;
import com.database.steam.DTOs.MostFavoritedGame;
import com.database.steam.Services.CreatorService;
import com.database.steam.Services.GameService;

@RestController
@RequestMapping("/api/games")
public class SteamController {

    @Autowired
    private GameService gameService;

    @Autowired
    private CreatorService creatorService;

    @GetMapping("/all-games")
    public List<Game> testConnection() {
        return gameService.getAllGames();
    }

    @GetMapping("/get-most-favorited")
    public List<Game> getMostFavorited() {
        return gameService.getMostFavorited();
    }

    @GetMapping("/game-info/{name}")
    public Game getGameInfo(@PathVariable("name") String name) {
        return gameService.getGameInfo(name);
    }

    @GetMapping("/reccomendations/{name}")
    public List<Game> getReccomendations(@PathVariable("name") String name) {
        return gameService.getRecommendations(name);
    }

    @GetMapping("/get-game-scores/{appIds}")
    public List<GameWithScore> getGameScores(@PathVariable("appIds") List<String> appIds) {
        return gameService.getGamesWithScore(appIds);
    }

    @GetMapping("/recent-games/{creatorId}")
    public List<Game> getRecentGames(@PathVariable("creatorId") String creatorId) {
        return gameService.getRecentGames(creatorId);
    }

    @GetMapping("/get-leaderboard")
    public List<MostFavoritedGame> getLeaderboard() {
        return gameService.getLeaderboard();
    }

    @GetMapping("/get-recommendations-by-developers/{name}")
    public List<Game> getRecommendationsByDevelopers(@PathVariable("name") String name) {
        return gameService.getRecommendationsByDevelopers(name);
    }
}
