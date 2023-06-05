package com.example.Follicare.service;

import com.example.Follicare.exceptions.AlreadyExistsException;
import com.example.Follicare.exceptions.NotFoundException;
import com.example.Follicare.model.*;
import com.example.Follicare.repository.ProfileRepository;
import com.example.Follicare.repository.UserRepository;
import com.example.Follicare.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilesService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    private final PasswordEncoder passwordEncoder;

    // Purpose is to encrypt password when updating profile
    public ProfilesService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    /**
     * Retrieves the profile details of the currently logged-in user.
     *
     * @return Profile details of the logged-in user
     */
    public UserProfileDTO getUserProfile() {
        User loggedInUser = getLoggedInUserFromContext();
        Optional<Profiles> userProfileOptional = profileRepository.findByUser(loggedInUser);

        if (userProfileOptional.isPresent()) {
            Profiles userProfile = userProfileOptional.get();
            return new UserProfileDTO(
                    loggedInUser.getUserName(),
                    loggedInUser.getEmail(),
                    userProfile.getFirstName(),
                    userProfile.getLastName(),
                    userProfile.getHairDisorder(),
                    userProfile.getDisorderDescription(),
                    userProfile.getZipCode()
            );
        } else {
            throw new NotFoundException("Profile not found");
        }
    }


    /**
     * Retrieves the currently logged-in user from the security context.
     *
     * @return The logged-in user
     */
    private User getLoggedInUserFromContext() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userDetails.getUser() == null || userDetails.getUsername().isEmpty() || userDetails.getUsername() == null) {
            throw new NotFoundException("User not found");
        }

        return userDetails.getUser();
    }


    /**
     * updateMyProfile allows a logged-in user to update their information. Updates but you need to generate a new JWT
     *
     * @param userProfileDTO the incoming user data requesting to be updated
     * @return the logged-in user's data after the update
     */
    public void updateUserProfile(UserProfileDTO userProfileDTO) {
        User loggedInUser = getLoggedInUserFromContext();
        Optional<Profiles> userProfileOptional = profileRepository.findByUser(loggedInUser);

        if (userProfileOptional.isPresent()) {
            Profiles userProfile = userProfileOptional.get();

            // Update the profile attributes
            userProfile.setFirstName(userProfileDTO.getFirstName());
            userProfile.setLastName(userProfileDTO.getLastName());
            userProfile.setHairDisorder(userProfileDTO.getHairDisorder());
            userProfile.setDisorderDescription(userProfileDTO.getDisorderDescription());
            userProfile.setZipCode(userProfileDTO.getZipcode());

            // Save the updated profile
            profileRepository.save(userProfile);
        } else {
            throw new NotFoundException("Profile not found");
        }
    }


    /**
     * deleteMyProfile deletes the current logged-in user's profile. If the profile is not found (which would be strange) then a
     * NotFoundException is thrown
     *
     * @return the deleted data for the logged-in user
     */
    public void deleteUserProfile() {
        User loggedInUser = getLoggedInUserFromContext();
        Optional<Profiles> userProfileOptional = profileRepository.findByUser(loggedInUser);

        if (userProfileOptional.isPresent()) {
            Profiles userProfile = userProfileOptional.get();

            // Delete the profile
            profileRepository.delete(userProfile);
        } else {
            throw new NotFoundException("Profile not found");
        }
    }

    /**
     * getSpecialistsInFavorites() returns a list of specialists the logged-in user has added to their favorites list. If no specialists are found, a NotFoundException is thrown.
     * If the profile is not found, a NotFoundException is thrown as well.
     *
     * @return a list of specialist objects that have been added to a user's favorites list.
     */
    public List<Specialist> getSpecialistsInFavorites(Long profileId) {
        Optional<Profiles> profilesOptional = profileRepository.findById(profileId);

        if (profilesOptional.isPresent()) {
            Profiles profiles = profilesOptional.get();
            List<Specialist> favoritesList = profiles.getFavorites();

            if (!favoritesList.isEmpty()) {
                return favoritesList;
            } else {
                throw new NotFoundException("No specialists added to favorites");
            }
        } else {
            throw new NotFoundException("Profile not found");
        }
    }
}