package com.example.Follicare.repository;

import com.example.Follicare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Checks if a user with the given email exists.
     *
     * @param email Email address to check
     * @return True if a user with the email exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Retrieves the user with the given email.
     *
     * @param email Email address of the user
     * @return User object if found, null otherwise
     */
    User findUserByEmail(String email);
}
