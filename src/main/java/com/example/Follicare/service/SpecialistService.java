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
     */
    public List<Specialist> getAllSpecialists() {
        List<Specialist> allSpecialists = specialistRepository.findAll();
        //Check there is a list of specialists
        if (allSpecialists.size() > 0) {
            // Returns all the specialists in the database
            return allSpecialists;
        } else {
            //Throws an error when there are no businesses in the database
            throw new NotFoundException("No specialists found");
        }
    }

    public Optional<Specialist> getSpecialistBySpecialty(String specialty) {
        // Search for specialist by specialty
        Optional<Specialist> specialist = specialistRepository.findSpecialistBySpecialty(specialty);
        // If specialist is found, return the specialists' data
        if (specialist.isPresent()) {
            return specialist;
        } else {
            // Throw an error if the specialist is not found in the database
            throw new NotFoundException("Specialist with " + specialty + " not found");
        }
    }
}
