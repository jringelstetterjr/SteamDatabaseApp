package com.database.steam.DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.database.steam.MySQLConnection;
import com.database.steam.DTOs.Game;
import com.database.steam.DTOs.GameWithScore;
import com.database.steam.DTOs.MostFavoritedGame;

@Repository
public class GameDao {
    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        MySQLConnection mySQLConnection = new MySQLConnection();
        String prodcall = "{call get_all_games()}";

        try (ResultSet resultSet = mySQLConnection.executeStoredProc(prodcall)) {
            games = getGamesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    public List<Game> getMostFavorited() {
        List<Game> games = new ArrayList<>();
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT g.*, COUNT(uf.Username) AS favorite_count FROM user_favorites uf JOIN game g ON g.AppID = uf.AppID GROUP BY uf.AppID "
                     + "ORDER BY favorite_count DESC LIMIT 10;";

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

    public List<GameWithScore> getGamesWithScore(List<String> appIds) {
        List<GameWithScore> games = new ArrayList<>();
        MySQLConnection mySQLConnection = new MySQLConnection();
        StringBuilder sql = new StringBuilder("SELECT * FROM Game g JOIN Score s on g.AppId = s.AppId WHERE g.AppId in (?");

        for (int i = 1; i < appIds.size(); i++) {
            sql.append(", ?");
        }

        sql.append(")");

        try (ResultSet resultSet = mySQLConnection.executePreparedStatement(sql.toString(), new ArrayList<>(appIds))) {
            games = getGamesWithScoreFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        return games;

    }

    public List<Game> getRecentGames(String creatorId) {
        List<Game> games = new ArrayList<>();
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT g.* FROM game g JOIN creator c ON c.AppID = g.AppID WHERE c.Developers LIKE (SELECT Developers FROM creator " 
        + " WHERE CreatorID = ?) ORDER BY g.ReleaseDate DESC LIMIT 10;";

        try (ResultSet resultSet = mySQLConnection.executePreparedStatement(sql, new ArrayList<>(List.of(creatorId)))) {
            games = getGamesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        return games;
    }

    public List<MostFavoritedGame> getLeaderboard() {
        List<MostFavoritedGame> games = new ArrayList<>();
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT g.Name, COUNT(uf.Username) AS favorite_count FROM user_favorites uf " 
            + " JOIN game g ON g.AppID = uf.AppID GROUP BY uf.AppID ORDER BY favorite_count DESC LIMIT 5";

        try (ResultSet resultSet = mySQLConnection.executeQuery(sql)) {
            games = getMostFavoritedGamesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    public List<Game> getRecommendationsByDevelopers(String name) {
        List<Game> games = new ArrayList<>();
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT b.* FROM steam.game g JOIN steam.game b ON g.tags LIKE b.tags " + 
            " JOIN steam.creator c ON g.AppID = c.AppID JOIN steam.creator d ON g.AppId = d.AppID " + 
            " WHERE g.AppID <> b.AppID  AND g.Name = ? AND d.Developers LIKE C.Developers LIMIT 10";

        try (ResultSet resultSet = mySQLConnection.executePreparedStatement(sql, new ArrayList<>(List.of(name)))) {
            games = getGamesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    private List<Game> getGamesFromResultSet(ResultSet resultSet) throws SQLException {
        List<Game> games = new ArrayList<>();

        while (resultSet.next()) {
            games.add(new Game(resultSet.getInt("AppID"), resultSet.getString("Name"), resultSet.getString("Tags"),
            resultSet.getString("Description"), resultSet.getString("DLCCount"), resultSet.getString("Genres"),
            resultSet.getDate("ReleaseDate"), resultSet.getString("Categories"), resultSet.getBoolean("Windows"),
            resultSet.getBoolean("Mac"), resultSet.getBoolean("Linux")));
        }

        return games;
    }
    private List<GameWithScore> getGamesWithScoreFromResultSet(ResultSet resultSet) throws SQLException {
        List<GameWithScore> games = new ArrayList<>();

        while (resultSet.next()) {
            games.add(new GameWithScore(resultSet.getInt("AppID"), resultSet.getString("Name"),
            resultSet.getString("DLCCount"), resultSet.getString("Genres"),
            resultSet.getDate("ReleaseDate"), resultSet.getBoolean("Windows"),
            resultSet.getBoolean("Mac"), resultSet.getBoolean("Linux"), resultSet.getInt("ScoreRank"),
            resultSet.getInt("Positive"), resultSet.getInt("Negative")));
        }

        return games;
    }

    private List<MostFavoritedGame> getMostFavoritedGamesFromResultSet(ResultSet resultSet) throws SQLException {
        List<MostFavoritedGame> games = new ArrayList<>();

        while (resultSet.next()) {
            games.add(new MostFavoritedGame(resultSet.getString("Name"), resultSet.getInt("favorite_count")));
        }

        return games;
    }
}
