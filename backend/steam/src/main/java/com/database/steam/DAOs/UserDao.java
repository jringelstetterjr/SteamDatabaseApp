package com.database.steam.DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.database.steam.MySQLConnection;
import com.database.steam.DTOs.Game;

@Repository
public class UserDao {
    public String createUser(String username, String password, String displayName) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "INSERT INTO user (Username, Password, DisplayName) VALUES (?, ?, ?)";
        int affectedRows = mySQLConnection.executeUpdatePreparedStatement(sql, new ArrayList<>(List.of(username, password, displayName)));
        
        if (affectedRows > 0) {
            return "User created successfully";
        } else {
            return "User creation failed";
        }
    }

    public List<Game> getUserFavorites(String username) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT uf.*, g.name FROM user_favorites uf JOIN game g ON g.AppID = uf.AppID WHERE uf.Username = ?;";
        List<Game> favorites = new ArrayList<>();
        
        try (ResultSet resultSet = mySQLConnection.executePreparedStatement(sql, new ArrayList<>(List.of(username)))) {
            while (resultSet.next()) {
                favorites.add(new Game(resultSet.getInt("AppID"), resultSet.getString("Name"), resultSet.getString("Tags"),
                resultSet.getString("Description"), resultSet.getString("DLCCount"), resultSet.getString("Genres"),
                resultSet.getDate("ReleaseDate"), resultSet.getString("Categories"), resultSet.getBoolean("Windows"),
                resultSet.getBoolean("Mac"), resultSet.getBoolean("Linux")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return favorites;
    }

    public boolean validateUser(String username, String password) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM user WHERE Username = ? AND Password = ?";
        
        try (ResultSet resultSet = mySQLConnection.executePreparedStatement(sql, new ArrayList<>(List.of(username, password)))) {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String addFavorite(String username, String appId) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "INSERT INTO user_favorites (Username, AppID) VALUES (?, ?)";
        int affectedRows = mySQLConnection.executeUpdatePreparedStatement(sql, new ArrayList<>(List.of(username, appId)));
        
        if (affectedRows > 0) {
            return "Favorite added successfully";
        } else {
            return "Favorite addition failed";
        }
    }

    public String removeFavorite(String username, String appId) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "DELETE FROM user_favorites WHERE Username = ? AND AppId = ?";
        int affectedRows = mySQLConnection.executeUpdatePreparedStatement(sql, new ArrayList<>(List.of(username, appId)));
        
        if (affectedRows > 0) {
            return "Favorite removed successfully";
        } else {
            return "Favorite removal failed";
        }
    }

    public String addFriend(String username1, String username2) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql1 = "INSERT INTO user_friends (Username1, Username2) VALUES (?, ?)";
        String sql2 = "INSERT INTO user_friends (Username1, Username2) VALUES (?, ?)";
        
        int affectedRows1 = mySQLConnection.executeUpdatePreparedStatement(sql1, new ArrayList<>(List.of(username1, username2)));
        int affectedRows2 = mySQLConnection.executeUpdatePreparedStatement(sql2, new ArrayList<>(List.of(username2, username1)));
        
        if (affectedRows1 > 0 && affectedRows2 > 0) {
            return "Friendship added successfully";
        } else {
            return "Friendship addition failed";
        }  
    }
}
