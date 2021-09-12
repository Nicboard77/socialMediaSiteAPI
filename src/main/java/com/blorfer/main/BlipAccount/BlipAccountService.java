package com.blorfer.main.BlipAccount;

import com.blorfer.main.UserProfile.UserProfile;
import com.blorfer.main.UserProfile.UserProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@AllArgsConstructor
@Service
public class BlipAccountService {

    private final BlipAccountRepository blipAccountRepository;
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public List<BlipAccount> getAllAccounts() {
        return blipAccountRepository.findAll();
    }

    public void createNewBlipAccountFromId(Long id,
                                           String username) {
        UserProfile profile = userProfileRepository.getById(id);
        BlipAccount blipAccount = new BlipAccount(profile, username);
        blipAccountRepository.save(blipAccount);
    }

    public Optional<BlipAccount> getBlipAccount(Long id) {
        return blipAccountRepository.findById(id);
    }

    public void deleteBlipAccountById(Long id) {
        blipAccountRepository.deleteById(id);
    }

    public void updateBlipAccountUsernameById(Long id, String username) {
        BlipAccount accountToUpdate = blipAccountRepository.getById(id);
        if(username != null) {
            accountToUpdate.setUsername(username);
        }
    }
}
