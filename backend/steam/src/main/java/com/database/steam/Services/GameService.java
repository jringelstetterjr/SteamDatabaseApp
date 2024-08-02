package com.database.steam.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.DAOs.GameDao;
import com.database.steam.DTOs.Game;

@Service
public class GameService {

    @Autowired
    GameDao gameDao;

    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    public Game getGameInfo(String name) {
        return gameDao.getGameInfo(name);
    }

    public List<Game> getRecommendations(String name) {
        return gameDao.getRecommendations(name);
    }
}
