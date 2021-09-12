package com.blorfer.main.UserProfile;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/UserProfile")
@AllArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;


    @GetMapping(path = "/getAll")
    public List<UserProfile> getAllUserProfile() {

        return userProfileService.getAllUserProfile();
    }

    @GetMapping(path = "/getById/{id}")
    public Optional<UserProfile> getUserById(@PathVariable Long id) {

        return userProfileService.getUserById(id);
    }

    @PostMapping
    public void addUserProfile(@RequestBody UserProfile userProfile) {
        userProfileService.addUserProfile(userProfile);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUserProfileById(@PathVariable Long id) {
        userProfileService.deleteUserProfile(id);
    }

    @PutMapping(path = "/edit/{id}")
    public void editFirstName(@PathVariable Long id,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName,
                              @RequestParam(required = false) Integer age,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) String gender) {
        userProfileService.editUserById(id, firstName, lastName, age, email, gender);
    }
}
