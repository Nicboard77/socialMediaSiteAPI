package com.blorfer.main.BlipComment;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/BlipComment")
@AllArgsConstructor
@Transactional
public class BlipCommentController {
    private final BlipCommentService blipCommentService;

    @GetMapping(path = "/getAll")
    public List<BlipComment> getAllComments() {
        return blipCommentService.getAllComments();
    }
    @GetMapping (path = "/getCommentById/{id}")
    public BlipComment getCommentById(@PathVariable Long id) {
        return blipCommentService.getCommentById(id);
    }
    @PostMapping(path = "/createNewCommentByIdToId")
    public void createNewCommentByIdToId(@RequestParam Long blipAccount,
                                         @RequestParam Long blip) {
        blipCommentService.createNewCommentByIdToId(blipAccount, blip); {
        }
    }
    @DeleteMapping(path = "/deleteCommentById/{id}")
    public void deleteCommentById(@PathVariable Long id) {
        blipCommentService.deleteCommentById(id);
    }
    @PutMapping(path = "/updateCommentById/{id}")
    public void updateCommentById(
            @PathVariable Long id,
            @RequestBody String commentContent) {
        blipCommentService.updateCommentById(id,commentContent);
    }
}
