package com.example.Follicare.repository;

import com.example.Follicare.model.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profiles, Long> {

    List<Profiles> findProfilesByUser_Id(Long userId);
}
