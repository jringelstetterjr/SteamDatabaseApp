package com.database.steam.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.steam.DAOs.UserDao;
import com.database.steam.DTOs.Game;
import com.database.steam.DTOs.User;


@Service
public class UserService {

    @Autowired
    UserDao userDao;
    
    public String createUser(String username, String password, String displayName) {
        return userDao.createUser(username, password, displayName);
    }

    public List<Game> getUserFavorites(String username) {
        return userDao.getUserFavorites(username);
    }

    public boolean validateUser(String username, String password) {
        return userDao.validateUser(username, password);
    }

    public String addFavorite(String username, String appId) {
        return userDao.addFavorite(username, appId);
    }

    public String removeFavorite(String username, String appId) {
        return userDao.removeFavorite(username, appId);
    }

    public String addFriend(String username1, String username2) {
        return userDao.addFriend(username1, username2);
    }

    public String follow(String username1, String username2) {
        return userDao.follow(username1, username2);
    }

    public List<User> getUsers(String username, String displayName) {
        return userDao.getUsers(username, displayName);
    }

    public List<User> getUserFollowers(String username) {
        return userDao.getUserFollowers(username);
    }

    public List<User> getUserFollowing(String username) {
        return userDao.getUserFollowing(username);
    }
}
