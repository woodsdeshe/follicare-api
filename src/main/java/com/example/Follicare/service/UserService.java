package com.example.Follicare.service;


import com.example.Follicare.exceptions.AlreadyExistsException;
import com.example.Follicare.exceptions.BadRequestException;
import com.example.Follicare.exceptions.NotFoundException;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.model.User;

import com.example.Follicare.model.request.LoginRequest;
import com.example.Follicare.model.response.LoginResponse;
import com.example.Follicare.repository.UserRepository;
import com.example.Follicare.security.JWTUtils;
import com.example.Follicare.security.MyUserDetails;
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

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private JWTUtils jwtUtils;
    private AuthenticationManager authenticationManager;
    private MyUserDetails myUserDetails;

    @Autowired
    public UserService(UserRepository userRepository,
                       @Lazy PasswordEncoder passwordEncoder,
                       JWTUtils jwtUtils,
                       @Lazy AuthenticationManager authenticationManager,
                       @Lazy MyUserDetails myUserDetails) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.myUserDetails = myUserDetails;
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
        if (Objects.equals(userObject.getEmail(), "") || userObject.getEmail() == null) {
            throw new BadRequestException("User email is required");
        }
        if (Objects.equals(userObject.getPassword(), "") || userObject.getPassword() == null) {
            throw new BadRequestException("User password is required");
        }
        if (!userRepository.existsByEmail(userObject.getEmail())) {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);
        } else {
            throw new AlreadyExistsException("User with email address " + userObject.getEmail() + " already exists");
        }
    }

    public User findUserByEmailAddress(String email) {
        return userRepository.findUserByEmail(email);
    }

    /**
     * loginUser will log in a user that exists in the database as long as their credentials (email, password) match, and generates a new JTW
     * key
     *
     * @param loginRequest user credentials (email, password)
     * @return JWT key
     */
    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            myUserDetails = (MyUserDetails) authentication.getPrincipal();
            final String JWT = jwtUtils.generateJwtToken(myUserDetails);
            return ResponseEntity.ok(new LoginResponse(JWT));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Error : username or password is incorrect"));
        }
    }

    /**
     * getUserById retrieves the user by the user id, if the user id exists. If the user id does not exist, we throw the NotFoundException
     *
     * @param userId is what we're searching by
     * @return the optional of the user
     */
    public Optional<User> getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user;
        } else {
            throw new NotFoundException("User with id " + userId + " not found");
        }
    }

    /**
     * Updates a user in the database.
     *
     * @param user The user to update
     */
    public void updateUser(User user) {
        userRepository.save(user);
    }

    /**
     * Adds a specialist to the favorites list of a user.
     *
     * @param userId     The ID of the user
     * @param specialist The specialist to add to the favorites list
     */
    public void addSpecialistToFavorites(Long userId, Specialist specialist) {
        Optional<User> optionalUser = getUserById(userId);

        optionalUser.ifPresent(user -> {
            List<Specialist> favoritesList = user.getFavoritesList();
            favoritesList.add(specialist);
            user.setFavoritesList(favoritesList);
            userRepository.save(user);
        });
    }

    /**
     * Removes a specialist from the favorites list of a user.
     *
     * @param userId       The ID of the user
     * @param specialistId The ID of the specialist to remove from the favorites list
     */
    public void removeSpecialistFromFavorites(Long userId, Long specialistId) {
        Optional<User> optionalUser = getUserById(userId);

        optionalUser.ifPresent(user -> {
            List<Specialist> favoritesList = user.getFavoritesList();
            favoritesList.removeIf(specialist -> specialist.getId().equals(specialistId));
            user.setFavoritesList(favoritesList);
            userRepository.save(user);
        });
    }
}