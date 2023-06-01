package com.example.Follicare.controller;

import com.example.Follicare.model.Specialist;
import com.example.Follicare.service.SpecialistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/specialists")
public class SpecialistController {

    private SpecialistService specialistService;

    //Functionality: Returns a list of all specialists
    // Path: http://localhost:8080/api/specialists
    @GetMapping(path = "")
    public List<Specialist> getAllSpecialists(){
        return specialistService.getAllSpecialists();
    }
}
