//package com.example.Follicare.controller;
//
//import com.example.Follicare.model.Specialist;
//import com.example.Follicare.service.FavoritesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/favorites")
//public class FavoritesController {
//
//    @Autowired
//    private FavoritesService favoritesService;
//
//    // Functionality: Adds specialist to a users favorites list
//    // Path: Path:  http://localhost:8080/api/favorites/{profileId}/add/{specialistId}
//    @PostMapping("/{profileId}/add/{specialistId}")
//    public void addSpecialistToFavorites(@PathVariable Long profileId, @PathVariable Long specialistId) {
//         favoritesService.addSpecialistToFavorites(profileId, specialistId);
//    }
//
//    // Functionality: Adds specialist to a users favorites list
//    // Path: Path:  http://localhost:8080/api/favorites/{profileId}/remove/{specialistId}
//    @DeleteMapping("/{profileId}/remove/{specialistId}")
//    public void removeSpecialistFromFavorites(@PathVariable Long profileId, @PathVariable Long specialistId) {
//        favoritesService.removeSpecialistFromFavorites(profileId, specialistId);
//    }
//
//
//}
