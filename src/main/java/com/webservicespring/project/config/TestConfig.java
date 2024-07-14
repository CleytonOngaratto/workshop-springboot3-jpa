package com.webservicespring.project.config;

import com.webservicespring.project.entities.User;
import com.webservicespring.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

//database seeding
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null,  "maria@gmail.com","Maria Brown", "988888888", "123456");
        User u2 = new User(null, "alex@gmail.com","Alex Green",  "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
