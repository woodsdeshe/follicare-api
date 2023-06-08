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

    /**
     * Loads seed data into the database.
     */
    private void loadUserData() {
            User porsha = new User(1L, "porshaw@gmail.com", "porsha1");
            User bob = new User(2L, "BobW@gmail.com", "bob2");
            User kandi = new User(3L, "kandib@gmail.com", "excape4");

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


            Specialist specialist1 = new Specialist(1L, "Brandy", "Singer", "Alopecia Areata", "49505", "brandy@gmail.com", "123-456-7809");
            specialistRepository.save(specialist1);
            Specialist specialist2 = new Specialist(2L, "Byron", "Test", "Alopecia Areata", "49502", "byron@gmail.com", "987-654-3120");
            specialistRepository.save(specialist2);
            Specialist specialist3 = new Specialist(3L, "Darius", "Lewis", "Male Pattern Baldness", "48205", "darius@gmail.com", "394-294-6740");
            specialistRepository.save(specialist3);
            Specialist specialist4 = new Specialist(4L, "Emma Thompson", "Dermatologist", "Alopecia Areata", "49503", "emma.thompson@gmail.com", "555-123-4567");
            specialistRepository.save(specialist4);
            Specialist specialist5 = new Specialist(5L, "Mohammed Ali", "Trichologist", "Male Pattern Baldness", "49501", "mohammed.ali@gmail.com", "777-888-9999");
            specialistRepository.save(specialist5);

            Specialist specialist6 = new Specialist(6L, "Sophia Nguyen", "Endocrinologist", "Female Pattern Baldness", "49504", "sophia.nguyen@gmail.com", "222-333-4444");
            specialistRepository.save(specialist6);

            Specialist specialist7 = new Specialist(7L, "Muhammad Khan", "Hair Transplant Surgeon", "Androgenetic Alopecia", "48201", "muhammad.khan@gmail.com", "888-999-1111");
            specialistRepository.save(specialist7);

            Specialist specialist8 = new Specialist(8L, "Ava Patel", "Cosmetologist", "Telogen Effluvium", "48203", "ava.patel@gmail.com", "444-555-6666");
            specialistRepository.save(specialist8);

            Specialist specialist9 = new Specialist(9L, "Noah García", "Psychologist", "Trichotillomania", "48204", "noah.garcia@gmail.com", "666-777-8888");
            specialistRepository.save(specialist9);

            Specialist specialist10 = new Specialist(10L, "Mia Kim", "Dermatologist", "Scarring Alopecia", "48202", "mia.kim@gmail.com", "111-222-3333");
            specialistRepository.save(specialist10);




        List<Specialist> porshaFavoritesList = new ArrayList<>();
        List<Specialist> bobFavoritesList = new ArrayList<>();
        List<Specialist> kandiFavoritesList = new ArrayList<>();

        porshaFavoritesList.add(specialist1);
        porshaFavoritesList.add(specialist2);

        bobFavoritesList.add(specialist3);

        kandiFavoritesList.add(specialist1);


        porsha.setFavoritesList(porshaFavoritesList);
        bob.setFavoritesList(bobFavoritesList);
        kandi.setFavoritesList(kandiFavoritesList);


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
        Resources resource4 = new Resources();
        resource4.setTitle("Hair Loss and Self-Esteem: Building Confidence");
        resource4.setAuthor("Dr. Maria Hernandez");
        resource4.setDescription("Exploring the impact of hair loss on self-esteem and strategies to build confidence.");
        resourcesRepository.save(resource4);

        Resources resource5 = new Resources();
        resource5.setTitle("Hair Loss Prevention: Tips for Healthy Hair");
        resource5.setAuthor("Healthy Living Magazine");
        resource5.setDescription("Practical tips for preventing hair loss and maintaining healthy hair.");
        resourcesRepository.save(resource5);

        Resources resource6 = new Resources();
        resource6.setTitle("Wigs and Hairpieces: Finding the Perfect Fit");
        resource6.setAuthor("Wig Experts Online");
        resource6.setDescription("A guide to choosing and wearing wigs and hairpieces with confidence.");
        resourcesRepository.save(resource6);

        Resources resource7 = new Resources();
        resource7.setTitle("Nutrition and Hair Health: Essential Vitamins and Minerals");
        resource7.setAuthor("Dr. Emily Wilson");
        resource7.setDescription("Discover the role of nutrition in promoting healthy hair and the essential vitamins and minerals for hair health.");
        resourcesRepository.save(resource7);

        Resources resource8 = new Resources();
        resource8.setTitle("Stress and Hair Loss: Managing the Connection");
        resource8.setAuthor("Mindfulness Institute");
        resource8.setDescription("Exploring the link between stress and hair loss and techniques for managing stress effectively.");
        resourcesRepository.save(resource8);

        Resources resource9 = new Resources();
        resource9.setTitle("Hair Loss in Women: Causes and Treatment Options");
        resource9.setAuthor("Dr. Amanda Johnson");
        resource9.setDescription("A comprehensive guide on the causes and treatment options for hair loss in women.");
        resourcesRepository.save(resource9);

        Resources resource10 = new Resources();
        resource10.setTitle("Hair Transplant Surgery: What You Need to Know");
        resource10.setAuthor("Hair Restoration Clinic");
        resource10.setDescription("An informative overview of hair transplant surgery, including the procedure, recovery, and potential results.");
        resourcesRepository.save(resource10);

        Resources resource11 = new Resources();
        resource11.setTitle("Caring for Ethnic Hair: Tips and Advice");
        resource11.setAuthor("Natural Hair Enthusiast");
        resource11.setDescription("Specific tips and advice for maintaining and styling ethnic hair.");
        resourcesRepository.save(resource11);

        Resources resource12 = new Resources();
        resource12.setTitle("Hair Loss in African Americans: Causes and Treatment Options");
        resource12.setAuthor("Dr. Jasmine Thompson");
        resource12.setDescription("A comprehensive guide on the causes and treatment options for hair loss in African Americans.");
        resourcesRepository.save(resource12);

        Resources resource13 = new Resources();
        resource13.setTitle("The Beauty of Natural Hair: Embracing Your Roots");
        resource13.setAuthor("Curly Hair Community");
        resource13.setDescription("Celebrating the beauty and versatility of natural hair and providing support for individuals with natural hair textures.");
        resourcesRepository.save(resource13);

        Resources resource14 = new Resources();
        resource14.setTitle("Hair Care for Latinx Community: Embracing Cultural Hair Traditions");
        resource14.setAuthor("Hispanic Hair Experts");
        resource14.setDescription("A guide to hair care practices and products that honor Latinx cultural hair traditions.");
        resourcesRepository.save(resource14);

        Resources resource15 = new Resources();
        resource15.setTitle("Hair Loss in Asian Population: Understanding Unique Challenges");
        resource15.setAuthor("Dr. Wei Chen");
        resource15.setDescription("An in-depth exploration of hair loss patterns and treatment considerations for the Asian population.");
        resourcesRepository.save(resource15);


    }
}
