package com.example.Follicare.service;

import com.example.Follicare.exceptions.NotFoundException;
import com.example.Follicare.model.Favorites;
import com.example.Follicare.model.Profiles;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.model.User;
import com.example.Follicare.repository.FavoritesRepository;
import com.example.Follicare.repository.ProfileRepository;
import com.example.Follicare.repository.SpecialistRepository;
import com.example.Follicare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavoritesService {
    private ProfileRepository profileRepository;
    private FavoritesRepository favoritesRepository;

    private SpecialistRepository specialistRepository;


    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Autowired
    public void setFavoritesRepository(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    @Autowired
    public void setSpecialistRepository(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }

    /**
     * getFavoritesForUser retrieves the list of all specialists that are in a users favorites list
     *
//     * @param favoritesId
     * @return a list of all specialists in a users favorites list
     * @throws NotFoundException If no profiles aren't found in the database for the specific id
     */
//    public List<Specialist> getListOfSpecialists(Long favoritesId) {
//        Optional<Favorites> favorites = favoritesRepository.findById(favoritesId);
//
//        if (favorites.isPresent()) {
//            List<Specialist> specialistList = favoritesRepository.findById(favoritesId).get().getSpecialist();
//            if (!specialistList.isEmpty()) {
//                return specialistList;
//            } else {
//                throw new NotFoundException("No specialists in favorites list found");
//            }
//        } else {
//            throw new NotFoundException("No favorites list found in this profile");
//        }
//    }
    public List<Favorites> getListOfAllSpecialistsInUserFavorites() {
        List<Favorites> allSpecialistList = favoritesRepository.findAll();

        if (allSpecialistList.size() > 0) {
            return allSpecialistList;
        } else {
            throw new NotFoundException("No specialists in favorites list found");
        }
    }
}
