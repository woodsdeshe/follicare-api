package com.example.Follicare.seed;

import com.example.Follicare.model.User;
import com.example.Follicare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    private List<User> userList;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        // Seed data for initial setup
        User user1 = new User(1L, "PorshaW", "porshaw@gmail.com", "porsha1");
        User user2 = new User(2L, "BoBWhit", "BobW@gmail.com", "bob2");
        User user3 = new User(3L, "Kandi1", "kandib@gmail.com", "excape4");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }




}
