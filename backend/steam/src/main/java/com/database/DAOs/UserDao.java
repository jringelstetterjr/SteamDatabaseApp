package com.database.DAOs;

import java.util.ArrayList;
import java.util.List;

import com.database.steam.MySQLConnection;

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
}
