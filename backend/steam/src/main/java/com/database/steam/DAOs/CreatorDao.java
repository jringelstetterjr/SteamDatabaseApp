package com.database.steam.DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.database.steam.MySQLConnection;
import com.database.steam.DTOs.Creator;

@Repository
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

    public List<Creator> getTopCreators() {
        List<Creator> creators = new ArrayList<>();
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT c.publishers, COUNT(s.Positive) as reviews FROM creator c JOIN game g ON g.AppID = c.AppID JOIN score s on s.AppID = g.APPID " +
                        "WHERE c.Publishers != '' group by c.Publishers order by reviews desc LIMIT 10;";

        try (ResultSet resultSet = mySQLConnection.executeQuery(sql)) {
            while (resultSet.next()) {
                creators.add(new Creator(
                    resultSet.getInt("creatorID"),
                    resultSet.getInt("appId"),
                    resultSet.getString("supportEmail"),
                    resultSet.getString("publishers"),
                    resultSet.getString("developers"),
                    resultSet.getString("supportUrl")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return creators;
    }
}
