package com.example.Follicare.seed;

import com.example.Follicare.model.*;
import com.example.Follicare.repository.*;
import com.example.Follicare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProfileRepository profileRepository;



    @Autowired
    SpecialistRepository specialistRepository;

    @Autowired
    ResourcesRepository resourcesRepository;

    @Override
    public void run(String... args) {
        loadUserData();
    }

    private void loadUserData() {

        //  Seed data for initial setup
            User porsha = new User(1L, "PorshaW", "porshaw@gmail.com", "porsha1");
            User bob = new User(2L, "BoBWhit", "BobW@gmail.com", "bob2");
            User kandi = new User(3L, "Kandi1", "kandib@gmail.com", "excape4");

            userService.createUser(porsha);
            userService.createUser(bob);
            userService.createUser(kandi);

            Profiles porshaProfile = new Profiles(1L, "Porsha", "Williams", "Traction Alopecia", "There are a few thin spots of hair along my hairline. I tend to wear my hair in tight ponytails.", "48205");
            Profiles bobProfile = new Profiles(2L, "Bob", "Whitfield", "Male Pattern Baldness", "My hairline has been reseeding as the years have gone by. My hair is thin and more fragile than usual.", "49505");
            Profiles kandiProfile = new Profiles(3L, "Kandi", "Burress", "Alopecia Areata", "I have a few bald spots throughout my head. They range from the size of dimes to the size of quarters.", "48205");

            porshaProfile.setUser(porsha);
            bobProfile.setUser(bob);
            kandiProfile.setUser(kandi);

            profileRepository.save(porshaProfile);
            profileRepository.save(bobProfile);
            profileRepository.save(kandiProfile);


            // Seed data for initial setup
            Specialist specialist1 = new Specialist(1L, "Brandy", "Singer", "Alopecia Areata", "49505", "brandy@gmail.com", "123-456-7809");
            specialistRepository.save(specialist1);
            Specialist specialist2 = new Specialist(2L, "Byron", "Test", "Alopecia Areata", "49502", "byron@gmail.com", "987-654-3120");
            specialistRepository.save(specialist2);
            Specialist specialist3 = new Specialist(3L, "Darius", "Lewis", "Male Pattern Baldness", "48205", "darius@gmail.com", "394-294-6740");
            specialistRepository.save(specialist3);



        // Create the favorites list
        List<Specialist> porshaFavoritesList = new ArrayList<>();
        List<Specialist> bobFavoritesList = new ArrayList<>();
        List<Specialist> kandiFavoritesList = new ArrayList<>();

        porshaFavoritesList.add(specialist1);
        porshaFavoritesList.add(specialist2);

        bobFavoritesList.add(specialist3);

        kandiFavoritesList.add(specialist1);

        // Set the favorites list in  user entity
        porsha.setFavoritesList(porshaFavoritesList);
        bob.setFavoritesList(bobFavoritesList);
        kandi.setFavoritesList(kandiFavoritesList);

        // Save the updated user entity
        userService.updateUser(porsha);
        userService.updateUser(bob);
        userService.updateUser(kandi);


        Resources resource1 = new Resources();
        resource1.setTitle("Understanding Hair Loss: Causes and Treatments");
        resource1.setAuthor("Dr. Samantha Roberts");
        resource1.setDescription("A comprehensive guide on the causes and treatments of hair loss.");
        resourcesRepository.save(resource1);

        Resources resource2 = new Resources();
        resource2.setTitle("Caring for Your Hair: Tips and Advice");
        resource2.setAuthor("Hair Care Magazine");
        resource2.setDescription("Practical tips and advice for maintaining healthy hair.");
        resourcesRepository.save(resource2);

        Resources resource3 = new Resources();
        resource3.setTitle("Living with Alopecia: Personal Stories and Support");
        resource3.setAuthor("Alopecia Support Group");
        resource3.setDescription("Real-life stories and support for individuals living with alopecia.");
        resourcesRepository.save(resource3);
        }
}
