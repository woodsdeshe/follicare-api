package com.example.Follicare.service;

import com.example.Follicare.exceptions.NotFoundException;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialistService {

    private SpecialistRepository specialistRepository;


    @Autowired
    public void setSpecialistRepository(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }

    /**
     * getAllSpecialists retrieves the list of all specialists from the specialist repository.
     * If there are no specialists in the database, a NotFoundException is thrown
     * @return a list of specialists
     * @throws NotFoundException If no specialists are found in the database.
     */
    public List<Specialist> getAllSpecialists() {
        List<Specialist> allSpecialists = specialistRepository.findAll();
        if (allSpecialists.size() > 0) {
            return allSpecialists;
        } else {
            throw new NotFoundException("No specialists found");
        }
    }

    /**
     * Retrieves a list of specialists based on the given specialty.
     *
     * @param specialty The specialty to filter specialists by.
     * @return A list of specialists specializing in the given specialty.
     * @throws NotFoundException If no specialists are found for the given specialty.
     */
    public List<Specialist> getSpecialistBySpecialty(String specialty) {
        List<Specialist> specialist = specialistRepository.findAllBySpecialty(specialty);

        if (specialist.isEmpty()) {
            throw new NotFoundException("Specialist with " + specialty + " specialty not found");
        } else {
            return specialist;
        }

    }

    /**
     * Retrieves a list of specialists based on the provided zip code.
     *
     * @param zipCode The zip code to search for
     * @return A list of specialists in the given zip code
     * @throws NotFoundException if no specialist is found in the given zip code
     */
    public List<Specialist> getSpecialistByZipCode(String zipCode) {
        List<Specialist> specialist = specialistRepository.findAllByZipCode(zipCode);

        if (specialist.isEmpty()) {
            throw new NotFoundException("Specialist in zipcode " + zipCode + " not found");
        } else {
            return specialist;
        }
    }

    /**
     * Retrieves a list of specialists based on the provided zip code and specialty.
     *
     * @param zipCode   The zip code to search for
     * @param specialty The specialty to search for
     * @return A list of specialists in the given zip code and specialty
     * @throws NotFoundException if no specialist is found in the given zip code or specialty
     */
    public List<Specialist> getSpecialistByZipCodeAndSpecialty(String zipCode, String specialty) {
        List<Specialist> specialist = specialistRepository.findAllBySpecialtyAndZipCode(specialty, zipCode);

        if (specialist.isEmpty()) {
            throw new NotFoundException("Specialist in zipcode " + zipCode + " or specialty " + specialty + " not found");
        } else {
            return specialist;
        }
    }
}
