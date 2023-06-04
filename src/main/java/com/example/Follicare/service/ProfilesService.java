package com.example.Follicare.service;

import com.example.Follicare.exceptions.AlreadyExistsException;
import com.example.Follicare.exceptions.NotFoundException;
import com.example.Follicare.model.Favorites;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.model.User;
import com.example.Follicare.repository.UserRepository;
import com.example.Follicare.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilesService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    // Purpose is to encrypt password when updating profile
    public ProfilesService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    /**
     * Retrieves currently logged-in user's data. If there is no data (Example: After account deletion), an Unauthorized error message is
     * thrown.
     *
     * @return Logged-in user's data
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public User getLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Check that there is a logged-in user
        if (userDetails.getUser() == null || userDetails.getUsername().isEmpty() || userDetails.getUsername() == null) {
            // Return an error if the user is not found
            throw new NotFoundException("User not found");
        }
        // Return the data for the logged-in user
        return userDetails.getUser();
    }


    /**
     * updateMyProfile allows a logged-in user to update their information. Updates but you need to generate a new JWT
     *
     * @param updatedBody the incoming user data requesting to be updated
     * @return the logged-in user's data after the update
     */
    public User updateMyProfile(User updatedBody) {
        // Obtain the ID for the logged-in user
        Optional<User> user = userRepository.findById(getLoggedInUser().getId());
        // Check there is data for the logged-in user
        if (user.isPresent()) {
            // check that the email does not already in the database, and it's not the same as current email
            if (userRepository.existsByEmail(updatedBody.getEmail()) && !user.get().getEmail().equals(updatedBody.getEmail())) {
                throw new AlreadyExistsException("Email already in use");
            }
            // Check that the password field is not empty when updating the password
            if (updatedBody.getPassword() != null && !updatedBody.getPassword().isEmpty()) {
                user.get().setPassword(passwordEncoder.encode(updatedBody.getPassword()));
            }
            // Check that the name field is not empty when updating the name
            if (updatedBody.getUserName() != null && !updatedBody.getUserName().isEmpty()) {
                user.get().setUserName(updatedBody.getUserName());
            }
            // Check that the email field is not empty when updating the email
            if (updatedBody.getEmail() != null && !updatedBody.getEmail().isEmpty()) {
                user.get().setEmail(updatedBody.getEmail());
            }
            // Save the updated data for the logged-in user
            return userRepository.save(user.get());
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
        Optional<User> myProfile = userRepository.findById(getLoggedInUser().getId());
        // Check there is data for the logged-in user
        if (myProfile.isPresent()) {
            // Remove the logged-in user's data from the database by its ID
            userRepository.deleteById(getLoggedInUser().getId());
            // Return the information of the deleted user
            return myProfile.get();
        } else {
            // Throw an error if there is no logged-in user, when you're logged-in...
            throw new NotFoundException("Odd. That wasn't supposed to happen.");
        }
    }

    public List<Specialist> getSpecialistsInFavoritesList() {
        Optional<User> userProfile = userRepository.findById(getLoggedInUser().getId());

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