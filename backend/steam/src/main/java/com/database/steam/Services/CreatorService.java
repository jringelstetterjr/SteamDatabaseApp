package com.database.steam.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.steam.DAOs.CreatorDao;

@Service
public class CreatorService { 

    @Autowired
    CreatorDao creatorDao;

    public String getCreator(String name) {
        return creatorDao.getCreator(name);
    }
}
