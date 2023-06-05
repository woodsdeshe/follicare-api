package com.example.Follicare.controller;

import com.example.Follicare.exceptions.NotFoundException;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.model.User;
import com.example.Follicare.model.request.LoginRequest;
import com.example.Follicare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/auth/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user.
     *
     * @param userObject The user object containing the user details.
     * @return The created user.
     */
    @PostMapping("/register")
    public User createUser(@RequestBody User userObject) {
        System.out.println("calling createUser ==>");
        return userService.createUser(userObject);
    }

    /**
     * Logs in a user with the provided credentials.
     *
     * @param loginRequest The login request containing the user credentials.
     * @return A response entity with the login result and authentication token.
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        System.out.println("calling loginUser ==>");
        return userService.loginUser(loginRequest);
    }

    /**
     * Retrieves a user by their user ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return An optional containing the user if found, or an empty optional if not found.
     */
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    /**
     * Retrieves the list of specialists in the user's favorites.
     *
     * @param userId The ID of the user.
     * @return The list of specialists in the user's favorites.
     * @throws NotFoundException If the user is not found.
     */
    @GetMapping("/{userId}/favorites")
    public List<Specialist> getUserFavorites(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isEmpty()) {
            // You can handle the case when the user is not found
            // For example, throw an exception or return an empty list
            throw new NotFoundException("User not found");
        }
        return user.get().getFavoritesList();
    }

    /**
     * Adds a specialist to the user's favorites list.
     *
     * @param userId     The ID of the user.
     * @param specialist The specialist to add to the favorites list.
     * @return A message indicating that the specialist was added to the favorites list.
     */
    @PostMapping("/{userId}/favorites")
    public String addSpecialistsToFavorites(@PathVariable Long userId, @RequestBody Specialist specialist) {
        Optional<User> user = userService.getUserById(userId);
        userService.addSpecialistToFavorites(userId, specialist);
        return "Specialist added to favorites list";
    }

    /**
     * Removes a specialist from the user's favorites list.
     *
     * @param userId       The ID of the user.
     * @param specialistId The ID of the specialist to remove from the favorites list.
     * @return A message indicating that the specialist was removed from the favorites list.
     */
    @DeleteMapping("/{userId}/favorites/{specialistId}")
    public String removeSpecialistFromFavorites(@PathVariable Long userId, @PathVariable Long specialistId) {
        userService.removeSpecialistFromFavorites(userId, specialistId);
        return "Specialist removed from favorites list";
    }
}