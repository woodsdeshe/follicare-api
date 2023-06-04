package com.example.Follicare.controller;

import com.example.Follicare.model.Specialist;
import com.example.Follicare.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    // Functionality: Returns a lists of specialists in a users favorites list
    // Path:  http://localhost:8080/api/favorites

    public List<Specialist> getFavoritesForProfile(@PathVariable Long profileId) {
        return favoritesService.getListOfSpecialists(profileId);
    }

}
