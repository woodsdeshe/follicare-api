package com.example.Follicare.repository;

import com.example.Follicare.model.Favorites;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
}
