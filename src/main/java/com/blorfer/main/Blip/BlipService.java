package com.blorfer.main.Blip;

import com.blorfer.main.BlipAccount.BlipAccount;
import com.blorfer.main.BlipAccount.BlipAccountRepository;
import com.blorfer.main.BlipComment.BlipCommentRepository;
import com.blorfer.main.BlipLike.BlipLikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Transactional
@Service
@AllArgsConstructor
public class BlipService {

    private BlipRepository blipRepository;
    private BlipAccountRepository blipAccountRepository;
    private BlipLikeRepository blipLikeRepository;
    private BlipCommentRepository blipCommentRepository;

    public List<Blip> getAllBlips() {
        return blipRepository.findAll();

    }

    public Blip getBlipById(Long id) {
        return blipRepository.getById(id);
    }

    public void createNewBlip(Long id, String content) {
        Blip newBlip = new Blip();
        newBlip.setBlipAccountId(blipAccountRepository.getById(id));
        newBlip.setBlipContent(content);
        newBlip.setCommentId(blipCommentRepository.findAll());
        newBlip.setLikeId(blipLikeRepository.findAll());
        newBlip.setCreatedAt(LocalDateTime.now());

        blipRepository.save(newBlip);
    }

    public void deleteBlipById(Long id) {
        blipRepository.deleteById(id);
    }

    public void editBlipById(Long id, String newBlipContent) {
        Blip blipToEdit = blipRepository.getById(id);
        blipToEdit.setBlipContent(newBlipContent);
    }
}
