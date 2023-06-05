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


    /**
     * Returns a list of all specialists.
     *
     * @return List of all specialists
     */
    @GetMapping(path = "")
    public List<Specialist> getAllSpecialists(){
        return specialistService.getAllSpecialists();
    }

    /**
     * Returns a list of specialists based on the specified specialty.
     *
     * @param specialty Specialty of the specialists
     * @return List of specialists matching the specified specialty
     */
    @GetMapping(params = "specialty")
    public List<Specialist> getSpecialistBySpecialty(@RequestParam("specialty") String specialty) {
        return specialistService.getSpecialistBySpecialty(specialty);
    }

    /**
     * Returns a list of specialists based on the specified zip code.
     *
     * @param zipCode Zip code of the specialists
     * @return List of specialists matching the specified zip code
     */
    @GetMapping(params = "zipCode")
    public List<Specialist> getSpecialistByZipCode(@RequestParam("zipCode") String zipCode) {
        return specialistService.getSpecialistByZipCode(zipCode);
    }

    /**
     * Returns a list of specialists based on the specified zip code and specialty.
     *
     * @param specialty Specialty of the specialists
     * @param zipCode Zip code of the specialists
     * @return List of specialists matching the specified zip code and specialty
     */
    @GetMapping(params = {"specialty", "zipCode"})
    public List<Specialist> getSpecialistByZipCodeAndSpecialty(@RequestParam("specialty") String specialty,
                                                               @RequestParam("zipCode") String zipCode) {
        return specialistService.getSpecialistByZipCodeAndSpecialty(zipCode, specialty);
    }
}
