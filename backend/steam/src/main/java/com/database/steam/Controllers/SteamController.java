package com.database.steam.Controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.database.steam.DTOs.Creator;
import com.database.steam.DTOs.Game;
import com.database.steam.Services.CreatorService;
import com.database.steam.Services.GameService;

@RestController
public class SteamController {

    @Autowired
    private GameService gameService;

    @Autowired
    private CreatorService creatorService;

    @GetMapping("/all-games")
    public List<Game> testConnection() throws SQLException {
        return gameService.getAllGames();
    }

    @GetMapping("/game-info/{name}")
    public Game getGameInfo(@PathVariable("name") String name) throws SQLException {
        return gameService.getGameInfo(name);
    }

    @GetMapping("/reccomendations/{name}")
    public List<Game> getReccomendations(@PathVariable("name") String name) throws SQLException {
        return gameService.getRecommendations(name);
    }

    @GetMapping("/get-creator/{name}")
    public String getCreator(@PathVariable("name") String name) {
        return creatorService.getCreator(name);
    }
}
