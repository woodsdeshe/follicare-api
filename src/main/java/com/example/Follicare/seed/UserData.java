package com.example.Follicare.seed;

import com.example.Follicare.model.Favorites;
import com.example.Follicare.model.Profiles;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.model.User;
import com.example.Follicare.repository.FavoritesRepository;
import com.example.Follicare.repository.ProfileRepository;
import com.example.Follicare.repository.SpecialistRepository;
import com.example.Follicare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    UserService userService;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    FavoritesRepository favoritesRepository;

    @Autowired
    SpecialistRepository specialistRepository;


    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0 && profileRepository.count() == 0 && favoritesRepository.count() == 0 && specialistRepository.count() == 0) {
            // Seed data for initial setup
            User porsha = new User(1L, "PorshaW", "porshaw@gmail.com", "porsha1");
            User bob = new User(2L, "BoBWhit", "BobW@gmail.com", "bob2");
            User kandi = new User(3L, "Kandi1", "kandib@gmail.com", "excape4");

//            userService.createUser(porsha);
//            userService.createUser(bob);
//            userService.createUser(kandi);

            Profiles porshaProfile = new Profiles(1L, "Porsha", "Williams", "Traction Alopecia", "There are a few thin spots of hair along my hairline. I tend to wear my hair in tight ponytails.", "48205");
            Profiles bobProfile = new Profiles(2L, "Bob", "Whitfield", "Male Pattern Baldness", "My hairline has been reseeding as the years have gone by. My hair is thin and more fragile than usual.", "49505");
            Profiles kandiProfile = new Profiles(3L, "Kandi", "Burress", "Alopecia Areata", "I have a few bald spots throughout my head. They range from the size of dimes to the size of quarters.", "48205");

            porshaProfile.setUser(porsha);
            porshaProfile.setUser(bob);
            porshaProfile.setUser(kandi);

            profileRepository.save(porshaProfile);
            profileRepository.save(bobProfile);
            profileRepository.save(kandiProfile);

            System.out.println(porshaProfile);

            // Seed data for initial setup
            Specialist specialist1 = new Specialist(1L, "Brandy", "Singer", "Alopecia Areata", "49505", "brandy@gmail.com", "333-333-3333");
            Specialist specialist2 = new Specialist(2L, "Byron", "Test", "Alopecia Areata", "49502", "byron@gmail.com", "333-333-3333");
            Specialist specialist3 = new Specialist(3L, "Darius", "Lewis", "Male Pattern Baldness", "48205", "darius@gmail.com", "333-333-3333");

            specialistRepository.save(specialist1);
            specialistRepository.save(specialist2);
            specialistRepository.save(specialist3);

            Favorites porshaFavorites = new Favorites();
            porshaFavorites.setProfiles(List.of(porshaProfile));
            porshaFavorites.setSpecialist(specialist1);
            favoritesRepository.save(porshaFavorites);

        }
    }
}
