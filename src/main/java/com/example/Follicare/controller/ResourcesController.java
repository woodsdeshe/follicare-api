package com.example.Follicare.controller;

import com.example.Follicare.model.Resources;
import com.example.Follicare.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    // Functionality: Returns a list of all resources
    // Path: http://localhost:8080/api/resources
    @GetMapping(path = "")
    public List<Resources> getAllResources() {
        return resourcesService.getAllResources();
    }
}
