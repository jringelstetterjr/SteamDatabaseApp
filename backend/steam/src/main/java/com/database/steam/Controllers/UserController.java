package com.database.steam.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.steam.DTOs.Game;
import com.database.steam.Services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/create-user/{username}/{password}/{displayName}")
    public String createUser(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("displayName") String displayName) {
        return userService.createUser(username, password, displayName);
    }

    @GetMapping("/get-user-favorites/{username}")
    public List<Game> getUserFavorites(@PathVariable("username") String username) {
        return userService.getUserFavorites(username);
    }
}
