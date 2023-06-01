package com.example.Follicare.seed;


import com.example.Follicare.model.Specialist;

import java.util.ArrayList;
import java.util.List;

public class SpecialistData {
    private List<Specialist> specialists;

    public SpecialistData() {
        specialists = new ArrayList<>();
        seedData(); // Loads seed data during object initialization
    }

    public void addSpecialist(Specialist specialist) {
        specialists.add(specialist);
    }

    public List<Specialist> getSpecialists() {
        return specialists;
    }

    private void seedData() {
        // Seed data for initial setup
        Specialist specialist1 = new Specialist(1L, "Brandy", "Singer", "Alopecia Areata", "49505", "brandy@test.com", "333-333-3333");
    }
}
