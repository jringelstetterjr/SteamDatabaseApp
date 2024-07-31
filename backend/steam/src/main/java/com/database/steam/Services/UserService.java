package com.database.steam.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.database.steam.MySQLConnection;

@Service
public class UserService {
    
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
