package com.blorfer.main.UserProfile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class UserProfileConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            UserProfileRepository repository) {
        return args -> {
            UserProfile maria = new UserProfile(
                    "Maria",
                    "Smith",
                    "maria.smith@gmail.com",
                    "FEMALE",
                    30
            );
            UserProfile mike = new UserProfile(
                    "Mike",
                    "Smith",
                    "mike.smith@gmail.com",
                    "MALE",
                    30
            );
            UserProfile rhionna = new UserProfile(
                    "Rhionna",
                    "Tilley",
                    "rhionna.tiley@gmail.com",
                    "FEMALE",
                    18
            );
            repository.saveAll(
                    List.of(maria,mike,rhionna)
            );
        };
    }
}
