package com.database.steam.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.steam.DTOs.Creator;
import com.database.steam.DTOs.TopRatedPublisher;
import com.database.steam.Services.CreatorService;

@RestController
@RequestMapping("/api/creator")
public class CreatorController {

    @Autowired
    private CreatorService creatorService;
    
    @GetMapping("/top-creators")
    public List<TopRatedPublisher> getTopCreators() {
        return creatorService.getTopCreators();
    }

     @GetMapping("/get-creator/{name}")
    public Creator getCreator(@PathVariable("name") String name) {
        return creatorService.getCreator(name);
    }
}
