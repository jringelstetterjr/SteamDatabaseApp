package com.database.steam.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.steam.DAOs.CreatorDao;
import com.database.steam.DTOs.Creator;

@Service
public class CreatorService { 

    @Autowired
    CreatorDao creatorDao;

    public String getCreator(String name) {
        return creatorDao.getCreator(name);
    }

    public List<Creator> getTopCreators() {
        return creatorDao.getTopCreators();
    }
}
