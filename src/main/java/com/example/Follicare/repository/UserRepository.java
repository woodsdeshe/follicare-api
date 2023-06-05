package com.example.Follicare.repository;

import com.example.Follicare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // to register
    boolean existsByEmail(String email);

    // to login
    User findUserByEmail(String email);

    User getUserById(Long userId);
}
