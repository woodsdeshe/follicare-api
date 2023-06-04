package com.example.Follicare.controller;

import com.example.Follicare.model.User;
import com.example.Follicare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}