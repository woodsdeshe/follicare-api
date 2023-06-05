package com.example.Follicare.controller;

import com.example.Follicare.model.Profiles;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.model.User;
import com.example.Follicare.model.UserProfileDTO;
import com.example.Follicare.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfilesController {

    @Autowired
    private ProfilesService profilesService;

    // Functionality: Returns logged-in user's details
    // Path: Path:  http://localhost:8080/api/profile

    @GetMapping("")
    public ResponseEntity<UserProfileDTO> getUserProfile() {
        UserProfileDTO userProfileDTO = profilesService.getUserProfile();
        return ResponseEntity.ok(userProfileDTO);
    }

    // Functionality: Edit user's details
    // Path: Path:  http://localhost:8080/api/profile
    @PutMapping(path = "")
    public void updatedProfileDetails(@RequestBody UserProfileDTO updatedBody) {
        profilesService.updateUserProfile(updatedBody);
    }

    // Functionality: Delete logged-in user's account
    // Path: Path:  http://localhost:8080/api/profile
    @DeleteMapping(path = "")
    public void deleteUserProfile() {
        profilesService.deleteUserProfile();
    }

    // Functionality: Returns a list of specialists in a users' favorites list
    // Path: Path:  http://localhost:8080/api/profile/favorites
    @GetMapping(path = "/favorites/{profileId}")
    public List<Specialist> getAllSpecialistsInFavorites(@PathVariable Long profileId) {
        return profilesService.getSpecialistsInFavorites(profileId);
    }

}
