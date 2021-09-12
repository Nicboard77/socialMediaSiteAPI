package com.blorfer.main.Blip;

import com.blorfer.main.BlipComment.BlipComment;
import com.blorfer.main.BlipLike.BlipLike;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/Blip")
@AllArgsConstructor
@Transactional
public class BlipController {

    private BlipService blipService;

    @GetMapping(path = "/getAllBlips")
    public List<Blip> getAllBlips() {
        return blipService.getAllBlips();
    }

    @GetMapping(path = "/getBlipsById/{id}")
    public Blip getBlipById(@PathVariable Long id) {
        return blipService.getBlipById(id);
    }
    @PostMapping(path = "/createNewBlipById/{id}")
    public void createNewBlip(@PathVariable Long id,
                              @RequestBody String content){
        blipService.createNewBlip(id, content);

    }
    @DeleteMapping(path = "/deleteBlipById/{id}")
    public void deleteBlipById(@PathVariable Long id) {
        blipService.deleteBlipById(id);
    }
    @PutMapping(path = "/editBlipContentById/{id}")
    public void editBlipById(@PathVariable Long id,
                             @RequestParam(required = false) String newBlipContent) {
        blipService.editBlipById(id,newBlipContent);

    }
}
