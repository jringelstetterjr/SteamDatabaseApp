package com.database.steam.Controllers;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.steam.Services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/create-user/{username}/{password}/{displayName}")
    public String createUser(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("displayName") String displayName) {
        return userService.createUser(username, password, displayName);
    }
}
