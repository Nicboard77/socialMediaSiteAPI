package com.blorfer.main.BlipLike;

import com.blorfer.main.Blip.BlipRepository;
import com.blorfer.main.BlipAccount.BlipAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BlipLikeService {

    private BlipLikeRepository blipLikeRepository;
    private BlipAccountRepository blipAccountRepository;
    private BlipRepository blipRepository;

    public List<BlipLike> getAllLikes() {
        return blipLikeRepository.findAll();
    }

    public BlipLike getLikeById(Long id) {
       return blipLikeRepository.getById(id);
    }

    public void createNewLikeByIdToId(Long blipAccountId, Long blipId) {
        BlipLike newLike = new BlipLike();
        newLike.setBlipAccount(blipAccountRepository.getById(blipAccountId));
        newLike.setBlip(blipRepository.getById(blipId));
        newLike.setCreatedAt(LocalDateTime.now());
        blipLikeRepository.save(newLike);

    }

    public void deleteById(Long id) {
        blipLikeRepository.deleteById(id);
    }
}
