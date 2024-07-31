package com.database.steam.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.database.steam.MySQLConnection;
import com.database.steam.DTOs.Game;

@Service
public class GameService {

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM Game";

        try (ResultSet resultSet = mySQLConnection.executeQuery(sql)) {
            games = getGamesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    public Game getGameInfo(String name) {
        Game game = null;
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM Game WHERE Name = ?";

        try (ResultSet resultSet = mySQLConnection.executePreparedStatement(sql, new ArrayList<>(List.of(name)))) {
            if (resultSet.next()) {
                game = new Game(resultSet.getInt("AppID"), resultSet.getString("Name"), resultSet.getString("Tags"),
                        resultSet.getString("Description"), resultSet.getString("DLCCount"), resultSet.getString("Genres"),
                        resultSet.getDate("ReleaseDate"), resultSet.getString("Categories"), resultSet.getBoolean("Windows"),
                        resultSet.getBoolean("Mac"), resultSet.getBoolean("Linux"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return game;
    }

    public List<Game> getRecommendations(String name) {
        List<Game> games = new ArrayList<>();
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM steam.game g JOIN steam.score s ON g.AppID = s.AppID WHERE Genres IN (" +
                     "SELECT g.Genres FROM steam.game g WHERE g.Name = ?) AND Name != ? ORDER BY s.Positive desc " +
                     "LIMIT 5";

        try (ResultSet resultSet = mySQLConnection.executePreparedStatement(sql, new ArrayList<>(List.of(name, name)))) {
            games = getGamesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        return games;
    }

    private List<Game> getGamesFromResultSet(ResultSet resultSet) throws SQLException {
        List<Game> games = new ArrayList<>();

        while (resultSet.next()) {
            Game game = new Game(resultSet.getInt("AppID"), resultSet.getString("Name"), resultSet.getString("Tags"),
                    resultSet.getString("Description"), resultSet.getString("DLCCount"), resultSet.getString("Genres"),
                    resultSet.getDate("ReleaseDate"), resultSet.getString("Categories"), resultSet.getBoolean("Windows"),
                    resultSet.getBoolean("Mac"), resultSet.getBoolean("Linux"));
            games.add(game);
        }

        return games;
    }

    public String getCreator(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCreator'");
    }
}
