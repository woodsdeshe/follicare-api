package com.example.Follicare.repository;

import com.example.Follicare.model.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourcesRepository extends JpaRepository<Resources, Long> {
    /**
     * Retrieves a list of resources that have a title containing the specified partial title.
     *
     * @param partialTitle Partial title to search for
     * @return List of resources matching the partial title
     */
    List<Resources> findByTitleLike(String partialTitle);

}
