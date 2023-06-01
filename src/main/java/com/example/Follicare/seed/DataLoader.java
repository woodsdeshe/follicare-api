package com.example.Follicare.seed;

import com.example.Follicare.model.Specialist;
import com.example.Follicare.repository.SpecialistRepository;
import com.example.Follicare.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    SpecialistRepository specialistRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (specialistRepository.count() == 0) {
            Specialist specialist = new Specialist(1L, "Billy", "Joe")
        }
    }
}
