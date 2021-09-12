package com.blorfer.main.BlipLike;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/BlipLike")
@AllArgsConstructor
public class BlipLikeController {

    private BlipLikeService blipLikeService;

    @GetMapping(path = "/getAllLikes")
    public List<BlipLike> getAllLikes() {
        return blipLikeService.getAllLikes();
    }
    @GetMapping(path = "/getLikeById/{id}")
    public BlipLike getLikeById(@PathVariable Long id) {
        return blipLikeService.getLikeById(id);
    }
    @PostMapping(path = "/createNewLike/{blipAccountId}")
    public void createLike(@PathVariable Long blipAccountId,
                           @RequestParam Long blipId) {
        blipLikeService.createNewLikeByIdToId(blipAccountId, blipId);
    }
    @DeleteMapping(path = "/deleteLikeById/{id}")
    public void deleteLikeById(@PathVariable Long id) {
        blipLikeService.deleteById(id);
    }
}
