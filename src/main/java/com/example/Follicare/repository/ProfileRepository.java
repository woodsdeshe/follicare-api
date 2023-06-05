package com.example.Follicare.repository;

import com.example.Follicare.model.Profiles;
import com.example.Follicare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profiles, Long> {

    /**
     * Retrieves the profile associated with the given user.
     *
     * @param user User object
     * @return Optional containing the profile of the user, if found
     */
    Optional<Profiles> findByUser(User user);
}
