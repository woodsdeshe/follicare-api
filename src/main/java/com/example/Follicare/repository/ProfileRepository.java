package com.example.Follicare.repository;

import com.example.Follicare.model.Profiles;
import com.example.Follicare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profiles, Long> {

    List<Profiles> findByUser(User user);
}
