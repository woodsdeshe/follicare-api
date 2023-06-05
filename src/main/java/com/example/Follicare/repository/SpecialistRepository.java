package com.example.Follicare.repository;

import com.example.Follicare.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {

    List<Specialist> findAllByZipCode(String zipCode);

    List<Specialist> findAllBySpecialty(String specialty);

    List<Specialist>findAllBySpecialtyAndZipCode(String specialty, String zipCode);

    Optional<Specialist> findById(Long specialistId);
;}
