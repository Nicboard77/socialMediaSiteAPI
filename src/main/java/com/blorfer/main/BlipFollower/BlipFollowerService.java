package com.blorfer.main.BlipFollower;

import com.blorfer.main.BlipAccount.BlipAccount;
import com.blorfer.main.BlipAccount.BlipAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class BlipFollowerService {
    private BlipAccountRepository blipAccountRepository;
    private BlipFollowerRepository blipFollowerRepository;

    public List<BlipFollower> getAllFollowers() {
        return blipFollowerRepository.findAll();
    }


    public void createNewFollower(
            Long accountToFollow,
            Long accountFollowing
    ) {

        if(
                blipAccountRepository.findById(accountToFollow).isPresent() &&
                        blipAccountRepository.findById(accountFollowing).isPresent()
        ) {
            BlipAccount blipAccountToFollow =
                    blipAccountRepository.findById(accountToFollow).get();

            BlipAccount blipAccountFollowing =
                    blipAccountRepository.findById(accountFollowing).get();

            BlipFollower newFollower = new BlipFollower();
            newFollower.setBlipAccountToFollow(blipAccountToFollow);
            newFollower.setBlipAccountFollowing(blipAccountFollowing);
            newFollower.setCreatedAt(LocalDateTime.now()); {
            }

            blipFollowerRepository.save(newFollower);
        }







    }

    public BlipFollower getFollowerById(Long id) {
        return blipFollowerRepository.getById(id);
    }

    public void deleteFollowerById(Long id) {
        blipFollowerRepository.deleteById(id);
    }
}