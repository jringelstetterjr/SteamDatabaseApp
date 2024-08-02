package com.database.DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.steam.MySQLConnection;

public class CreatorDao {
    public String getCreator(String name) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT c.Publishers FROM steam.creator c JOIN steam.game g ON c.AppId = g.AppID WHERE g.Name = ?";
        String creator = null;
        
        try (ResultSet resultSet = mySQLConnection.executePreparedStatement(sql, new ArrayList<>(List.of(name)))) {
            if (resultSet.next()) {
                creator = resultSet.getString("publishers");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return creator;
    } 
}
