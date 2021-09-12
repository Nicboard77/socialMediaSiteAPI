package com.blorfer.main.BlipAccount;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/BlipAccount")
@AllArgsConstructor
@Transactional
public class BlipAccountController {

    private final BlipAccountService blipAccountService;

    @GetMapping(path = "/getAllAccounts")
    public List<BlipAccount> getAllBlipAccounts() {
        return blipAccountService.getAllAccounts();
    }
    @GetMapping(path = "/getBlipAccountById/{id}")
    public Optional<BlipAccount> getBlipAccountById(@PathVariable Long id) {
        return blipAccountService.getBlipAccount(id);
    }
    @PostMapping(path = "/createNewBlipAccount/{id}")
    public void createNewBlipAccountFromId(@PathVariable Long id,
                                            @RequestParam String username) {
        blipAccountService.createNewBlipAccountFromId(id, username);
    }

    @DeleteMapping(
            path = "/deleteBlipAccountById/{id}"
    )
    public void deleteBlipAccountById(@PathVariable Long id) {
        blipAccountService.deleteBlipAccountById(id);
    }

    @PutMapping(path = "/updateBlipAccountUsernameById/{id}")
    public void updateBlipAccountUsernameById(@PathVariable Long id,
                                              @RequestParam String username) {
        blipAccountService.updateBlipAccountUsernameById(id, username);
    }

}
