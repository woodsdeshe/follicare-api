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
     * @param updatedBody the incoming user data requesting to be updated
     * @return the logged-in user's data after the update
     */
    public User updateMyProfile(User updatedBody, Profiles updatedProfile) {
        Optional<User> userOptional = userRepository.findById(getLoggedInUserFromContext().getId());
        Optional<Profiles> profileOptional = profileRepository.findByUser(userOptional);

        if (userOptional.isPresent() && profileOptional.isPresent()) {
            User user = userOptional.get();
            Profiles profile = profileOptional.get();

            if (userRepository.existsByEmail(updatedBody.getEmail()) && !user.getEmail().equals(updatedBody.getEmail())) {
                throw new AlreadyExistsException("Email already in use");
            }

            if (updatedBody.getPassword() != null && !updatedBody.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(updatedBody.getPassword()));
            }
            if (updatedBody.getUserName() != null && !updatedBody.getUserName().isEmpty()) {
                user.setUserName(updatedBody.getUserName());
            }
            if (updatedBody.getEmail() != null && !updatedBody.getEmail().isEmpty()) {
                user.setEmail(updatedBody.getEmail());
            }
            if (updatedProfile.getFirstName() != null && !updatedProfile.getFirstName().isEmpty()) {
                profile.setFirstName(updatedProfile.getFirstName());
            }
            if (updatedProfile.getLastName() != null && !updatedProfile.getLastName().isEmpty()) {
                profile.setLastName(updatedProfile.getLastName());
            }
            if (updatedProfile.getHairDisorder() != null && !updatedProfile.getHairDisorder().isEmpty()) {
                profile.setHairDisorder(updatedProfile.getHairDisorder());
            }
            if (updatedProfile.getDisorderDescription() != null && !updatedProfile.getDisorderDescription().isEmpty()) {
                profile.setDisorderDescription(updatedProfile.getDisorderDescription());
            }
            if (updatedProfile.getZipCode() != null && !updatedProfile.getZipCode().isEmpty()) {
                profile.setZipCode(updatedProfile.getZipCode());
            }

            // Save both user and profile entities
            userRepository.save(user);
            profileRepository.save(profile);

            return user;
        } else {
            return null;
        }
    }


    /**
     * deleteMyProfile deletes the current logged-in user's profile. If the profile is not found (which would be strange) then a
     * NotFoundException is thrown
     *
     * @return the deleted data for the logged-in user
     */
    public User deleteMyProfile() {
        // Obtain the ID for the logged-in user
        Optional<User> myProfile = userRepository.findById(getLoggedInUserFromContext().getId());
        // Check there is data for the logged-in user
        if (myProfile.isPresent()) {
            // Remove the logged-in user's data from the database by its ID
            userRepository.deleteById(getLoggedInUserFromContext().getId());
            // Return the information of the deleted user
            return myProfile.get();
        } else {
            // Throw an error if there is no logged-in user, when you're logged-in...
            throw new NotFoundException("Odd. That wasn't supposed to happen.");
        }
    }

    public List<Specialist> getSpecialistsInFavoritesList() {
        Optional<User> userProfile = userRepository.findById(getLoggedInUserFromContext().getId());

        if (userProfile.isPresent()) {
            List<Specialist> listOfSpecialists = userProfile.get().getListOfSpecialists();

            if (listOfSpecialists.size() > 0) {
                return listOfSpecialists;
            } else {
                throw new NotFoundException("No specialists added to favorites");
            }
        } else {
            throw new NotFoundException("Profile not found");
        }
    }
}