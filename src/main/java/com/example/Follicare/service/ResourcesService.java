package com.example.Follicare.service;

import com.example.Follicare.exceptions.NotFoundException;
import com.example.Follicare.model.Resources;
import com.example.Follicare.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourcesService {

    private ResourcesRepository resourcesRepository;

    @Autowired
    public void setResourcesRepository(ResourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }

    public List<Resources> getAllResources() {
        List<Resources> allResources = resourcesRepository.findAll();
        // Checks if there is a list of resources
        if (allResources.size() > 0) {
            // Returns all the resources in the database
            return allResources;
        } else {
            // Throws an error when there are no businesses in the database
            throw new NotFoundException("No resources found");
        }
    }

    public List<Resources> getResourcesByTitle(String title) {
        // Search for resource by title
        List<Resources> resources = resourcesRepository.searchResourcesByTitleContainingOrderByTitle(title);

        if (resources.isEmpty()) {
            // Throw an error id the specialist is not found in database
            throw new NotFoundException("Resource title of " + title + " not found");
        } else {
            // If resource is found, return the resources' data
            return resources;
        }
    }
}
