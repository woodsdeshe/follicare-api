package com.example.Follicare.service;


import com.example.Follicare.exceptions.AlreadyExistsException;
import com.example.Follicare.exceptions.NotFoundException;
import com.example.Follicare.model.User;

import com.example.Follicare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;


    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * createUser registeres a new user to the database. There are field checkers in place to make sure that the required sections that must
     * be filled out are not left empty. If the email address already exists in the database, the user data will not be added to the
     * database
     *
     * @param userObject is the data for the user being registered
     * @return the data for the newly registered user
     */
    public User createUser(User userObject) {
        System.out.println("service calling createUser ==>");
        if (!userRepository.existsByEmail(userObject.getEmail())) {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);
        } else {
            throw new AlreadyExistsException("user with email address " + userObject.getEmail() +
                    " already exists");
        }
    }

    public User findUserByEmailAddress(String email) {
        return userRepository.findUserByEmail(email);
    }

//    /**
//     * loginUser will log in a user that exists in the database as long as their credentials (email, password) match, and generates a new JTW
//     * key
//     *
//     * @param loginRequest user credentials (email, password)
//     * @return JWT key
//     */
//    public ResponseEntity<?> loginUser(request.LoginRequest loginRequest) {
//        try {
//            // Authenicates the user by checking the email and password provided
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//            // Sets the authenticated user in the SecurityContext
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            // Obtains the user's details after authentication
//            myUserDetails = (MyUserDetails) authentication.getPrincipal();
//            // Generate a JWT key for the authenticated user
//            final String JWT = jwtUtils.generateJwtToken(myUserDetails);
//            // Return the JWT key
//            return ResponseEntity.ok(new LoginResponse(JWT));
//        } catch (Exception e) {
//            // Returns a 401 status code if the authentication fails
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Error : username or password is incorrect"));
//        }
//    }

    /**
     * getUserById retrieves the user by the user id, if the user id exists. If the user id does not exist, we throw the NotFoundException
     *
     * @param userId is what we're searching by
     * @return the optional of the user
     */
    public Optional<User> getUserById(Long userId) {
        // Obtain a user's data by its ID
        Optional<User> user = userRepository.findById(userId);
        // Check that the targeted user is found
        if (user.isPresent()) {
            // Return the targeted user's data
            return user;
        } else {
            // Throw an error if the user data is not found by its ID
            throw new NotFoundException("User with id " + userId + " not found");
        }
    }
}