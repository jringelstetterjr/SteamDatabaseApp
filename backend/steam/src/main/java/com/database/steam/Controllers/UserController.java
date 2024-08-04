package com.database.steam.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.database.steam.DTOs.Game;
import com.database.steam.DTOs.User;
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

    @GetMapping("/validate-user/{username}/{password}")
    public boolean validateUser(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.validateUser(username, password);
    }

    @PostMapping("/add-favorite/{username}/{appId}")
    public String addFavorite(@PathVariable("username") String username, @PathVariable("appId") String appId) {
        return userService.addFavorite(username, appId);
    }

    @DeleteMapping("/remove-favorite/{username}/{appId}")
    public String removeFavorite(@PathVariable("username") String username, @PathVariable("appId") String appId) {
        return userService.removeFavorite(username, appId);
    }

    @PostMapping("/add-friend/{username1}/{username2}")
    public String addFriend(@PathVariable("username1") String username1, @PathVariable("username2") String username2) {
        return userService.addFriend(username1, username2);
    }

    @PostMapping("/follow/{username1}/{username2}")
    public String follow(@PathVariable("username1") String username1, @PathVariable("username2") String username2) {
        return userService.follow(username1, username2);
    }

    @GetMapping("/get-users")
    public List<User> getUsers(@RequestParam(value = "username", required = false) String username,
                               @RequestParam(value = "displayName", required = false) String displayName) {
        return userService.getUsers(username, displayName);
    }

    @GetMapping("/get-user-followers/{username}")
    public List<User> getUserFollowers(@PathVariable("username") String username) {
        return userService.getUserFollowers(username);
    }

    @GetMapping("/get-user-following/{username}")
    public List<User> getUserFollowing(@PathVariable("username") String username) {
        return userService.getUserFollowing(username);
    }


}
