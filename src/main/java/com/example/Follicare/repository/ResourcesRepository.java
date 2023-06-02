package com.example.Follicare.repository;

import com.example.Follicare.model.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourcesRepository extends JpaRepository<Resources, Long> {

    List<Resources> searchResourcesByTitleContainingOrderByTitle(String title);

}
