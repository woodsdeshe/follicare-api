package com.example.Follicare.controller;

import com.example.Follicare.model.Specialist;
import com.example.Follicare.model.User;
import com.example.Follicare.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfilesController {

    @Autowired
    private ProfilesService profilesService;

    // Functionality: Returns logged-in user's details
    // Path: Path:  http://localhost:8080/api/profile

    @GetMapping(path = "")
    public User getMyProfile() {
        return profilesService.getLoggedInUser();
    }

    // Functionality: Edit user's details
    // Path: Path:  http://localhost:8080/api/profile
    @PutMapping(path = "")
    public User updatedProfileDetails(@RequestBody User updatedBody) {
        return profilesService.updateMyProfile(updatedBody);
    }

    // Functionality: Delete logged-in user's account
    // Path: Path:  http://localhost:8080/api/profile
    @DeleteMapping(path = "")
    public User deleteUserProfile() {
        return profilesService.deleteMyProfile();
    }

    // Functionality: Returns a list of specialists in a users' favorites list
    // Path: Path:  http://localhost:8080/api/profile/favorites
    @GetMapping(path = "/favorites")
    public List<Specialist> getAllSpecialistsInFavorites() {
        return profilesService.getSpecialistsInFavoritesList();
    }

}
