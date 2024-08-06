package com.database.steam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MySQLConnection {

    static final String databasePrefix = "steam";
    static final String netID = "root";
    static final String hostName = "localhost";
    static final String databaseURL = "jdbc:mysql://" + hostName + "/" + databasePrefix + "?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false";
    //TODO change password
    static final String password = "password";

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    // Connects to the database
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Database URL: " + databaseURL);
            connection = DriverManager.getConnection(databaseURL, netID, password);
            System.out.println("Successfully connected to the database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Executes a query and prints the results
    public ResultSet executeQuery(String sqlQuery) {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resultSet;
    }

    public int executeStoredProceWithVars(String procedureCall, List<String> params) {
        int affectedRows = 0;
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }

            CallableStatement callableStatement = connection.prepareCall(procedureCall);
            
            for (int i = 0; i < params.size(); i++) {
                callableStatement.setObject(i + 1, params.get(i));
            }
    
            affectedRows = callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public ResultSet executeStoredProcWithVars(String procedureCall, List<String> params) throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }

            CallableStatement callableStatement = connection.prepareCall(procedureCall);

            for (int i = 0; i < params.size(); i++) {
                callableStatement.setObject(i + 1, params.get(i));
            }

            resultSet = callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet executeStoredProc(String procedureCall) throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }

            CallableStatement callableStatement = connection.prepareCall(procedureCall);
            resultSet = callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet executePreparedStatement(String query, List<String> params) {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setString(i + 1, params.get(i));
            }
            
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public int executeUpdatePreparedStatement(String query, List<String> params) {
        int affectedRows = 0;
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
    
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setString(i + 1, params.get(i));
                }
                
                affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return affectedRows;
    }
}
