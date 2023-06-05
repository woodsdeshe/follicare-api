package com.example.Follicare.repository;

import com.example.Follicare.model.Profiles;
import com.example.Follicare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profiles, Long> {

    Optional<Profiles> findByUser(User user);

    Optional<Profiles> findByUser(Optional<User> user);
}
