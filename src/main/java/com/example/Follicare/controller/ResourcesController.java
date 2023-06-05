package com.example.Follicare.controller;

import com.example.Follicare.model.Resources;
import com.example.Follicare.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    /**
     * Returns a list of all resources.
     *
     * @return List of all resources
     */
    @GetMapping(path = "/all")
    public List<Resources> getAllResources() {
        return resourcesService.getAllResources();
    }

    /**
     * Returns a list of resources containing the specified partial title.
     *
     * @param partialTitle Partial title to search for
     * @return List of resources matching the partial title
     */
    @GetMapping
    public List<Resources> getResourcesByPartialTitle(@RequestParam("partialTitle") String partialTitle) {
        String encodedPartialTitle = UriUtils.encode(partialTitle, StandardCharsets.UTF_8);
        return resourcesService.getResourcesByTitle("%" + encodedPartialTitle + "%");
    }
}


