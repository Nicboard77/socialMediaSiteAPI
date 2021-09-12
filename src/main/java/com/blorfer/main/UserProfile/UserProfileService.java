package com.blorfer.main.UserProfile;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Transactional
@AllArgsConstructor
@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public List<UserProfile> getAllUserProfile() {

        return userProfileRepository.findAll();
    }
    public void addUserProfile(UserProfile userProfile) {
        userProfile.setCreated_at(LocalDateTime.now());
        userProfileRepository.save(userProfile);
    }

    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }

    public void editUserById(Long id,
                             String firstName,
                             String lastName,
                             Integer age,
                             String email,
                             String gender
                             ) {
        UserProfile userToEdit = userProfileRepository.getById(id);
        if(firstName != null) {
            userToEdit.setFirstName(firstName);
        }
        if(lastName != null) {
            userToEdit.setLastName(lastName);
        }
        if(age != null) {
            userToEdit.setAge(age);
        }
        if(email != null) {
            userToEdit.setEmail(email);
        }
        if(gender != null) {
            userToEdit.setGender(gender);
        }

    }

    public Optional<UserProfile> getUserById(Long id) {

        return userProfileRepository.findById(id);
    }
}
