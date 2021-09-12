package com.blorfer.main.BlipComment;

import com.blorfer.main.Blip.Blip;
import com.blorfer.main.Blip.BlipRepository;
import com.blorfer.main.BlipAccount.BlipAccount;
import com.blorfer.main.BlipAccount.BlipAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class BlipCommentService {

    private BlipCommentRepository blipCommentRepository;
    private BlipAccountRepository blipAccountRepository;
    private BlipRepository blipRepository;

    public List<BlipComment> getAllComments() {
        return blipCommentRepository.findAll();
    }

    public BlipComment getCommentById(Long id) {
        return blipCommentRepository.getById(id);
    }

    public void createNewCommentByIdToId(Long blipAccount, Long blip) {
        BlipAccount commenter = blipAccountRepository.getById(blipAccount);
        Blip blipToCommentTo = blipRepository.getById(blip);

        BlipComment newComment = new BlipComment();
        newComment.setBlipCommentPoster(commenter);
        newComment.setBlipToPost(blipToCommentTo);
        newComment.setCreatedAt(LocalDateTime.now());
    }

    public void deleteCommentById(Long id) {
        blipCommentRepository.deleteById(id);
    }

    public void updateCommentById(Long id, String commentContent) {
        BlipComment blipCommentToUpdate = blipCommentRepository.getById(id);
        blipCommentToUpdate.setCommentContent(commentContent);

    }
}
