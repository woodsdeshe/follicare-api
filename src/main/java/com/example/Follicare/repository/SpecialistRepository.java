package com.example.Follicare.repository;

import com.example.Follicare.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    /**
     * Retrieves a list of specialists based on the given zip code.
     *
     * @param zipCode Zip code of the specialists
     * @return List of specialists with the matching zip code
     */
    List<Specialist> findAllByZipCode(String zipCode);

    /**
     * Retrieves a list of specialists based on the given specialty.
     *
     * @param specialty Specialty of the specialists
     * @return List of specialists with the matching specialty
     */
    List<Specialist> findAllBySpecialty(String specialty);

    /**
     * Retrieves a list of specialists based on the given specialty and zip code.
     *
     * @param specialty Specialty of the specialists
     * @param zipCode Zip code of the specialists
     * @return List of specialists with the matching specialty and zip code
     */
    List<Specialist>findAllBySpecialtyAndZipCode(String specialty, String zipCode);

    /**
     * Retrieves a specialist with the given specialist ID.
     *
     * @param specialistId ID of the specialist
     * @return Optional containing the specialist if found, empty otherwise
     */
    Optional<Specialist> findById(Long specialistId);
}
