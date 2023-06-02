package com.example.Follicare.seed;


import com.example.Follicare.model.Specialist;
import com.example.Follicare.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpecialistData implements CommandLineRunner {

    @Autowired
    SpecialistRepository specialistRepository;
    private List<Specialist> specialists;

    @Override
    public void run(String... args) throws Exception {
        loadSpecialistData();
    }

    private void loadSpecialistData() {
        // Seed data for initial setup
        Specialist specialist1 = new Specialist(1L, "Brandy", "Singer", "Alopecia Areata", "49505", "brandy@test.com", "333-333-3333");
        Specialist specialist2 = new Specialist(2L, "Byron", "Test", "Alopecia Areata", "49502", "byron@test.com", "333-333-3333");
        Specialist specialist3 = new Specialist(3L, "Darius", "Lewis", "Male Pattern Baldness", "48205", "darius@test.com", "333-333-3333");

        specialistRepository.save(specialist1);
        specialistRepository.save(specialist2);
        specialistRepository.save(specialist3);
    }

}
