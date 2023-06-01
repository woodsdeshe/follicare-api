package com.example.Follicare.repository;

import com.example.Follicare.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    Optional<Specialist> findById(Long specialistId);

    Optional<Specialist> findSpecialistByZipCode(Character zipCode);

    Optional<Specialist> findSpecialistBySpecialty(String specialty);

    Optional<Specialist>findSpecialistBySpecialtyAndZipCode(String specialty, Character zipCode);
}
