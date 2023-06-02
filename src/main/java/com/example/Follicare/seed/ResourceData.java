package com.example.Follicare.seed;

import com.example.Follicare.model.Resources;
import com.example.Follicare.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ResourceData implements CommandLineRunner {
    @Autowired
    ResourcesRepository resourcesRepository;

    @Override
    public void run(String... args) throws Exception {
        loadResourceData();
    }

    private void loadResourceData() {
        //Seed data for initial setup
        Resources resources1 = new Resources(1L, "Dealing with Alopecia Areata", "Nia Long", "This article talks about how to deal with the shock and confusion of Alopecia Areata");
        Resources resources2 = new Resources(2L, "Male Pattern Baldness", "Homer Simpson", "This article talks about how to deal with the reality of Male Pattern Baldness");
        Resources resources3 = new Resources(3L, "Traction Alopecia", "Meg Griffin", "This article talks about what Traction Alopecia is and how to overcome it");

        resourcesRepository.save(resources1);
        resourcesRepository.save(resources2);
        resourcesRepository.save(resources3);
    }
}
