package com.example.Follicare.service;

import com.example.Follicare.exceptions.AlreadyExistsException;
import com.example.Follicare.model.User;
import com.example.Follicare.repository.UserRepository;
import org.hibernate.annotations.LazyCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User userObject) {
        System.out.println("service calling createUser ==>");
        if (!userRepository.existsByEmail(userObject.getEmail())) {
            userObject.setPassword((passwordEncoder.encode(userObject.getPassword())));
            return userRepository.save(userObject);
        } else {
            throw new AlreadyExistsException("user with email " + userObject.getEmail() + " already exists");
        }
    }

    public User finduserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
