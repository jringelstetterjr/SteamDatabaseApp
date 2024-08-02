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
        String sql = "SELECT g.* FROM user_favorites uf JOIN game g ON g.AppID = uf.AppID WHERE uf.Username = ?;";
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
}
