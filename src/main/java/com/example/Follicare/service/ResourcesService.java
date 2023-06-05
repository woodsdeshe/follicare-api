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

    /**
     * Retrieves a list of all resources.
     *
     * @return A list of all resources
     * @throws NotFoundException if no resources are found
     */
    public List<Resources> getAllResources() {
        List<Resources> allResources = resourcesRepository.findAll();
        if (allResources.size() > 0) {
            return allResources;
        } else {
            throw new NotFoundException("No resources found");
        }
    }

    /**
     * Retrieves a list of resources based on a partial title match.
     *
     * @param partialTitle The partial title to search for
     * @return A list of resources with titles matching the partial title
     * @throws NotFoundException if no resource title matching the partial title is found
     */
    public List<Resources> getResourcesByTitle(String partialTitle) {
        List<Resources> resources = resourcesRepository.findByTitleLike("%" + partialTitle + "%");

        if (resources.isEmpty()) {
            throw new NotFoundException("Resource title of " + partialTitle + " not found");
        } else {
            return resources;
        }
    }
}
