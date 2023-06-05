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

    @PostMapping("/register")
    public User createUser(@RequestBody User userObject) {
        System.out.println("calling createUser ==>");
        return userService.createUser(userObject);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        System.out.println("calling loginUser ==>");
        return userService.loginUser(loginRequest);
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

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

    @PostMapping("/{userId}/favorites")
    public String addSpecialistsToFavorites(@PathVariable Long userId, @RequestBody Specialist specialist) {
        Optional<User> user = userService.getUserById(userId);
        userService.addSpecialistToFavorites(userId, specialist);
        return "Specialist added to favorites list";
    }

    @DeleteMapping("/{userId}/favorites/{specialistId}")
    public String removeSpecialistFromFavorites(@PathVariable Long userId, @PathVariable Long specialistId) {
        userService.removeSpecialistFromFavorites(userId, specialistId);
        return "Specialist removed from favorites list";
    }
}