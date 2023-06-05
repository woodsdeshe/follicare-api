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

    /**
     * Returns the details of the logged-in user.
     *
     * @return User profile details
     */
    @GetMapping("")
    public UserProfileDTO getUserProfile() {
        return profilesService.getUserProfile();
    }

    /**
     * Updates the details of the logged-in user.
     *
     * @param updatedBody Updated user profile details
     */
    @PutMapping(path = "")
    public void updatedProfileDetails(@RequestBody UserProfileDTO updatedBody) {
        profilesService.updateUserProfile(updatedBody);
    }

    /**
     * Deletes the account of the logged-in user.
     */
    @DeleteMapping(path = "")
    public void deleteUserProfile() {
        profilesService.deleteUserProfile();
    }

    /**
     * Returns a list of specialists in the favorites list of a user.
     *
     * @param profileId ID of the user profile
     * @return List of specialists in the favorites list
     */
    @GetMapping(path = "/favorites/{profileId}")
    public List<Specialist> getAllSpecialistsInFavorites(@PathVariable Long profileId) {
        return profilesService.getSpecialistsInFavorites(profileId);
    }

}
