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

@Service
public class FavoritesService {
    private UserRepository userRepository;
    private ProfileRepository profileRepository;
    private FavoritesRepository favoritesRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
     * @param userId
     * @return a list of all specialists in a users favorites list
     */
    public List<Specialist> getFavoritesForUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new NotFoundException("User not found");
        }

        List<Profiles> profiles = profileRepository.findByUser(user);
        List<Specialist> favorites = new ArrayList<>();

            for (Profiles profile : profiles) {
                List<Favorites> favoritesForProfile = favoritesRepository.findBySpecialist(profile.getSpecialist());
                for (Favorites favorite : favoritesForProfile) {
                    favorites.add(favorite.getSpecialist());
                }
            }
            return favorites;
    }
}
