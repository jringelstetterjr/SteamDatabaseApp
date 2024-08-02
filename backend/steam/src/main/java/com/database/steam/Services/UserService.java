package com.database.steam.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.steam.DAOs.UserDao;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    
    public String createUser(String username, String password, String displayName) {
        return userDao.createUser(username, password, displayName);
    }
}
