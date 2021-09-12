package com.blorfer.main.BlipFollower;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/BlipFollower")
@AllArgsConstructor
public class BlipFollowerController {

    private BlipFollowerService blipFollowerService;

    @GetMapping(path = "/getAllFollowers")
    public List<BlipFollower> getAllFollowers() {
        return blipFollowerService.getAllFollowers();
    }
    @GetMapping(path = "/getFollowerById/{id}")
    public BlipFollower getFollowerById(@PathVariable Long id) {
       return blipFollowerService.getFollowerById(id);
    }
    @PostMapping(path = "/createNewFollowerByIdToId")
    public void createNewFollowerByIdToId(
            @RequestParam Long accountToFollow,
            @RequestParam Long accountFollowing
    ) {
        blipFollowerService.createNewFollower(
                accountToFollow,
                accountFollowing);
    }
    @DeleteMapping(path = "/deleteFollowerById/{id}")
    public void deleteFollowerById(@PathVariable Long id) {
        blipFollowerService.deleteFollowerById(id);
    }
}
