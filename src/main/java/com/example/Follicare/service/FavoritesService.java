package com.example.Follicare.service;

import com.example.Follicare.exceptions.NotFoundException;
import com.example.Follicare.model.Favorites;
import com.example.Follicare.model.Profiles;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.model.User;
import com.example.Follicare.repository.FavoritesRepository;
import com.example.Follicare.repository.ProfileRepository;
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


    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Autowired
    public void setFavoritesRepository(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    /**
     * getFavoritesForUser retrieves the list of all specialists that are in a users favorites list
     *
     * @param profileId
     * @return a list of all specialists in a users favorites list
     * @throws NotFoundException If no profiles aren't found in the database for the specific id
     */
    public List<Specialist> getFavoritesForProfile(Long profileId) {
        Optional<Profiles> profilesOptional = profileRepository.findById(profileId);

        if (profilesOptional.isEmpty()) {
            throw new NotFoundException("Profile not found for id " + profileId);
        }

        Profiles profile = profilesOptional.get();
        List<Favorites> favoritesList = profile.getSpecialist().getFavorites();

        List<Specialist> favorites = new ArrayList<>();
        for (Favorites favorite : favoritesList) {
            Specialist specialist = favorite.getSpecialist();
            favorites.add(specialist);
        }
        return favorites;
    }
}
