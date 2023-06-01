package com.example.Follicare.service;

import com.example.Follicare.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialistService {

    private SpecialistRepository specialistRepository;

    @Autowired
    public void setSpecialistRepository(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }
}
