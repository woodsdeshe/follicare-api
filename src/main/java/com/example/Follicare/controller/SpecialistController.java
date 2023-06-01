package com.example.Follicare.controller;

import com.example.Follicare.model.Specialist;
import com.example.Follicare.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specialists")
public class SpecialistController {

    @Autowired
    private SpecialistService specialistService;


    // Functionality: Returns a list of all specialists
    // Path: http://localhost:8080/api/specialists
    @GetMapping(path = "")
    public List<Specialist> getAllSpecialists(){
        return specialistService.getAllSpecialists();
    }

    // Functionality: Returns a list of specialists by specialty
    // Path: "http://localhost:8080/api/specialists?hairDisorder={hairDisorder}";
    @GetMapping(params = "specialty")
    public List<Specialist> getSpecialistBySpecialty(@RequestParam("specialty") String specialty) {
        return specialistService.getSpecialistBySpecialty(specialty);
    }
}
